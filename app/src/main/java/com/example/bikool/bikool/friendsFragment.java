package com.example.bikool.bikool;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Howard on 2017/1/5.
 */
public class friendsFragment extends Fragment {

    View myView;
    Button btnFriend1Text, btnFriend2Text, btnFriend3Text;

    TextView title, favoriate, others;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.friends_list, container, false);
        FloatingActionButton fab = ((MainActivity)getActivity()).getFab();
        fab.hide();

        btnFriend1Text = (Button) myView.findViewById(R.id.friend1_text);
        btnFriend2Text = (Button) myView.findViewById(R.id.friend2_text);
        btnFriend3Text = (Button) myView.findViewById(R.id.friend3_text);

        title = (TextView)myView.findViewById(R.id.friend_page_title);
        favoriate = (TextView)myView.findViewById(R.id.friend_page_favorite);
        others = (TextView)myView.findViewById(R.id.friend_page_others);

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

        Typeface bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/semibold.ttf");
        Typeface regular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/regular.ttf");
        Typeface light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/light.ttf");

        title.setTypeface(bold);
        favoriate.setTypeface(regular);
        others.setTypeface(regular);

        btnFriend3Text.setTypeface(regular);
        btnFriend2Text.setTypeface(regular);
        btnFriend1Text.setTypeface(regular);

        return myView;
    }

}
