package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import etml.app.meetapp.Entities.EventEntity;
import etml.app.meetapp.Repositories.EventRepository;

/**
 * Create event view
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

        Button btnBack = findViewById(R.id.button10);
        Button btnCreate = findViewById(R.id.button9);

        // Returns to previous activity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Creates the event
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView eventNameView = findViewById(R.id.editText3);
                TextView descriptionView = findViewById(R.id.editText4);
                TextView startDateView = findViewById(R.id.editText9);
                TextView startTimeView = findViewById(R.id.editText10);
                TextView endDateView = findViewById(R.id.editText12);
                TextView endTimeView = findViewById(R.id.editText11);
                TextView locationView = findViewById(R.id.editText13);
                Spinner eventTypeView = findViewById(R.id.spinner2);
                TextView maxParticipantsView = findViewById(R.id.editText15);
                Switch promotedView = findViewById(R.id.switch1);
                Switch privateView = findViewById(R.id.switch2);

                EventEntity newEvent = new EventEntity(eventNameView.getText().toString());
                newEvent.setDescription(descriptionView.getText().toString());
                newEvent.setStartDateTime(new java.sql.Date(11052001));
                newEvent.setEndDateTime(new java.sql.Date(11052001));
                newEvent.setLocation(locationView.getText().toString());
                newEvent.setCategory(1);
                newEvent.setMaxUsers(Integer.parseInt(maxParticipantsView.getText().toString()));
                newEvent.setPicture("ooleg");
                newEvent.setPromoted(promotedView.isChecked());
                newEvent.setIsPrivate(privateView.isChecked());

                EventRepository repo = new EventRepository();
                repo.add(newEvent);

                finish();
            }
        });
    }
}
