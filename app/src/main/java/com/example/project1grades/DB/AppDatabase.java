package com.example.project1grades.DB;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project1grades.userlog;

@Database(entities = {userlog.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //User
    public static final String DBNAME = "db-userlog";
    public static final String USERLOG_TABLE = "userlog";
    public abstract DAO getUserlogDAO();



}
