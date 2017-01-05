package com.example.bikool.bikool;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class createEvent extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker;
    TextView txtDate, txtTime;
    EditText eventName;
    private int myYear, myMonth, myDay, myHour, myMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        btnDatePicker = (Button) findViewById(R.id.btn_dateChooser);
        btnTimePicker = (Button) findViewById(R.id.btn_timeChooser);
        txtDate = (TextView) findViewById(R.id.txtView_date);
        txtTime = (TextView) findViewById(R.id.txtView_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        eventName = (EditText) findViewById(R.id.ediTxt_evtName);
    }

    public void backToExplore(View view) {
        Intent intent = new Intent(this, explore.class);
        startActivity(intent);
    }

    public void saveAndBackToExplorer(View view) {
        Intent intent = new Intent(this, explore.class);
        intent.putExtra("eventName", eventName.getText().toString());
        intent.putExtra("eventDate", txtDate.getText().toString());
        intent.putExtra("eventTime", txtTime.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view == btnDatePicker) {
            final Calendar calendar = Calendar.getInstance();
            myYear = calendar.get(Calendar.YEAR);
            myMonth = calendar.get(Calendar.MONTH);
            myDay = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                }
            }, myYear, myMonth, myDay);
            datePickerDialog.show();
        }

        if (view == btnTimePicker) {
            final Calendar calendar = Calendar.getInstance();
            myHour = calendar.get(Calendar.HOUR_OF_DAY);
            myMin = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txtTime.setText(hourOfDay + ":" + minute);
                }
            }, myHour, myMin, false);
            timePickerDialog.show();
        }
    }
}
