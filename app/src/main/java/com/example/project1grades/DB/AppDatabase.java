package com.example.project1grades.DB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Course.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;
    public abstract DAO dao();

    public static AppDatabase getAppDatabase(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "GradesDB")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }



    /*//User
    public static final String DBNAME = "db-userlog";
    public static final String USERLOG_TABLE = "userlog";
    public abstract DAO getUserlogDAO();
    */


}
