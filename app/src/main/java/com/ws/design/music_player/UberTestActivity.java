package com.ws.design.music_player;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.ws.design.music_player.ui.main.SectionsPagerAdapter;

public class UberTestActivity extends AppCompatActivity {
    public NestedScrollView nesscroll;
    private Fragment Frag1;
    private Fragment Frag2;
    LinearLayout linearLayout1,linearLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uber_test);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        Frag1 = getSupportFragmentManager().findFragmentById(R.id.frg1);
        Frag2 = getSupportFragmentManager().findFragmentById(R.id.frag2);
        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        nesscroll = findViewById(R.id.nesscroll);

        viewPager.setAdapter(sectionsPagerAdapter);
        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
//        Frag2.getContext().
//        if (savedInstanceState == null) {
//            Frag1 = getSupportFragmentManager().findFragmentById(R.id.frg1);
//        }
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
       nesscroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
           @Override
           public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
               Rect scrollBounds = new Rect();
               nesscroll.getHitRect(scrollBounds);
               if(linearLayout2.getLocalVisibleRect(scrollBounds))
               {
                   TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                   TabLayout.Tab tab = tabLayout.getTabAt(1);
                   tab.select();
                  // tabs.setScrollPosition(1 ,1,true);
                   Toast.makeText(UberTestActivity.this, "Now this is visibke", Toast.LENGTH_SHORT).show();
               }else {
                   TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                   TabLayout.Tab tab = tabLayout.getTabAt(0);
                   tab.select();
                   Toast.makeText(UberTestActivity.this, "Not now", Toast.LENGTH_SHORT).show();
               }
           }
       });
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(UberTestActivity.this, "tab selected"+tab.getPosition(), Toast.LENGTH_SHORT).show();
                if(tab.getPosition() ==0)
                {
//                    linearLayout1.requestFocus();
                   //   = // your scrollview
                       //     View insideView = // find the View that you need to scroll to which is inside this ScrollView
//                    nesscroll.fullScroll(ScrollView.DRAG_FLAG_GLOBAL);
                    nesscroll.scrollTo(0, (int)linearLayout1.getY());
//                    linearLayout2.requestFocus(5);
//                    Frag1.getActivity().
                }else  if(tab.getPosition() ==1)
                {
//                    nesscroll.fullScroll(ScrollView.DRAG_FLAG_GLOBAL);
                    linearLayout2.requestFocus();
                    nesscroll.scrollTo(0, (int)linearLayout2.getY());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(UberTestActivity.this, "tab selected"+tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(UberTestActivity.this, "tab selected"+tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}