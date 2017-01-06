package com.example.bikool.bikool;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Howard on 2017/1/5.
 */
public class FriendProfileFragment extends Fragment {

    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.personal_profile, container, false);
        FloatingActionButton fab = ((MainActivity)getActivity()).getFab();
        fab.hide();

        Typeface bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/semibold.ttf");
        Typeface regular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/regular.ttf");
        Typeface light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/light.ttf");

        TextView profileTitle = (TextView)myView.findViewById(R.id.profile_title);
        TextView wrappedDistance = (TextView)myView.findViewById(R.id.wrapped_distance);
        TextView wrappedDistanceNum = (TextView)myView.findViewById(R.id.wrapped_distance_num);
        TextView avgSpeed = (TextView)myView.findViewById(R.id.avg_speed);
        TextView avgSpeedNum = (TextView)myView.findViewById(R.id.avg_speed_num);
        TextView avgRank = (TextView)myView.findViewById(R.id.avg_ranking);
        TextView avgRankNum = (TextView)myView.findViewById(R.id.avg_ranking_num);
        TextView date = (TextView)myView.findViewById(R.id.date1);
        TextView aWeekEndInTaichung = (TextView)myView.findViewById(R.id.a_week_end_in_taichung);

        profileTitle.setTypeface(bold);
        wrappedDistance.setTypeface(regular);
        wrappedDistanceNum.setTypeface(bold);
        avgSpeed.setTypeface(regular);
        avgSpeedNum.setTypeface(bold);
        avgRank.setTypeface(regular);
        avgRankNum.setTypeface(bold);
        date.setTypeface(bold);
        aWeekEndInTaichung.setTypeface(regular);

        return myView;
    }

}
