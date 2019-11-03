package com.example.myapplication.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.database.tables.DashboardTableOne;
import com.example.myapplication.database.tables.DashboardTableThree;
import com.example.myapplication.database.tables.DashboardTableTwo;
import com.example.myapplication.database.tables.HomeTableOne;
import com.example.myapplication.database.tables.HomeTableThree;
import com.example.myapplication.database.tables.HomeTableTwo;
import com.example.myapplication.database.tables.NotificationTableOne;
import com.example.myapplication.database.tables.NotificationTableThree;
import com.example.myapplication.database.tables.NotificationTableTwo;

@Database(entities = {HomeTableOne.class, HomeTableTwo.class, HomeTableThree.class, DashboardTableOne.class,
        DashboardTableTwo.class,DashboardTableThree.class, NotificationTableOne.class, NotificationTableTwo.class, NotificationTableThree.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {

    public abstract MyDao myDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile ApplicationDatabase INSTANCE;

    public static ApplicationDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ApplicationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ApplicationDatabase.class, "my_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            //.addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            //dummy data
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final MyDao mDao;

        PopulateDbAsync(ApplicationDatabase db) {
            mDao = db.myDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            //mDao.deleteAll();

            /*Word word = new Word("Hello",System.currentTimeMillis()+"");
            mDao.insert(word);
            word = new Word("World",System.currentTimeMillis()+"");
            mDao.insert(word);*/

            String firstName[] = {"akshay","vishal","mukund","ayaz","pratik","ronil", "akshay111","vishal111","mukund111","ayaz111","pratik111","ronil111"};
            String lastName[] = {"pujari","naikvadi","joshi","khan","barje","rauth", "pujari","naikvadi","joshi","khan","barje","rauth"};
            int age[] = {24,24,27,27,26,27,24,24,27,27,26,27};

            for (int i = 0; i<firstName.length; i++){
                HomeTableOne homeTableOne = new HomeTableOne(firstName[i],lastName[i],age[i]);
                mDao.insert(homeTableOne);

                HomeTableTwo homeTableTwo = new HomeTableTwo(firstName[i],lastName[i],age[i]);
                mDao.insert(homeTableTwo);

                HomeTableThree homeTableThree = new HomeTableThree(firstName[i],lastName[i],age[i]);
                mDao.insert(homeTableThree);

                DashboardTableOne dashboardTableOne = new DashboardTableOne(firstName[i],lastName[i],age[i]);
                mDao.insert(dashboardTableOne);

                DashboardTableTwo dashboardTableTwo = new DashboardTableTwo(firstName[i],lastName[i],age[i]);
                mDao.insert(dashboardTableTwo);

                DashboardTableThree dashboardTableThree = new DashboardTableThree(firstName[i],lastName[i],age[i]);
                mDao.insert(dashboardTableThree);

                NotificationTableOne notificationTableOne = new NotificationTableOne(firstName[i],lastName[i],age[i]);
                mDao.insert(notificationTableOne);

                NotificationTableTwo notificationTableTwo = new NotificationTableTwo(firstName[i],lastName[i],age[i]);
                mDao.insert(notificationTableTwo);

                NotificationTableThree notificationTableThree = new NotificationTableThree(firstName[i],lastName[i],age[i]);
                mDao.insert(notificationTableThree);

            }

            return null;
        }
    }
}
