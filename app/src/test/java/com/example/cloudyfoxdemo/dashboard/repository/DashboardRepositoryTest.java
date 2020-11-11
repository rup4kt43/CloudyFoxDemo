package com.example.cloudyfoxdemo.dashboard.repository;

import com.example.cloudyfoxdemo.dashboard.remote.DashboardService;
import com.example.cloudyfoxdemo.utils.ConstantValue;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class DashboardRepositoryTest {
    @Spy
    DashboardRepository dashboardRepository;

    @Mock
            Retrofit retrofit;

     String BASE_URL = "https://covid-19-data.p.rapidapi.com";



    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void getDashboardDataSingle() {
        doReturn(dashboardRepository.getDashboardDataSingle()).when(dashboardRepository).getDashboardNepalData();
        System.out.println(new Gson().toJson(dashboardRepository.getDashboardDataSingle()));
    }

    @Test
    public void getDashboardNepalData() {

        doReturn(dashboardRepository.getDashboardNepalData()).when(dashboardRepository).getDashboardNepalData();
        System.out.println(new Gson().toJson(dashboardRepository.getDashboardNepalData()));
    }
}