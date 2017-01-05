package com.example.howard.navigaion;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by Howard on 2017/1/5.
 */
public class friendsList extends ListActivity {
    ListView friend1, friend2, friend3;

    @Override
    protected void onCreate(Bundle saveInstancestatce){
        super.onCreate(saveInstancestatce);
        setContentView(R.layout.friends_list);

    }
}
