package com.example.bestshift_as;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.bestshift_as.Kommfort.Berechnenkomfort;
import com.example.bestshift_as.Stop.Stop;



public class MyActivity extends FragmentActivity implements ActionBar.TabListener {
    ActionBar actionbar;
    ViewPager viewpager;
    FragmentPagerAdapter ft;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        viewpager =(ViewPager) findViewById(R.id.pager);


        ft = new FragementPageAdapter(getSupportFragmentManager());
        actionbar=getActionBar();
        viewpager.setAdapter(ft);
        // setzen der Navigation fuer die Tabs
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Background von tasks wird veraendert
        actionbar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#47708D")));

        //Fuerr die Farbe ober dem Tabs
       //actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#47708D")));


        // Tabs werden hinzugefuegt
        actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.verbrauchwolke));
        actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.komfort), true);
        actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.schaltvorschlag));

       /**
        Button stop= (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Stop.class);
                startActivity(intent);
            }
        });
        **/
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {


            }

            @Override
            public void onPageSelected(int i) {
                actionbar.setSelectedNavigationItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
