package com.ws.design.music_player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import Adapter.ListAdapter1;
import Model.PojoClass1;

public class Screen2 extends AppCompatActivity {


    public ImageView Image;
    private RecyclerView rv1;
    private ArrayList<PojoClass1> pojoClassArrayList1;
    private String[] songsinger_name = {"Look What You Made Me Do - Taylor Swift", "Clean Bandit - Symphony ft. Zavra", "Boda Yello - Cardi B", "Unforgettable - French Montana","Strip That Down - Liam Payne, Quavo","What Lovers Do - Maroon 5, sza"};
    private String[] song_type = {"Music Category - Pop"," Music Category - Pop", "Music Category - india","Music Category - Pop", "Music Category - india", "Music Category - Pop"};
    private Integer[] logo = {R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa, R.drawable.aa};

    boolean isselected = false;
    private ListAdapter1 listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        Image = (ImageView)findViewById(R.id.playbutton2) ;
        pojoClassArrayList1 = new ArrayList<>();


        for (int i = 0; i < songsinger_name.length; i++) {

            PojoClass1 pojoClass1 = new PojoClass1();
            pojoClass1.setSongsinger_name(songsinger_name[i]);
            pojoClass1.setSong_type(song_type[i]);
            pojoClass1.setLogo(logo[i]);
            pojoClassArrayList1.add(pojoClass1);
        }

        rv1 = (RecyclerView) findViewById(R.id.rv1);

        listAdapter = new ListAdapter1(Screen2.this, pojoClassArrayList1);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Screen2.this);
        rv1.setLayoutManager(mLayoutManager);
        rv1.setItemAnimator(new DefaultItemAnimator());
        rv1.setAdapter(listAdapter);


        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isselected == false)
                {
                    Image.setImageResource(R.drawable.ic_pause_white);
                    isselected = true;
                }
                else {
                    Image.setImageResource(R.drawable.ic_play_white);
                    isselected =false;
                }

            }
        });

    }
}
