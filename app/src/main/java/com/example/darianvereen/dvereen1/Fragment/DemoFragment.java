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

import com.example.darianvereen.dvereen1.MainActivity;
import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.activity.AdvanceListViewActivity;
import com.example.darianvereen.dvereen1.activity.AdvanceViewPagerActivity;
import com.example.darianvereen.dvereen1.activity.AnimationActivity;
import com.example.darianvereen.dvereen1.activity.AnimatorActivity;
import com.example.darianvereen.dvereen1.activity.CheckBoxActivity;
import com.example.darianvereen.dvereen1.activity.DialogActivity;
import com.example.darianvereen.dvereen1.activity.GestureActivity;
import com.example.darianvereen.dvereen1.activity.HandlerActivity;
import com.example.darianvereen.dvereen1.activity.IntentAndBundleActivity;
import com.example.darianvereen.dvereen1.activity.LaunchModeActivity;
import com.example.darianvereen.dvereen1.activity.NinePatchActivity;
import com.example.darianvereen.dvereen1.activity.NotificationActivity;
import com.example.darianvereen.dvereen1.activity.RadioGroupActivity;
import com.example.darianvereen.dvereen1.activity.ScaleTypeActivity;
import com.example.darianvereen.dvereen1.activity.ViewPagerActivity;
import com.example.darianvereen.dvereen1.adapter.AdvancePagerAdapter;
import com.example.darianvereen.dvereen1.adapter.MainListAdapter;
import com.example.darianvereen.dvereen1.adapter.ScaleTypeAdapter;
import com.example.darianvereen.dvereen1.bean.Base;

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
        list.add("ScaleType");
        list.add("Intent&Bundle");
        list.add("Notification");
        list.add("AdvancedlistView");
        list.add("AdvanceViewPager");
        list.add("RadioGroup");
        list.add("Checkbox");
        list.add("Dialogs");
        list.add("Handler");
        list.add("Animation");
        list.add("Animator");
        list.add("Gesture");

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
                        break;
                    case 2:
                        intent.setClass(getActivity(), NinePatchActivity.class);
                        startActivity(intent);
                        break;


                    case 3:
                        intent.setClass(getActivity(), ScaleTypeActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.setClass(getActivity(), IntentAndBundleActivity.class);
                        intent.putExtra("MSG", "Say Hello!");
                        intent.putExtra("No", 10);
                        Base newBase = new Base();
                        newBase.setName("Darian");
                        Bundle bundle = new Bundle();
                        bundle.putInt("B_Msg", 100);
                        bundle.putString("B_Msg", "FromBundle");
                        //This is the only way to pass objects within a bundle
                        //into another activity
                        bundle.putSerializable("Base", newBase);
                        intent.putExtra("B", bundle);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.setClass(getActivity(), NotificationActivity.class);
                        startActivity(intent);
                        break;

                    case 6:
                        intent.setClass(getActivity(), AdvanceListViewActivity.class);
                        startActivity(intent);
                        break;

                    case 7:
                        ((MainActivity) getActivity()).startActivity(AdvanceViewPagerActivity.class);
                        break;
                    case 8:
                        ((MainActivity) getActivity()).startActivity(RadioGroupActivity.class);
                        break;
                    case 9:
                        ((MainActivity) getActivity()).startActivity(CheckBoxActivity.class);
                        break;

                    case 10:
                        ((MainActivity) getActivity()).startActivity(DialogActivity.class);
                        break;

                    case 11:
                        ((MainActivity) getActivity()).startActivity(HandlerActivity.class);
                        break;

                    case 12:
                        ((MainActivity) getActivity()).startActivity(AnimationActivity.class);
                        break;
                    case 13:
                        ((MainActivity) getActivity()).startActivity(AnimatorActivity.class);
                        break;
                        case 14:
                        ((MainActivity) getActivity()).startActivity(GestureActivity.class);
                        break;
                    default:

                }
            }
        });

        return view;
    }

}
