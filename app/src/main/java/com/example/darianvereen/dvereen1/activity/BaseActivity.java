package com.example.darianvereen.dvereen1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    public void startActivity(@NonNull Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }



    public void startActivity(@NonNull Class<?> cls,String key,String s){
        Intent intent = new Intent();
        intent.setClass(this, cls);
        intent.putExtra(key,s);
        startActivity(intent);
    }


    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void longToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
