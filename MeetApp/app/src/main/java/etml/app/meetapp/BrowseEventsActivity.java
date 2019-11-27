package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import etml.app.meetapp.Entities.EventEntity;
import etml.app.meetapp.Repositories.EventRepository;
import etml.app.meetapp.database.ConnectMySQL;

public class BrowseEventsActivity extends AppCompatActivity {
    LinearLayout view;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_events);
        view = findViewById(R.id.scrollviewLayout);
        add = findViewById(R.id.button7);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ok", "events created");

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                ConnectMySQL.getInstance().connect();
                EventRepository repository = new EventRepository();
                showEvents(repository.getAll());
            }
        });
    }

    private void showEvents(List<EventEntity> events){
        Log.d("size", String.valueOf(events.size()));
        for (int i = 0; i < events.size(); ++i){
            Log.d("ok", "event sent");
            EventEntity currentEvent = events.get(i);

            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    250
            );

            params.setMargins(0, 0, 0, 10);

            ConstraintLayout frame = new ConstraintLayout(this);
            frame.setBackgroundColor(Color.rgb(86, 133, 117));
            frame.setLayoutParams(params);
            frame.setId(View.generateViewId());
            //addView(frame, currentEvent.getName(), 24, 0, 0);
            //addView(frame, currentEvent.getStartDateTime(), 16, 0, 50);
            //addView(frame, currentEvent.getEndDateTime(), 16, 48, 32, i);
            //addView(frame, currentEvent.getLocation(), 16, 16, 48, i);
            //addView(frame, currentEvent.getParticipantCount() + "/" + currentEvent.getMaxUsers(), 16, 16, 64,i);

            TextView eventName = new TextView(this);
            eventName.setText(events.get(i).getName());
            eventName.setTextSize(24);
            eventName.setId(View.generateViewId());
            frame.addView(eventName);

            ConstraintSet nameConstraints = new ConstraintSet();
            nameConstraints.clone(frame);

            nameConstraints.connect(eventName.getId(), ConstraintSet.TOP, frame.getId(), ConstraintSet.TOP, 0);
            nameConstraints.connect(eventName.getId(), ConstraintSet.LEFT, frame.getId(), ConstraintSet.LEFT, 0);
            //nameConstraints.constrainDefaultHeight(eventName.getId(), 200);
            nameConstraints.applyTo(frame);

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

            /*TextView endDateTime = new TextView(this);
            endDateTime.setText(currentEvent.getEndDateTime());
            endDateTime.setTextSize(16);

            TextView location = new TextView(this);
            location.setText(currentEvent.getLocation());
            location.setTextSize(16);

            TextView participants = new TextView(this);
            participants.setText(currentEvent.getParticipantCount() + "/" + currentEvent.getMaxUsers());
            participants.setTextSize(16);

            ConstraintSet endDateTimeConstraints = new ConstraintSet();
            endDateTimeConstraints.clone(frame);

            ConstraintSet locationConstraint = new ConstraintSet();
            locationConstraint.clone(frame);

            ConstraintSet participantsConstraints =new ConstraintSet();
            participantsConstraints.clone(frame);

            endDateTimeConstraints.applyTo(frame);
            locationConstraint.applyTo(frame);
            participantsConstraints.applyTo(frame);
            frame.addView(eventName);*/
            view.addView(frame);
        }
    }
}
