package com.example.darianvereen.dvereen1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darianvereen.dvereen1.R;
import com.example.darianvereen.dvereen1.bean.Base;

public class IntentAndBundleActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_and_bundle);
        Intent intent = getIntent();
        //We are retrieving different messages given by the intent
        //We use bundles to retrieve objects and their propeties
        Bundle bundle = intent.getBundleExtra("B");
        Base newBase = (Base) bundle.getSerializable("Base");
        String bundle_msg = bundle.getString("B_Msg");
        int number =  intent.getIntExtra("No",0);
        String msg = intent.getStringExtra("MSG");
        Toast.makeText(this,String.valueOf(number), Toast.LENGTH_SHORT).show();
        tv = findViewById(R.id.intent_tv);
        tv.setText(newBase.getName());


    }
}
