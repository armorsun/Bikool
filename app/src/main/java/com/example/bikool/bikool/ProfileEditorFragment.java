package com.example.bikool.bikool;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Howard on 2017/1/5.
 */
public class ProfileEditorFragment extends Fragment {

    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.personal_profile_editor, container, false);
        FloatingActionButton fab = ((MainActivity)getActivity()).getFab();
        fab.setImageResource(R.drawable.save);
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new profileFragment());
                ft.commit();
            } });

        Typeface bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/semibold.ttf");
        Typeface regular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/regular.ttf");
        Typeface light = Typeface.createFromAsset(getActivity().getAssets(), "fonts/light.ttf");

        EditText name = (EditText)myView.findViewById(R.id.editText);

        name.setTypeface(bold);
        return myView;
    }

}
