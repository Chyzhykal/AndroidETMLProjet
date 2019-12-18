package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

                /*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                ConnectMySQL.getInstance().connect();
                UserRepository repository = new UserRepository();
                UserEntity user = repository.loginAttempt(usernameText, passwordText);
                if (user.getUserCode() == UserCodes.CONNECTED){
                    Session.getInstance().addPair("connected", true);
                    Session.getInstance().addPair("username", usernameText);
                    Session.getInstance().addPair("userId", user.getId());
                    startActivity(new Intent(LoginActivity.this, BrowseEventsActivity.class));
                }*/

                startActivity(new Intent(LoginActivity.this, BrowseEventsActivity.class));
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
}
