package com.example.cloudyfoxdemo.dashboard.model;

import com.google.gson.annotations.SerializedName;

public class DashboardModel {

    @SerializedName("confirmed")
    public long confirmedCases;

    @SerializedName("recovered")
    public long recoveredCases;

    @SerializedName("critical")
    public long criticalCases;

    @SerializedName("deaths")
    public long deaths;

    @SerializedName("lastChange")
    public String lastChange;

    @SerializedName("lastUpdate")
    public String lastUpdate;


    public DashboardModel(long confirmedCases, long recoveredCases, long criticalCases, long deaths, String lastChange, String lastUpdate) {
        this.confirmedCases = confirmedCases;
        this.recoveredCases = recoveredCases;
        this.criticalCases = criticalCases;
        this.deaths = deaths;
        this.lastChange = lastChange;
        this.lastUpdate = lastUpdate;
    }


    public long getConfirmedCases() {
        return confirmedCases;
    }

    public long getRecoveredCases() {
        return recoveredCases;
    }

    public long getCriticalCases() {
        return criticalCases;
    }

    public long getDeaths() {
        return deaths;
    }

    public String getLastChange() {
        return lastChange;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}
