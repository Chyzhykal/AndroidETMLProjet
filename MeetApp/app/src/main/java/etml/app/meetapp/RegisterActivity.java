package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import etml.app.meetapp.Entities.UserEntity;
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

        Button btnClick = findViewById(R.id.button3);

        /**
         * Fires once the user clicks on register
         */
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, Main2Activity.class));
                // Gets the views
                TextView usernameView = findViewById(R.id.editText8);
                TextView phoneNumView = findViewById(R.id.editText5);
                TextView passwordView = findViewById(R.id.editText6);
                TextView passwordConfirmView = findViewById(R.id.editText7);
                TextView birthDateView = findViewById(R.id.editText14);
                TextView kudosVeiw = findViewById(R.id.editText16);

                // Formatter used to be able to covnert a string to a date
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                // Gets the view's text
                String username = usernameView.getText().toString();
                String phoneNumber = phoneNumView.getText().toString();
                String password = passwordView.getText().toString();
                String passwordConfirm = passwordConfirmView.getText().toString();
                String birthDate = birthDateView.getText().toString();
                String kudos = birthDateView.getText().toString();

                // Cancels the registration if the confirmed password isn't the same as the password
                if (password != passwordConfirm) {
                    return;
                }

                // TODO : Increment user kudos

                // Create a new user entity
                UserEntity newUser = new UserEntity();

                // Try catch needed to parse date
                try {
                    newUser.setBirthDate((java.sql.Date) formatter.parse(birthDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                newUser.setName(username);
                newUser.setId(1);
                newUser.setJoinDate(new java.sql.Date(System.currentTimeMillis()));
                newUser.setKudos(1);
                newUser.setPhoneNumber(phoneNumber);
                newUser.setPhoto(null);
                newUser.setPhotoObject(null);

                UserRepository repository = new UserRepository();
                repository.add(newUser);
            }
        });
    }
}
