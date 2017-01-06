package com.example.bikool.bikool;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class createEvent extends Fragment implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker;
    TextView txtDate, txtTime;
    EditText eventName;
    private int myYear, myMonth, myDay, myHour, myMin;
    ImageButton btnBack2CreateEvent, btnSaveAndBack2CreateEvent;
    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_create_event, container, false);

        btnDatePicker = (Button) myView.findViewById(R.id.btn_dateChooser);
        btnTimePicker = (Button) myView.findViewById(R.id.btn_timeChooser);
        btnBack2CreateEvent = (ImageButton)myView.findViewById(R.id.imgBtn_back_createEvent);
        //btnSaveAndBack2CreateEvent = (ImageButton)myView.findViewById(R.id.save_and_back_to_explore);
        FloatingActionButton fab = ((MainActivity)getActivity()).getFab();
        fab.show();
        txtDate = (TextView) myView.findViewById(R.id.txtView_date);
        txtTime = (TextView) myView.findViewById(R.id.txtView_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);


        btnBack2CreateEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new explore());
                ft.commit();
            } });

        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new explore());
                ft.commit();
            } });

        eventName = (EditText) myView.findViewById(R.id.ediTxt_evtName);
        return myView;
    }


    @Override
    public void onClick(View view) {
        if (view == btnDatePicker) {
            final Calendar calendar = Calendar.getInstance();
            myYear = calendar.get(Calendar.YEAR);
            myMonth = calendar.get(Calendar.MONTH);
            myDay = calendar.get(Calendar.DAY_OF_MONTH);

            /*DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                }
            }, myYear, myMonth, myDay);
            datePickerDialog.show();
            */
        }

        if (view == btnTimePicker) {
            final Calendar calendar = Calendar.getInstance();
            myHour = calendar.get(Calendar.HOUR_OF_DAY);
            myMin = calendar.get(Calendar.MINUTE);
            /*
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txtTime.setText(hourOfDay + ":" + minute);
                }
            }, myHour, myMin, false);
            timePickerDialog.show();
            */
        }
    }
}
