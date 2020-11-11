package com.example.cloudyfoxdemo.di.modules;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.cloudyfoxdemo.dashboard.viewModel.DashboardViewModel;
import com.example.cloudyfoxdemo.dashboard.viewModel.ViewModelFactory;
import com.example.cloudyfoxdemo.di.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel.class)
    abstract ViewModel bindViewModel(DashboardViewModel dashboardViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);

}
