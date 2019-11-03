package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.myapplication.database.ApplicationDatabase;
import com.example.myapplication.database.MyDao;
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

public class MyRepository {

    private MyDao myDao;
    private LiveData<List<HomeTableOne>> getAllDatahometableone;
    private LiveData<List<HomeTableTwo>> getAllDatahometabletwo;
    private LiveData<List<HomeTableThree>> getAllDatahometablethree;
    private LiveData<List<DashboardTableOne>> getAllDatadashboardone;
    private LiveData<List<DashboardTableTwo>> getAllDatadashboardtwo;
    private LiveData<List<DashboardTableThree>> getAllDatadashboardthree;
    private LiveData<List<NotificationTableOne>> getAllDatanotificationone;
    private LiveData<List<NotificationTableTwo>> getAllDatanotificationtwo;
    private LiveData<List<NotificationTableThree>> getAllDatanotificationthree;

    MyRepository(Application application) {
        ApplicationDatabase db = ApplicationDatabase.getDatabase(application);
        myDao = db.myDao();
        getAllDatahometableone = myDao.getAllDatahometableone();
        getAllDatahometabletwo = myDao.getAllDatahometabletwo();
        getAllDatahometablethree = myDao.getAllDatahometablethree();
        getAllDatadashboardone = myDao.getAllDatadashboardtableone();
        getAllDatadashboardtwo = myDao.getAllDatadashboardtabletwo();
        getAllDatadashboardthree = myDao.getAllDatadashboardtablethree();
        getAllDatanotificationone = myDao.getAllDatanotificationtableone();
        getAllDatanotificationtwo = myDao.getAllDatanotificationtabletwo();
        getAllDatanotificationthree = myDao.getAllDatanotificationtablethree();
    }

    LiveData<List<HomeTableOne>> getAllDatahometableone() {
        return getAllDatahometableone;
    }

    LiveData<List<HomeTableTwo>> getAllDatahometabletwo() {
        return getAllDatahometabletwo;
    }
    LiveData<List<HomeTableThree>> getAllDatahometablethree() {
        return getAllDatahometablethree;
    }
    LiveData<List<DashboardTableOne>> getAllDatadashboardtableone() {
        return getAllDatadashboardone;
    }
    LiveData<List<DashboardTableTwo>> getAllDatadashboardtabletwo() {
        return getAllDatadashboardtwo;
    }
    LiveData<List<DashboardTableThree>> getAllDatadashboardtablethree() {
        return getAllDatadashboardthree;
    }
    LiveData<List<NotificationTableOne>> getAllDatanotificationtableone() {
        return getAllDatanotificationone;
    }
    LiveData<List<NotificationTableTwo>> getAllDatanotificationtabletwo() {
        return getAllDatanotificationtwo;
    }
    LiveData<List<NotificationTableThree>> getAllDatanotificationtablethree() {
        return getAllDatanotificationthree;
    }

    public void insert (String table,String firstName, String lastName, String age, String activity) {
        new insertAsyncTask(myDao,firstName,lastName,age,activity).execute(table);
    }

    public void delete (HomeTableOne homeTableOne) {
        new deleteAsyncTaskHomeOne(myDao).execute(homeTableOne);
    }

    public void delete (HomeTableTwo homeTableTwo) {
        new deleteAsyncTaskHomeTwo(myDao).execute(homeTableTwo);
    }

    public void delete (HomeTableThree homeTableThree) {
        new deleteAsyncTaskHomeThree(myDao).execute(homeTableThree);
    }

    public void delete (DashboardTableOne dashboardTableOne) {
        new deleteAsyncTaskDashboardOne(myDao).execute(dashboardTableOne);
    }

    public void delete (DashboardTableTwo dashboardTableTwo) {
        new deleteAsyncTaskDashboardTwo(myDao).execute(dashboardTableTwo);
    }

    public void delete (DashboardTableThree dashboardTableThree) {
        new deleteAsyncTaskDashboardThree(myDao).execute(dashboardTableThree);
    }

    public void delete (NotificationTableOne notificationTableOne) {
        new deleteAsyncTaskNotificationOne(myDao).execute(notificationTableOne);
    }

    public void delete (NotificationTableTwo notificationTableTwo) {
        new deleteAsyncTaskNotificationTwo(myDao).execute(notificationTableTwo);
    }

    public void delete (NotificationTableThree notificationTableThree) {
        new deleteAsyncTaskNotificationThree(myDao).execute(notificationTableThree);
    }

    private static class insertAsyncTask extends AsyncTask<String, Void, Void> {

        private MyDao mAsyncTaskDao;
        private String firstName,lastName,age,activity;

        insertAsyncTask(MyDao myDao,String firstName, String lastName, String age, String activity) {
            mAsyncTaskDao = myDao;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.activity = activity;
        }

        @Override
        protected Void doInBackground(final String... params) {
            try {
                //private String arrActivity[] = {"Select", "Home", "Dashboard", "Notification"};
                //    private String arrTab[] = {"Select", "TAB 1", "TAB 2", "TAB 3"};

                if (activity.equalsIgnoreCase("Home")) {
                    if (params[0].equalsIgnoreCase("TAB 1")) {
                        HomeTableOne homeTableOne = new HomeTableOne(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(homeTableOne);
                    } else if (params[0].equalsIgnoreCase("TAB 2")) {
                        HomeTableTwo homeTableTwo = new HomeTableTwo(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(homeTableTwo);
                    } else if (params[0].equalsIgnoreCase("TAB 3")) {
                        HomeTableThree homeTableThree = new HomeTableThree(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(homeTableThree);
                    }
                } else if (activity.equalsIgnoreCase("Dashboard")) {
                    if (params[0].equalsIgnoreCase("TAB 1")) {
                        DashboardTableOne dashboardTableOne = new DashboardTableOne(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(dashboardTableOne);
                    } else if (params[0].equalsIgnoreCase("TAB 2")) {
                        DashboardTableTwo dashboardTableTwo = new DashboardTableTwo(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(dashboardTableTwo);
                    } else if (params[0].equalsIgnoreCase("TAB 3")) {
                        DashboardTableThree dashboardTableThree = new DashboardTableThree(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(dashboardTableThree);
                    }
                } else if (activity.equalsIgnoreCase("Notification")) {
                    if (params[0].equalsIgnoreCase("TAB 1")) {
                        NotificationTableOne notificationTableOne = new NotificationTableOne(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(notificationTableOne);
                    } else if (params[0].equalsIgnoreCase("TAB 2")) {
                        NotificationTableTwo notificationTableTwo = new NotificationTableTwo(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(notificationTableTwo);
                    } else if (params[0].equalsIgnoreCase("TAB 3")) {
                        NotificationTableThree notificationTableThree = new NotificationTableThree(firstName,lastName,Integer.parseInt(age));
                        mAsyncTaskDao.insert(notificationTableThree);
                    }
                }
            }catch (Exception e){
                System.out.println("Insert Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskHomeOne extends AsyncTask<HomeTableOne, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskHomeOne(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final HomeTableOne... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskHomeTwo extends AsyncTask<HomeTableTwo, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskHomeTwo(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final HomeTableTwo... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskHomeThree extends AsyncTask<HomeTableThree, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskHomeThree(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final HomeTableThree... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskDashboardOne extends AsyncTask<DashboardTableOne, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskDashboardOne(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final DashboardTableOne... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskDashboardTwo extends AsyncTask<DashboardTableTwo, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskDashboardTwo(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final DashboardTableTwo... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskDashboardThree extends AsyncTask<DashboardTableThree, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskDashboardThree(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final DashboardTableThree... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskNotificationOne extends AsyncTask<NotificationTableOne, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskNotificationOne(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final NotificationTableOne... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskNotificationTwo extends AsyncTask<NotificationTableTwo, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskNotificationTwo(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final NotificationTableTwo... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }

    private static class deleteAsyncTaskNotificationThree extends AsyncTask<NotificationTableThree, Void, Void> {

        private MyDao mAsyncTaskDao;

        deleteAsyncTaskNotificationThree(MyDao myDao) {
            mAsyncTaskDao = myDao;
        }

        @Override
        protected Void doInBackground(final NotificationTableThree... params) {
            try {
                mAsyncTaskDao.delete(params[0]);
            }catch (Exception e){
                System.out.println("Delete Exception Akshay: "+e);
            }
            return null;
        }
    }


}
