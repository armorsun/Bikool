package com.example.bikool.bikool;

import android.app.FragmentManager;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class explore extends MainActivity {

    private String eventName, eventDate, eventTime;
    private ListView eventList;
    private ArrayList<String> eventArray;
    private ArrayAdapter<String> adapter;
    View contentView;

//    private DrawerLayout drawerLayout;
//    private Toolbar toolbar;
//    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        //setContentView(R.layout.activity_explore);
        drawer.closeDrawers();
        getLayoutInflater().inflate(R.layout.activity_explore, frameLayout);

//        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        //inflate your activity layout here!
//        contentView = inflater.inflate(R.layout.activity_explore, null, false);
//        frameLayout.addView(contentView, 0);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerLayout.setDrawerListener(toggle);
//        toggle.syncState();
//
//        navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

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

        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(explore.this, newEvent.class);
                startActivity(intent);
            }
        });
    }

    public void CreateNewTrip(View view) {
        Intent intent = new Intent(this, createEvent.class);
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        //to prevent current item select over and over
////        if (item.isChecked()){
////            drawerLayout.closeDrawer(GravityCompat.START);
////            return false;
////        }
//
//        FragmentManager fragmentManger = getFragmentManager();
//        if (id == R.id.personal_profile_layout) {
//            fragmentManger.beginTransaction().replace(R.id.content_frame, new profileFragment()).commit();
//        } else if (id == R.id.friends_list_layout) {
//            fragmentManger.beginTransaction().replace(R.id.content_frame, new friendsFragment()).commit();
//        } else if (id == R.id.explore_layout) {
//            Intent intent = new Intent(getApplicationContext(), explore.class);
//            startActivity(intent);
//        } else if (id == R.id.dashboard_layout) {
//            fragmentManger.beginTransaction().replace(R.id.content_frame, new DashboardFragment()).commit();
//        }
//
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
