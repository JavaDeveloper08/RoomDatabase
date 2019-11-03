package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.database.tables.DashboardTableOne;
import com.example.myapplication.database.tables.DashboardTableThree;
import com.example.myapplication.database.tables.DashboardTableTwo;
import com.example.myapplication.database.tables.HomeTableOne;
import com.example.myapplication.database.tables.HomeTableThree;
import com.example.myapplication.database.tables.HomeTableTwo;
import com.example.myapplication.database.tables.NotificationTableOne;
import com.example.myapplication.database.tables.NotificationTableThree;
import com.example.myapplication.database.tables.NotificationTableTwo;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private MyRepository mRepository;

    private LiveData<List<HomeTableOne>> getAllDatahometableone;
    private LiveData<List<HomeTableTwo>> getAllDatahometabletwo;
    private LiveData<List<HomeTableThree>> getAllDatahometablethree;
    private LiveData<List<DashboardTableOne>> getAllDatadashboardone;
    private LiveData<List<DashboardTableTwo>> getAllDatadashboardtwo;
    private LiveData<List<DashboardTableThree>> getAllDatadashboardthree;
    private LiveData<List<NotificationTableOne>> getAllDatanotificationone;
    private LiveData<List<NotificationTableTwo>> getAllDatanotificationtwo;
    private LiveData<List<NotificationTableThree>> getAllDatanotificationthree;

    public MyViewModel (Application application) {
        super(application);
        mRepository = new MyRepository(application);
        getAllDatahometableone = mRepository.getAllDatahometableone();
        getAllDatahometabletwo = mRepository.getAllDatahometabletwo();
        getAllDatahometablethree = mRepository.getAllDatahometablethree();
        getAllDatadashboardone = mRepository.getAllDatadashboardtableone();
        getAllDatadashboardtwo = mRepository.getAllDatadashboardtabletwo();
        getAllDatadashboardthree = mRepository.getAllDatadashboardtablethree();
        getAllDatanotificationone = mRepository.getAllDatanotificationtableone();
        getAllDatanotificationtwo = mRepository.getAllDatanotificationtabletwo();
        getAllDatanotificationthree = mRepository.getAllDatanotificationtablethree();
    }

    public LiveData<List<HomeTableOne>> getAllDatahometableone() { return getAllDatahometableone; }
    public LiveData<List<HomeTableTwo>> getAllDatahometabletwo() { return getAllDatahometabletwo; }
    public LiveData<List<HomeTableThree>> getAllDatahometablethree() { return getAllDatahometablethree; }
    public LiveData<List<DashboardTableOne>> getAllDatadashboardone() { return getAllDatadashboardone; }
    public LiveData<List<DashboardTableTwo>> getAllDatadashboardtwo() { return getAllDatadashboardtwo; }
    public LiveData<List<DashboardTableThree>> getAllDatadashboardthree() { return getAllDatadashboardthree; }
    public LiveData<List<NotificationTableOne>> getAllDatanotificationone() { return getAllDatanotificationone; }
    public LiveData<List<NotificationTableTwo>> getAllDatanotificationtwo() { return getAllDatanotificationtwo; }
    public LiveData<List<NotificationTableThree>> getAllDatanotificationthree() { return getAllDatanotificationthree; }

    public void insert(String table,String firstName, String lastName, String age, String activity) { mRepository.insert(table,firstName,lastName,age,activity); }

    public void delete(HomeTableOne homeTableOne) { mRepository.delete(homeTableOne); }
    public void delete(HomeTableTwo homeTableTwo) { mRepository.delete(homeTableTwo); }
    public void delete(HomeTableThree homeTableThree) { mRepository.delete(homeTableThree); }
    public void delete(DashboardTableOne dashboardTableOne) { mRepository.delete(dashboardTableOne); }
    public void delete(DashboardTableTwo dashboardTableTwo) { mRepository.delete(dashboardTableTwo); }
    public void delete(DashboardTableThree dashboardTableThree) { mRepository.delete(dashboardTableThree); }
    public void delete(NotificationTableOne notificationTableOne) { mRepository.delete(notificationTableOne); }
    public void delete(NotificationTableTwo notificationTableTwo) { mRepository.delete(notificationTableTwo); }
    public void delete(NotificationTableThree notificationTableThree) { mRepository.delete(notificationTableThree); }

}
