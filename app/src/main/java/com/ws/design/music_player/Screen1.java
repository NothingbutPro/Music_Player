package com.ws.design.music_player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import Adapter.ListAdapter;
import Model.PojoClass;

public class Screen1 extends AppCompatActivity {

    public ImageView Image;
    private RecyclerView rv;
    private ArrayList<PojoClass> pojoClassArrayList;
    private String[] song_name = {"Clean Bendit", "Look What You Made Me Do", "Boda Yello", "Unforgettable", "Strip That Down", "What Lovers Do"};
    private String[] singer_name = {"Symponi ft. Zavra", "Taylor Swift", "Cardi B", "French Montana", "Liam Payne, Quavo", "Maroon 5, sza"};
    private String[] time = {"2:22", "4:21", "2:58", "2:28", "5:39", "3:12"};
    private ListAdapter listAdapter;

    boolean isselected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        Image = (ImageView)findViewById(R.id.playbutton1) ;

        pojoClassArrayList = new ArrayList<>();

        for (int i = 0; i < song_name.length; i++) {

            PojoClass pojoClass = new PojoClass();
            pojoClass.setSong_name(song_name[i]);
            pojoClass.setSinger_name(singer_name[i]);
            pojoClass.setTime(time[i]);

            pojoClassArrayList.add(pojoClass);
        }

        rv = (RecyclerView) findViewById(R.id.rv);

        listAdapter = new ListAdapter(Screen1.this, pojoClassArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Screen1.this);
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(listAdapter);

        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isselected == false)
                {
                    Image.setImageResource(R.drawable.ic_pause);
                    isselected = true;
                }
                else {
                    Image.setImageResource(R.drawable.ic_play);
                    isselected =false;
                }

            }
        });

    }
}
