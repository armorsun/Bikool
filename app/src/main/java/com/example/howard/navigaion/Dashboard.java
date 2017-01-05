package com.example.howard.navigaion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by Howard on 2017/1/5.
 */
public class Dashboard extends AppCompatActivity {
    ImageButton btnPause;
    ImageButton btnProgress;
    boolean progressFlag = false;
    private PopupWindow popupWindow;
    private RelativeLayout positionOfPopUpWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        btnPause = (ImageButton) findViewById(R.id.pause);
        btnProgress = (ImageButton) findViewById(R.id.progress);
        positionOfPopUpWindow = (RelativeLayout)findViewById(R.id.popUp_postion);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),
                        "Hello world!", Toast.LENGTH_LONG).show();
                if (progressFlag) {
                    btnProgress.setImageResource(R.drawable.dashboardteam);
                    progressFlag = !progressFlag;
                }
                else {
                    btnProgress.setImageResource(R.drawable.dashboardperson);
                    progressFlag = !progressFlag;
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.dashboard_popup_window, null);

                popupWindow = new PopupWindow(
                        customView,
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT
                );

                ImageButton start = (ImageButton) customView.findViewById(R.id.start);
                start.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAtLocation(positionOfPopUpWindow, Gravity.CENTER, 0, 0);
            }
        });
    }
}
