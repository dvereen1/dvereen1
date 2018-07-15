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


public class Quiz2Fragment extends Fragment {


    public Quiz2Fragment() {
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
       ((MainActivity) getActivity()).startActivity(ViewPagerActivity.class);
        return inflater.inflate(R.layout.fragment_quiz2, container, false);
    }



}
