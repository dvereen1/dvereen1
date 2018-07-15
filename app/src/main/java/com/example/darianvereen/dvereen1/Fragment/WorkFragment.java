package com.example.darianvereen.dvereen1.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.darianvereen.dvereen1.MainActivity;
import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.activity.AdvanceListViewActivity;
import com.example.darianvereen.dvereen1.activity.Quiz2Activity;

/**

 */
public class WorkFragment extends Fragment {

    private Button q1, q2, q3, sub;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work, container, false);

        q1 =  (Button) view.findViewById(R.id.quiz1_btn);
        q2= (Button) view.findViewById(R.id.quiz2_btn);
        q3= (Button) view.findViewById(R.id.quiz3_btn);
        sub= (Button) view.findViewById(R.id.btn_submit);


        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Quiz 1", Toast.LENGTH_SHORT).show();
            }
        });

        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Quiz2Activity.class);
                startActivity(intent);
            }
        });
        return view;

    }




}
