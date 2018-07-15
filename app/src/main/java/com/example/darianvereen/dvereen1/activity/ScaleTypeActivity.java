package com.example.darianvereen.dvereen1.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.adapter.ScaleTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScaleTypeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private View view1, view2, view3;
    private List<View> viewList = new ArrayList<View>();
    private ScaleTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_type);
        initView();




    }

    //First we make an adapter in a seperate file then we make layout files define how they
    //look within those files and we initiliaze them here.
    //We will first need a layout inflator
    //this method will initialize all the views we inflate and add the to the viewList

    private void initView(){
        viewPager = findViewById(R.id.scal_type_vp);
        LayoutInflater lf = getLayoutInflater().from(this);
        view1 = lf.inflate(R.layout.scale_type_center_inside, null);
        view2 = lf.inflate(R.layout.scale_type_center, null);
        view3 = lf.inflate(R.layout.scale_type_center_crop, null);

        //We add each of the views to a List
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        //Now we use our adapter that we created in the seperate file and initialize it here
        //and pass it our viewList

        adapter = new ScaleTypeAdapter(viewList);
        viewPager.setAdapter(adapter);



    }
}
