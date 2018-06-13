package com.example.darianvereen.dvereen1.Fragment;


import android.content.Intent;
import android.graphics.NinePatch;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.activity.LaunchModeActivity;
import com.example.darianvereen.dvereen1.activity.NinePatchActivity;
import com.example.darianvereen.dvereen1.activity.ViewPagerActivity;
import com.example.darianvereen.dvereen1.adapter.MainListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment {

    private MainListAdapter adapter;
    //This array list will hold the list of items in our frament view
    public List<String> list = new ArrayList<String>();
    private ListView listView;

    public DemoFragment() {

        list.add("LaunchMode");
        list.add("SimpleViewPager");
        list.add("9Patch");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");

        //create an instance of mainadapter here



    }

    //Below is an adapter for the listview which makes things interactive?


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        listView = view.findViewById(R.id.main_demo_lv);
        adapter = new MainListAdapter(getContext(), list);
        listView.setAdapter(adapter);
       // View headerView = new View(getActivity());

        //listView.addHeaderView(headerView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent =  new Intent();
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    //adding a headerview to our listview  increments every position by 1
                    case 0:
                        //go to LaunchModeActivity
                       // Intent intent =  new Intent();
                        //the first parameter is the current activity while the second is the next activty we want t
                        //go to
                        intent.setClass(getActivity(), LaunchModeActivity.class);
                        startActivity(intent);
                        break;

                    case 1:

                        //the first parameter is the current activity while the second is the next activty we want t
                        //go to
                        intent.setClass(getActivity(), ViewPagerActivity.class);
                        startActivity(intent);

                    case 2:
                        intent.setClass(getActivity(), NinePatchActivity.class);
                        startActivity(intent);
                    default:

                }
            }
        });

        return view;
    }

}
