package com.example.darianvereen.dvereen1.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darianvereen.dvereen1.MainActivity;
import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.activity.ViewPagerActivity;

public class BlueFragment extends Fragment {

    public BlueFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blue, container, false);

        //((MainActivity) getActivity()).startActivity(ViewPagerActivity.class);

        return view;

    }


}
