package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

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

@Dao
public interface MyDao {

    //insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HomeTableOne homeTableOne);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HomeTableTwo homeTableTwo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HomeTableThree homeTableThree);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DashboardTableOne dashboardTableOne);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DashboardTableTwo dashboardTableTwo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DashboardTableThree dashboardTableThree);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NotificationTableOne notificationTableOne);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NotificationTableTwo notificationTableTwo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NotificationTableThree notificationTableThree);

    /*@Query("delete FROM HomeTableOne WHERE age <> :minAge")
    void deleteAll(int minAge);*/


    // delete
    @Delete
    void delete(HomeTableOne homeTableOne);

    @Delete
    void delete(HomeTableTwo homeTableTwo);

    @Delete
    void delete(HomeTableThree homeTableThree);

    @Delete
    void delete(DashboardTableOne dashboardTableOne);

    @Delete
    void delete(DashboardTableTwo dashboardTableTwo);

    @Delete
    void delete(DashboardTableThree dashboardTableThree);

    @Delete
    void delete(NotificationTableOne notificationTableOne);

    @Delete
    void delete(NotificationTableTwo notificationTableTwo);

    @Delete
    void delete(NotificationTableThree notificationTableThree);

    // select *
    @Query("SELECT * from hometableone")
    LiveData<List<HomeTableOne>> getAllDatahometableone();

    @Query("SELECT * from hometabletwo")
    LiveData<List<HomeTableTwo>> getAllDatahometabletwo();

    @Query("SELECT * from hometablethree")
    LiveData<List<HomeTableThree>> getAllDatahometablethree();

    @Query("SELECT * from dashboardtableone")
    LiveData<List<DashboardTableOne>> getAllDatadashboardtableone();

    @Query("SELECT * from dashboardtabletwo")
    LiveData<List<DashboardTableTwo>> getAllDatadashboardtabletwo();

    @Query("SELECT * from dashboardtablethree")
    LiveData<List<DashboardTableThree>> getAllDatadashboardtablethree();

    @Query("SELECT * from notificationtableone")
    LiveData<List<NotificationTableOne>> getAllDatanotificationtableone();

    @Query("SELECT * from notificationtabletwo")
    LiveData<List<NotificationTableTwo>> getAllDatanotificationtabletwo();

    @Query("SELECT * from notificationtablethree")
    LiveData<List<NotificationTableThree>> getAllDatanotificationtablethree();


}
