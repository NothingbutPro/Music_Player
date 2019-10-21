package com.ws.design.music_player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView text_screen1,text_screen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();init1();
    }

    public void init() {

        TextView btn = (TextView) findViewById(R.id.text_screen1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent contact = new Intent(MainActivity.this, Screen1.class);
                startActivity(contact);
            }
        });
    }

    public void init1(){

        TextView btn = (TextView)findViewById(R.id.text_screen2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent contact = new Intent(MainActivity.this,UberTestActivity.class);
                startActivity(contact);
            }
        });
    }

}
