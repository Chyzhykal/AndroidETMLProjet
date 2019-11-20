package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import etml.app.meetapp.Objects.Event;

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
                List<Event> testEvents = new ArrayList<Event>();
                testEvents.add(new Event("123"));
                testEvents.add(new Event("321"));
                testEvents.add(new Event("ah ok"));
                testEvents.add(new Event("oh"));
                testEvents.add(new Event("ooo"));
                Log.d("ok", "events created");
                showEvents(testEvents);
            }
        });
    }

    private void showEvents(List<Event> events){
        Log.d("size", String.valueOf(events.size()));
        for (int i = 0; i < events.size(); ++i){
            Log.d("ok", "event sent");

            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    250
            );

            params.setMargins(0, 0, 0, 10);

            ConstraintLayout frame = new ConstraintLayout(this);
            frame.setBackgroundColor(Color.rgb(86, 133, 117));
            frame.setLayoutParams(params);

            TextView eventName = new TextView(this);
            eventName.setText(events.get(i).getName());
            eventName.setTextSize(24);

            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(frame);

            constraintSet.connect(eventName.getId(), ConstraintSet.TOP, frame.getId(), ConstraintSet.TOP, 16);
            constraintSet.connect(eventName.getId(), ConstraintSet.LEFT, frame.getId(), ConstraintSet.LEFT, 16);

            constraintSet.applyTo(frame);
            frame.addView(eventName);
            view.addView(frame);
        }
    }
}
