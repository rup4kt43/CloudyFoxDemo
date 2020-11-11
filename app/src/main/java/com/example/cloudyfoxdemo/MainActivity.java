package com.example.cloudyfoxdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.cloudyfoxdemo.dashboard.model.DashboardModel;
import com.example.cloudyfoxdemo.dashboard.model.DashboardNepalModel;
import com.example.cloudyfoxdemo.dashboard.viewModel.DashboardViewModel;
import com.example.cloudyfoxdemo.databinding.ActivityMainBinding;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;


    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private DashboardViewModel dashboardViewModel;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpViewBinding();
        setUpDagger();
        initViewModel();
        initObserver();



    }

    private void initObserver() {

        dashboardViewModel.getDashboardDataMutableLiveData().observe(this, new Observer<List<DashboardModel>>() {
            @Override
            public void onChanged(List<DashboardModel> dashboardModels) {
                activityMainBinding.setDashboardModel(dashboardModels.get(0));

            }
        });

        dashboardViewModel.getDashboardNepalMutableLiveData().observe(this, new Observer<List<DashboardNepalModel>>() {
            @Override
            public void onChanged(List<DashboardNepalModel> dashboardNepalModels) {
                activityMainBinding.setDashboardNepalModel(dashboardNepalModels.get(0));
            }
        });

    }

    private void initViewModel() {
        dashboardViewModel= ViewModelProviders.of(this, viewModelFactory).get(DashboardViewModel.class);
    }

    private void setUpDagger() {
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
    }

    private void setUpViewBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

    @Override
    protected void onDestroy() {
        DisposableManager.dispose();
        super.onDestroy();
    }
}