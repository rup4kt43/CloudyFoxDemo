package com.example.cloudyfoxdemo;

import android.app.Application;

import com.example.cloudyfoxdemo.di.components.AppComponent;
import com.example.cloudyfoxdemo.di.components.DaggerAppComponent;

public class BaseApplication  extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();


    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
