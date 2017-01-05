package com.example.bikool.bikool;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        return myView;
    }

}
