package com.example.howard.navigaion;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Howard on 2017/1/5.
 */
public class DashboardFragment extends Fragment {

    View myView;
    ImageButton btnPause;
    ImageButton btnProgress;
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
                start.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAtLocation(positionOfPopUpWindow, Gravity.CENTER, 0, 0);
            }
        });
        return myView;
    }


}
