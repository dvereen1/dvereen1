package com.example.darianvereen.dvereen1.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.darianvereen.dvereen1.Fragment.DemoFragment;
import com.example.darianvereen.dvereen1.Fragment.WorkFragment;
import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment> ();

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.viewpager_vp);

        fragmentList.add(new DemoFragment());
        fragmentList.add(new WorkFragment());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(adapter);

        adapter.updateList(fragmentList);

        //viewPage will have different pages
        //we will need another adapter to select content according to our contentlist

    }
}
