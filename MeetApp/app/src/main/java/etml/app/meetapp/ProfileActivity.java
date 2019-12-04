package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
    }
}
