package com.example.cloudyfoxdemo.dashboard.model;

import com.google.gson.annotations.SerializedName;

public class DashboardNepalModel {

    @SerializedName("country")
    public String country;

    @SerializedName("code")
    public String code;

    @SerializedName("confirmed")
    public long confirmed;

    @SerializedName("recovered")
    public long recovered;

    @SerializedName("critical")
    public long critical;

    @SerializedName("deaths")
    public long deaths;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("lastChange")
    public String lastChange;

    @SerializedName("lastUpdate")
    public String lastUpdate;


    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public long getRecovered() {
        return recovered;
    }

    public long getCritical() {
        return critical;
    }

    public long getDeaths() {
        return deaths;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getLastChange() {
        return lastChange;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}
