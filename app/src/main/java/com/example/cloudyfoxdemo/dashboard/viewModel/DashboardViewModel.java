package com.example.cloudyfoxdemo.dashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cloudyfoxdemo.DisposableManager;
import com.example.cloudyfoxdemo.dashboard.model.DashboardModel;
import com.example.cloudyfoxdemo.dashboard.model.DashboardNepalModel;
import com.example.cloudyfoxdemo.dashboard.model.DataAll;
import com.example.cloudyfoxdemo.dashboard.repository.DashboardRepository;

import java.util.List;
import java.util.function.BiFunction;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class DashboardViewModel extends ViewModel {

    private DashboardRepository dashboardRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    List<DashboardModel> dashboardModels;
    List<DashboardNepalModel> dashboardNepalModels;



    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    private MutableLiveData<List<DashboardModel>> dashboardMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<DashboardNepalModel>> dashboardNepalMutableLiveData = new MutableLiveData<>();


    @Inject
    public DashboardViewModel(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;


    }

    public MutableLiveData<List<DashboardModel>> getDashboardDataMutableLiveData() {
        loadDashboardData();
        return dashboardMutableLiveData;
    }

    public MutableLiveData<List<DashboardNepalModel>> getDashboardNepalMutableLiveData() {
        loadDashboardNepalData();
        return dashboardNepalMutableLiveData;
    }

    private void loadDashboardNepalData() {




        dashboardRepository.getDashboardNepalData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserver<List<DashboardNepalModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<DashboardNepalModel> dashboardNepalModels) {
                        isLoading.setValue(false);

                        getDashboardNepalMutableLiveData().setValue(dashboardNepalModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        error.setValue(e.getMessage());
                        isLoading.setValue(false);
                    }
                });




    }

    private void loadDashboardData() {

        disposable.add(dashboardRepository.getDashboardDataSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DashboardModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<DashboardModel> dashboardModels) {
                        isLoading.setValue(false);
                        getDashboardDataMutableLiveData().setValue(dashboardModels);



                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        error.setValue(e.getMessage());
                        isLoading.setValue(false);

                    }
                }));


    }

}
