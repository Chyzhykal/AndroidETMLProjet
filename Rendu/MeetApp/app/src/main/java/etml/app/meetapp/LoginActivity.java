/**
 * ETML
 * Author : Boris Hutzli and Aleh Chyzhk
 * Date : 18.12.2019
 * Description : View for login form
 */

package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import etml.app.meetapp.Enums.UserCodes;

import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.InterActivityObjects.InterActivity;
import etml.app.meetapp.Repositories.UserRepository;

/**
 * Manages the activity_login activity
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Fires when created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Gets the necessary views
        Button btnLogin = findViewById(R.id.button);
        Button btnRegister = findViewById(R.id.button5);
        Button btnMap = findViewById(R.id.maps);
        // Checks the given login info

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gets the necessary views
                EditText usernameView = findViewById(R.id.editText);
                EditText passwordView = findViewById(R.id.editText2);

                // Gets the text
                String usernameText = usernameView.getText().toString();
                String passwordText = passwordView.getText().toString();

                // Error view
                TextView errors = findViewById(R.id.error3);

                // If no username or password was specified, display an error message and return
                if(usernameText.isEmpty() || passwordText.isEmpty()){
                    errors.setText("Please fill all enries");
                    return;
                }

                // Checks whether user exists in database
                AsyncConnect connect = new AsyncConnect();
                String params[] = {usernameText, passwordText};
                connect.execute(params);

            }
        });

        // Switches to the register activity
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        /**
         * Maps button, opens map view
         */
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MapsActivity.class));
            }
        });
    }

    /**
     * Checks whether the given user exists in the database
     */
    private class AsyncConnect extends AsyncTask<String, Void, Void> {
        // Stores info of the connected user
        private UserEntity connectedUser;

        /**
         * Attempts to login
         * @param params
         * @return
         */
        protected Void doInBackground(String... params) {
            String login = params[0];
            String pwd = params[1];
            UserRepository  repository =  new UserRepository();
            connectedUser =  repository.loginAttempt(login, pwd);
            return null;
        }

        /**
         * Sets the login result
         * @param result
         */
        @Override
        protected void onPostExecute(Void result) {
            setLoginResult(connectedUser);
        }
    }

    /**
     * Adds info to the session and switches activities
     * @param user
     */
    public void setLoginResult(UserEntity user){

        // Gets the error TextView
        TextView errors = findViewById(R.id.error3);

        // If the connection was successful...
        if (user.getUserCode() == UserCodes.CONNECTED){
            // Add the user's info to the session
            Session.getInstance().addPair("connected", true);
            Session.getInstance().addPair("username", "aleg");
            System.out.println("connected");
            InterActivity.getInstance().userId=user.getId();

            // Displays the browse event activity
            startActivity(new Intent(LoginActivity.this, BrowseEventsActivity.class));

        }

        // If an SQL error occured, display error messsage
        if(user.getUserCode() == UserCodes.SQL_ERROR ) {
            errors.setText("Database error, please try again later or contact our support at chyzhykal@etml.educanet2.ch ");
            return;
        }

        // If the given user wasn't found, display error message
        if(user.getUserCode() == UserCodes.NOT_FOUND ) {
            errors.setText("User not found, please try again ");
            return;
        }

        // If the given password was wrong, display error message
        if(user.getUserCode() == UserCodes.WRONG_PWD ) {
            errors.setText("Wrong password");
            return;
        }
    }
}
