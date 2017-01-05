package com.example.bikool.bikool;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Howard on 2017/1/5.
 */
public class friendsFragment extends Fragment {

    View myView;
    Button btnFriend1Text, btnFriend2Text, btnFriend3Text;
    ImageButton btnFriend1Image, btnFriend2Image, btnFriend3Image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.friends_list, container, false);
        FloatingActionButton fab = ((MainActivity)getActivity()).getFab();
        fab.show();

        btnFriend1Text = (Button) myView.findViewById(R.id.friend1_text);
        btnFriend2Text = (Button) myView.findViewById(R.id.friend2_text);
        btnFriend3Text = (Button) myView.findViewById(R.id.friend3_text);
        //btnFriend1Image = (ImageButton) myView.findViewById(R.id.friend1_image);
        //btnFriend2Image = (ImageButton) myView.findViewById(R.id.friend2_image);
        //btnFriend3Image = (ImageButton) myView.findViewById(R.id.friend3_image);

        btnFriend1Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new FriendProfileFragment());
                ft.commit();
            } });

        btnFriend2Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new FriendProfileFragment());
                ft.commit();
            } });

        btnFriend3Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new FriendProfileFragment());
                ft.commit();
            } });
        /*
        btnFriend1Image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new FriendProfileFragment());
                ft.commit();
            } });

        btnFriend2Image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new FriendProfileFragment());
                ft.commit();
            } });

        btnFriend3Image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new FriendProfileFragment());
                ft.commit();
            } });
        */
        return myView;
    }

}
