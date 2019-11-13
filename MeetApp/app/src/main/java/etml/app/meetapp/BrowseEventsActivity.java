package etml.app.meetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import etml.app.meetapp.Objects.Event;

public class BrowseEventsActivity extends AppCompatActivity {
    ScrollView view;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_events);
        view = findViewById(R.id.scollview1);
        add = findViewById(R.id.button7);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Event> testEvents = new ArrayList<Event>();
                testEvents.add(new Event());
                testEvents.add(new Event());
                testEvents.add(new Event());
                testEvents.add(new Event());
                testEvents.add(new Event());
                Log.d("ok", "events created");
                showEvents(testEvents);
            }
        });
    }

    private void showEvents(List<Event> events){
        for (int i = 0; i < events.size(); ++i){
            Log.d("ok", "event sent");
            /*TextView eventName = new TextView(this);
            eventName.setText("test");
            view.addView(eventName);*/
        }

    }
}
