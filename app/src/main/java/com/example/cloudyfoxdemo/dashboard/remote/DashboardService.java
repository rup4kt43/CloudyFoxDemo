package com.example.cloudyfoxdemo.dashboard.remote;


import com.example.cloudyfoxdemo.dashboard.model.DashboardModel;
import com.example.cloudyfoxdemo.dashboard.model.DashboardNepalModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface DashboardService {

    @GET("/totals")
    Single<List<DashboardModel>> getDashboardData();

    @GET("/country")
    Single<List<DashboardNepalModel>> getDashboardNepalData(@Query("name") String name);






}
