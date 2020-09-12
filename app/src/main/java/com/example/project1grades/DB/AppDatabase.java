package com.example.project1grades.DB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Course.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


    public abstract DAO dao();
    private static AppDatabase instance;

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


}
