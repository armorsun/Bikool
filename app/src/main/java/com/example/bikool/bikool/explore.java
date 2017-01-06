package com.example.bikool.bikool;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class explore extends Fragment {

    private String eventName, eventDate, eventTime;
    private ListView eventList;
    private ArrayList<String> eventArray;
    private ArrayAdapter<String> adapter;
    View myView;
    ImageButton btnCreateNewTrip;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_explore, container, false);

        //btnCreateNewTrip = (ImageButton) myView.findViewById(R.id.create_new_trip);
        FloatingActionButton fab = ((MainActivity)getActivity()).getFab();
        fab.setImageResource(R.drawable.add);
        fab.show();
        eventArray = new ArrayList<String>();
        eventArray.add("New Year Ride!! will start on 1/9 2017 at 6:00");
        eventArray.add("Taipei Ride! will start on 1/7 2017 at 8:00");
        eventArray.add("Night Exercise! will start on 1/15 2017 at 20:00");

        eventList = (ListView) myView.findViewById(R.id.lst_events);
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.custom_listview, eventArray);
        eventList.setAdapter(adapter);

        /*
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            eventName = intent.getStringExtra("eventName");
            eventDate = intent.getStringExtra("eventDate");
            eventTime = intent.getStringExtra("eventTime");

            eventArray.add(0, eventName + " will start on " + eventDate + " at " + eventTime);
            adapter.notifyDataSetChanged();

            Toast toast = Toast.makeText(getActivity().getApplicationContext(), eventName + " added!", Toast.LENGTH_SHORT);
            toast.show();
        }
        */
        /*
        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //transaction
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent= new Intent(explore.this, newEvent.class);
                startActivity(intent);
            }

        });
        */

        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new createEvent());
                ft.commit();
            } });

        return myView;
    }
}
