package com.example.bikool.bikool;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Howard on 2017/1/5.
 */
public class DashboardFragment extends Fragment {

    View myView;
    ImageButton btnPause;
    ImageButton btnProgress;
    TextView time, millimeter, rpm, bpm, grade, kmh;

    boolean progressFlag = false;
    private PopupWindow popupWindow;
    private RelativeLayout positionOfPopUpWindow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        myView = inflater.inflate(R.layout.dashboard, container, false);
        FloatingActionButton fab = ((MainActivity)getActivity()).getFab();
        fab.hide();
        btnPause = (ImageButton) myView.findViewById(R.id.pause);
        btnProgress = (ImageButton) myView.findViewById(R.id.progress);
        positionOfPopUpWindow = (RelativeLayout)myView.findViewById(R.id.popUp_postion);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                LayoutInflater inflater = (LayoutInflater)getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.dashboard_popup_window, null);

                popupWindow = new PopupWindow(
                        customView,
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT
                );

                ImageButton start = (ImageButton) customView.findViewById(R.id.start);
                ImageButton meetingPoint = (ImageButton) customView.findViewById(R.id.meetingpoint);
                ImageButton stop = (ImageButton) customView.findViewById(R.id.stop);
                ImageButton message = (ImageButton) customView.findViewById(R.id.message);
                start.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAtLocation(positionOfPopUpWindow, Gravity.CENTER, 0, 0);

                message.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        popupWindow.dismiss();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_frame, new ChatFragment());
                        ft.commit();
                    }
                });

                stop.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        popupWindow.dismiss();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_frame, new profileFragment());
                        ft.commit();
                    }
                });
            }
        });

        Typeface bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/semibold.ttf");
        Typeface regular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/regular.ttf");
        Typeface light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/light.ttf");

        time = (TextView)myView.findViewById(R.id.dashboard_time);
        millimeter = (TextView)myView.findViewById(R.id.millimeter);
        kmh = (TextView)myView.findViewById(R.id.kmh);
        rpm = (TextView)myView.findViewById(R.id.rpm);
        bpm = (TextView)myView.findViewById(R.id.bpm);
        grade = (TextView)myView.findViewById(R.id.grade);

        time.setTypeface(bold);
        millimeter.setTypeface(bold);
        kmh.setTypeface(bold);
        rpm.setTypeface(bold);
        bpm.setTypeface(bold);
        grade.setTypeface(bold);


        return myView;
    }


}
