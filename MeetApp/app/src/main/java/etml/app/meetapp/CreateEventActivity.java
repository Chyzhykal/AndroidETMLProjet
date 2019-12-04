package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Create event views
 */
public class CreateEventActivity extends AppCompatActivity {

    /**
     * Fires when created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }
}
