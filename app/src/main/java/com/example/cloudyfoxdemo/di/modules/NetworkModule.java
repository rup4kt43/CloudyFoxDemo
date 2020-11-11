package com.example.cloudyfoxdemo.di.modules;

import com.example.cloudyfoxdemo.dashboard.remote.DashboardService;
import com.example.cloudyfoxdemo.utils.ConstantValue;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module (includes = ViewModelModule.class)
public abstract class NetworkModule {

    static String BASE_URL = "https://covid-19-data.p.rapidapi.com";

    @Provides
    @Singleton
    static Retrofit provideRetrofit(){

        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader(ConstantValue.api_key_header,ConstantValue.api_key)
                        .build();
                return chain.proceed(request);
            }
        });
        builder.followRedirects(false);
        OkHttpClient client = builder.build();


        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Provides
    @Singleton
    static DashboardService provideDashboardService(Retrofit retrofit){
        return retrofit.create(DashboardService.class);
    }
}
