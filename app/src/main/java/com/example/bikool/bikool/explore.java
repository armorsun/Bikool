package com.example.bikool.bikool;

import android.app.ListActivity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class explore extends AppCompatActivity {

    private String eventName, eventDate, eventTime;
    private ListView eventList;
    private ArrayList<String> eventArray;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_explore);

        eventArray = new ArrayList<String>();

        eventArray.add("New Year Ride!! will start on 1/9 2017 at 6:00");
        eventArray.add("Taipei Ride! will start on 1/7 2017 at 8:00");
        eventArray.add("Night Exercise! will start on 1/15 2017 at 20:00");

        eventList = (ListView) findViewById(R.id.lst_events);
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_listview, eventArray);
        eventList.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            eventName = intent.getStringExtra("eventName");
            eventDate = intent.getStringExtra("eventDate");
            eventTime = intent.getStringExtra("eventTime");

            eventArray.add(0, eventName + " will start on " + eventDate + " at " + eventTime);
            adapter.notifyDataSetChanged();

            Toast toast = Toast.makeText(getApplicationContext(), eventName + " added!", Toast.LENGTH_SHORT);
            toast.show();
        }

        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent= new Intent(explore.this, newEvent.class);
                startActivity(intent);
            }
        });
    }

    public void CreateNewTrip(View view) {
        Intent intent = new Intent(this, createEvent.class);
        startActivity(intent);
    }
}
