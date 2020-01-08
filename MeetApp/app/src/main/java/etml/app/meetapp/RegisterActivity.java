/**
 * ETML
 * Author : Boris Hutzli and Aleh Chyzhk
 * Date : 18.12.2019
 * Description : View for register form
 */


package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;

import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.Enums.UserCodes;
import etml.app.meetapp.InterActivityObjects.InterActivity;
import etml.app.meetapp.Repositories.UserRepository;


/**
 * Register view
 */
public class RegisterActivity extends AppCompatActivity {

    /**
     * Fires when created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Gets the required views
        Button btnClick = findViewById(R.id.button3);
        Button btnCancel = findViewById(R.id.button2);

        /**
         * Returns to the login activity
         */
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * Fires once user clicks on register
         */
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView errors = findViewById(R.id.error);

                // Gets the views
                TextView usernameView = findViewById(R.id.editText8);
                TextView phoneNumView = findViewById(R.id.editText5);
                TextView passwordView = findViewById(R.id.editText6);
                TextView passwordConfirmView = findViewById(R.id.editText7);
                TextView yearView =  findViewById(R.id.year);

                // Formatter used to be able to convert a string to a date
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                // Gets the view's text
                String username = usernameView.getText().toString();
                String phoneNumber = phoneNumView.getText().toString();
                String password = passwordView.getText().toString();
                String passwordConfirm = passwordConfirmView.getText().toString();

                //Converts birth date to a valid format
                String dateBirth=yearView.getText().toString();

                // Replaces all slashes in string to a dashes
                if(dateBirth.contains("/")){
                    dateBirth = dateBirth.replaceAll("/", "-");
                }

                // Replaces all dots in string to dashes
                if(dateBirth.contains(".")){
                    dateBirth =  dateBirth.replaceAll(".", "-");
                }

                // Creates a new date type
                Date birthDate= new Date(1);

                // Attempts to convert the birth date string into date format
                try{
                    System.out.println(dateBirth);
                    birthDate  = Date.valueOf(dateBirth);
                }
                // If the conversion failed, display error message and end registration process
                catch (Exception e){
                    errors.setText("Date format is incorrect");
                    return;
                }

                // Cancels the registration if the confirmed password isn't the same as the password and end registration process
                if (!password.equals(passwordConfirm) ) {
                    errors.setText("Passwords are not same");
                    return;
                }

                // If not all TextViews are displayed, display error message and end registration process
                if(username.isEmpty() || phoneNumber.isEmpty()  || password.isEmpty()){
                    errors.setText("Please fill all enries");
                    return;
                }
                // Create a new user entity
                UserEntity newUser = new UserEntity();

                // Sets given info to the user entity
                newUser.setName(username);
                newUser.setJoinDate(new java.sql.Date(System.currentTimeMillis()));
                newUser.setBirthDate(birthDate);
                newUser.setKudos(1);
                newUser.setPhoneNumber(phoneNumber);
                newUser.setPhoto("Not Implement yet");
                newUser.setPwd(password);

                // Adds the user to the database
                AsyncCreate create = new AsyncCreate();
                UserEntity params[] = {newUser};
                create.execute(params);

            }
        });
    }

    /**
     * Adds the user to the database with async class
     */
    private class AsyncCreate extends AsyncTask<UserEntity, Void, Void> {

        // Contains the created user's info
        private UserEntity createdUser;

        /**
         * Adds the user to the database
         * @param params
         * @return
         */
        protected Void doInBackground(UserEntity... params) {
            UserRepository  repository =  new UserRepository();
            createdUser =  repository.add(params[0]);
            return null;
        }

        /**
         * Gets results of registration attempt
         * @param result
         */
        @Override
        protected void onPostExecute(Void result) {
            //Sets the query result
            setRegisterResult(createdUser);
        }
    }

    /**
     * Gets result of insert query
     * @param result result of query
     */
    public void setRegisterResult(UserEntity result){
        // Gets the error text view
        TextView errors = findViewById(R.id.error);

        // If successfully registered, finishes registration process and adds info about user created
        if(result.getUserCode() == UserCodes.CREATED){
            InterActivity.getInstance().accCreateInfo="User have been created";
            finish();
        }

        // If the user info already exists, display error message
        if(result.getUserCode() == UserCodes.EXISTS ){
            errors.setText("User with this username already exists");
        }

        // If an SQL error occurred, display error message
        if(result.getUserCode() == UserCodes.SQL_ERROR ) {
            errors.setText("Database error, please try again later or contact our support at chyzhykal@etml.educanet2.ch ");
        }
    }
}
