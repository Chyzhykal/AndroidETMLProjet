/**
 * ETML
 * Author : Boris Hutzli and Aleh Chyzhk
 * Date : 18.12.2019
 * Description : Displays the connected user's info
 */


package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.Enums.UserCodes;
import etml.app.meetapp.InterActivityObjects.InterActivity;
import etml.app.meetapp.Repositories.UserRepository;

/**
 * Profile view
 */
public class ProfileActivity extends AppCompatActivity {

    /**
     * Fires when created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        AsyncDisplayProfile create = new AsyncDisplayProfile();
        Integer params[] = {InterActivity.getInstance().userId};
        create.execute(params );


    }

    /**
     * Adds the user to the database with async class
     */
    private class AsyncDisplayProfile extends AsyncTask<Integer, Void, Void> {

        // Stored info about the user to display
        private UserEntity createdUser;

        /**
         * Gets the user's info
         * @param params
         * @return
         */
        protected Void doInBackground(Integer... params) {
            UserRepository repository =  new UserRepository();
            createdUser =  repository.getById(params[0]);
            return null;
        }

        /**
         * Displays the suer
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
        // Error text view
        TextView errors = findViewById(R.id.error);

        // If successfully registered, finishes registration process and adds info about user creates
        if(result.getUserCode() == UserCodes.CREATED){
            InterActivity.getInstance().accCreateInfo="User have been created";
            finish();
        }

        // If the user info already exists, display error message
        if(result.getUserCode() == UserCodes.EXISTS ){
            errors.setText("User with this username already exists");
        }

        // If an SQL error occured, display error message
        if(result.getUserCode() == UserCodes.SQL_ERROR ) {
            errors.setText("Database error, please try again later or contact our support at chyzhykal@etml.educanet2.ch ");
        }
    }
}
