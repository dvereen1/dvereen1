package com.example.darianvereen.dvereen1.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;

import com.example.darianvereen.dvereen1.Fragment.DemoFragment;
import com.example.darianvereen.dvereen1.Fragment.WorkFragment;
import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.adapter.AdvancePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvanceViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.advance_viewpager_title)
    TabLayout title;
    @BindView(R.id.advance_viewpager)
    ViewPager vp;

    private List<Pair<String, Fragment>> fragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_view_pager);
        ButterKnife.bind(this);

        fragmentList.add(new Pair<String, Fragment>("First", new WorkFragment()));
        fragmentList.add(new Pair<String, Fragment>("Second", new DemoFragment()));
        fragmentList.add(new Pair<String, Fragment>("Third", new WorkFragment()));
        fragmentList.add(new Pair<String, Fragment>("Fourth", new DemoFragment()));


        AdvancePagerAdapter adapter =
                new AdvancePagerAdapter(getSupportFragmentManager(), fragmentList);

        vp.setAdapter(adapter);
        title.setupWithViewPager(vp);


    }
}
