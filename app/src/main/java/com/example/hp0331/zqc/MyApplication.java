package com.example.hp0331.zqc;

import android.app.Application;

import com.example.hp0331.zqc.beans.BMLocation;


/**
 * Created by hp0331 on 2017/6/16.
 */

public class MyApplication extends Application {
    public BMLocation bmLocation;
    @Override
    public void onCreate() {
        super.onCreate();
        bmLocation=new BMLocation();
    }
}
