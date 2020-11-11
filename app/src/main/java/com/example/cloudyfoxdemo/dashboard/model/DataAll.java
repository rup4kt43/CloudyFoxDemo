package com.example.cloudyfoxdemo.dashboard.model;

import java.util.List;

public class DataAll {

    public List<DashboardModel> dashboardModel;
    public List<DashboardNepalModel> dashboardNepalModel;


    public DataAll(){}

    public DataAll(List<DashboardModel> t1, List<DashboardNepalModel> t2) {
        this.dashboardModel = t1;
        this.dashboardNepalModel =t2;
    }

    public List<DashboardModel> getDashboardModel() {
        return dashboardModel;
    }

    public void setDashboardModel(List<DashboardModel> dashboardModel) {
        this.dashboardModel = dashboardModel;
    }

    public List<DashboardNepalModel> getDashboardNepalModel() {
        return dashboardNepalModel;
    }

    public void setDashboardNepalModel(List<DashboardNepalModel> dashboardNepalModel) {
        this.dashboardNepalModel = dashboardNepalModel;
    }
}
