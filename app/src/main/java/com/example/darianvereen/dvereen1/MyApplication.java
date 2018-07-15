package com.example.darianvereen.dvereen1;

import android.app.Application;

import com.example.darianvereen.dvereen1.util.LogUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.setLogSwitch(true);
    }
}
