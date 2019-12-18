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
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import etml.app.meetapp.Enums.UserCodes;

import java.text.SimpleDateFormat;

import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.Repositories.UserRepository;
import etml.app.meetapp.database.ConnectMySQL;

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
        Button btnLogin = findViewById(R.id.button);
        Button btnRegister = findViewById(R.id.button5);

        /**
         * Login button
         */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameView = findViewById(R.id.editText);
                EditText passwordView = findViewById(R.id.editText2);
                String usernameText = usernameView.getText().toString();
                String passwordText = passwordView.getText().toString();

                AsyncConnect connect = new AsyncConnect();
                String params[] = {usernameText, passwordText};
                connect.execute(params);
            }
        });
        /**
         * Register button
         */
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    /**
     * Checks wether the given user exists in the database
     */
    private class AsyncConnect extends AsyncTask<String, Void, Void> {
        private UserEntity connectedUser;

        protected Void doInBackground(String... params) {
            String login = params[0];
            String pwd = params[1];
            UserRepository  repository =  new UserRepository();
            connectedUser =  repository.loginAttempt(login, pwd);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //do stuff
            setLoginResult(connectedUser);
        }
    }

    /**
     * Adds info to the session and switches activities
     * @param user
     */
    public void setLoginResult(UserEntity user){
        if (user.getUserCode() == UserCodes.CONNECTED){
            Session.getInstance().addPair("connected", true);
            Session.getInstance().addPair("username", "aleg");
            System.out.println("connected");
            startActivity(new Intent(LoginActivity.this, BrowseEventsActivity.class));

        }
        else{
            System.out.println("not connected");
        }
    }
}
