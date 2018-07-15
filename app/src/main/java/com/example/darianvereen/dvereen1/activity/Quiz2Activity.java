package com.example.darianvereen.dvereen1.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.darianvereen.dvereen1.Fragment.BlueFragment;
import com.example.darianvereen.dvereen1.Fragment.DemoFragment;
import com.example.darianvereen.dvereen1.Fragment.WorkFragment;
import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.adapter.AdvListAdapter;
import com.example.darianvereen.dvereen1.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Quiz2Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private ListView listView;
    private AdvListAdapter adapter;
   // private ViewPagerAdapter adapter2;
    private List<String> list = new ArrayList<String>();
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment> ();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_list_view);

        //CREATING VIEWPAGER AS HEADER


        list.add("Hello!");
        list.add("Hey!");
        list.add("Whats UP?!");
        list.add("Nada mucho");
        list.add("GOOD");
        list.add("yea");
        list.add("What're gonna do today");
        list.add("Who knows");

        listView = findViewById(R.id.adv_lv);
        View view = getLayoutInflater().inflate(R.layout.listview_header, listView, false );
        listView.addHeaderView(view, null, false);


        viewPager = findViewById(R.id.viewpager_vp);
        fragmentList.add(new DemoFragment());
        fragmentList.add(new WorkFragment());
        fragmentList.add(new BlueFragment());

        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(vpa);

        adapter = new AdvListAdapter(this, list);

         listView.setAdapter(adapter);




    }




}


