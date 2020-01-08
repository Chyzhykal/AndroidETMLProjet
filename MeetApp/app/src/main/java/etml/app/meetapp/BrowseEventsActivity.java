/**
 * ETML
 * Author : Boris Hutzli
 * Date : 18.12.2019
 * Description : Displays events available for the user
 */

package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import java.util.List;

import etml.app.meetapp.Entities.EventEntity;
import etml.app.meetapp.Repositories.EventRepository;

/**
 * Browse events view
 */
public class BrowseEventsActivity extends AppCompatActivity {
    LinearLayout view;

    /**
     * Fires when created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_events);

        // Gets the necessary views
        view = findViewById(R.id.scrollviewLayout);
        Button add = findViewById(R.id.button7);
        Button btnProfile = findViewById(R.id.button8);

        AsyncGetAll connect = new AsyncGetAll();
        connect.execute();

        // Switches to the create events activity
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrowseEventsActivity.this, CreateEventActivity.class));
            }
        });

        // Switches to the profile activity
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrowseEventsActivity.this, ProfileActivity.class));
            }
        });
    }

    /**
     * Displays a list of event entities
     * @param events
     */
    private void showEvents(List<EventEntity> events){
        // For each event, display it
        for (int i = 0; i < events.size(); ++i){
            EventEntity currentEvent = events.get(i);

            // Creates new params for the layout
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    250
            );

            params.setMargins(0, 0, 0, 10);

            // Creating the necessary views required for the event to be displayed

            // Layout that will contain all the other views
            ConstraintLayout frame = new ConstraintLayout(this);
            frame.setBackgroundColor(Color.rgb(86, 133, 117));
            frame.setLayoutParams(params);
            frame.setId(View.generateViewId());

            // TextView displaying the event name
            TextView eventName = new TextView(this);
            eventName.setText(events.get(i).getName());
            eventName.setTextSize(20);
            eventName.setId(View.generateViewId());
            frame.addView(eventName);

            ConstraintSet nameConstraints = new ConstraintSet();
            nameConstraints.clone(frame);

            nameConstraints.connect(eventName.getId(), ConstraintSet.TOP, frame.getId(), ConstraintSet.TOP, 0);
            nameConstraints.connect(eventName.getId(), ConstraintSet.LEFT, frame.getId(), ConstraintSet.LEFT, 0);
            nameConstraints.applyTo(frame);

            // TextView displaying the start date/time of the event
            TextView startDateTime = new TextView(this);
            startDateTime.setText(currentEvent.getStartDateTime().toString());
            startDateTime.setTextSize(16);
            startDateTime.setId(View.generateViewId());
            frame.addView(startDateTime);

            ConstraintSet startDateTimeConstraints = new ConstraintSet();
            startDateTimeConstraints.clone(frame);

            startDateTimeConstraints.connect(startDateTime.getId(), ConstraintSet.TOP, frame.getId(), ConstraintSet.TOP, 50);
            startDateTimeConstraints.connect(startDateTime.getId(), ConstraintSet.LEFT, frame.getId(), ConstraintSet.LEFT, 0);
            startDateTimeConstraints.applyTo(frame);

            // TextView displaying the end date/time of the event
            TextView endDateTime = new TextView(this);
            endDateTime.setText(currentEvent.getEndDateTime().toString());
            endDateTime.setTextSize(16);
            endDateTime.setId(View.generateViewId());
            frame.addView(endDateTime);

            // TextView displaying the location of the event
            TextView location = new TextView(this);
            location.setText(currentEvent.getLocation());
            location.setTextSize(16);
            location.setId(View.generateViewId());
            frame.addView(location);

            // TextView displaying the number of participants in the event
            TextView participants = new TextView(this);
            participants.setText(currentEvent.getParticipantCount() + "/" + currentEvent.getMaxUsers());
            participants.setTextSize(16);
            participants.setId(View.generateViewId());
            frame.addView(participants);

            ConstraintSet endDateTimeConstraints = new ConstraintSet();
            endDateTimeConstraints.clone(frame);
            endDateTimeConstraints.connect(endDateTime.getId(), ConstraintSet.TOP, frame.getId(), ConstraintSet.TOP, 50);
            endDateTimeConstraints.connect(endDateTime.getId(), ConstraintSet.LEFT, frame.getId(), ConstraintSet.LEFT, 50);

            ConstraintSet locationConstraint = new ConstraintSet();
            locationConstraint.clone(frame);
            locationConstraint.connect(location.getId(), ConstraintSet.TOP, frame.getId(), ConstraintSet.TOP, 50);
            locationConstraint.connect(location.getId(), ConstraintSet.LEFT, frame.getId(), ConstraintSet.LEFT, 150);

            ConstraintSet participantsConstraints =new ConstraintSet();
            participantsConstraints.clone(frame);
            participantsConstraints.connect(participants.getId(), ConstraintSet.TOP, frame.getId(), ConstraintSet.TOP, 50);
            participantsConstraints.connect(participants.getId(), ConstraintSet.LEFT, frame.getId(), ConstraintSet.LEFT, 250);

            endDateTimeConstraints.applyTo(frame);
            locationConstraint.applyTo(frame);
            participantsConstraints.applyTo(frame);
            view.addView(frame);
        }
    }

    /**
     * Gets all events with async class
     */
    private class AsyncGetAll extends AsyncTask<Void, Void, Void> {
        // Events to receive
        List<EventEntity> retrievedEvents;

        /**
         * Retrieves the events
         * @param params
         * @return
         */
        protected Void doInBackground(Void... params) {
            EventRepository repository = new EventRepository();
            retrievedEvents = repository.getAll();
            return null;
        }

        /**
         * Displays the retrieved events
         * @param result
         */
        @Override
        protected void onPostExecute(Void result) {
            System.out.println("Beofre showing");
            showEvents(retrievedEvents);
        }
    }
}
