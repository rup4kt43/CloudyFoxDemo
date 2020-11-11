package com.example.cloudyfoxdemo.di.components;


import com.example.cloudyfoxdemo.MainActivity;
import com.example.cloudyfoxdemo.di.modules.ContextModule;
import com.example.cloudyfoxdemo.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})

public interface AppComponent {

    void inject(MainActivity mainActivity);
}
