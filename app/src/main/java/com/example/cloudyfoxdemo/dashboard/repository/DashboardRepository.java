package com.example.cloudyfoxdemo.dashboard.repository;

import com.example.cloudyfoxdemo.dashboard.model.DashboardModel;
import com.example.cloudyfoxdemo.dashboard.model.DashboardNepalModel;
import com.example.cloudyfoxdemo.dashboard.remote.DashboardService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;


public class DashboardRepository {

    private DashboardService dashboardService;

    public DashboardRepository(){

    }




    @Inject
    public DashboardRepository(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public Single<List<DashboardModel>> getDashboardDataSingle(){

        return dashboardService.getDashboardData();
    }

    public Single<List<DashboardNepalModel>> getDashboardNepalData(){
        return dashboardService.getDashboardNepalData("Nepal");
    }
}
