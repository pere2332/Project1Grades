package com.example.project1grades.DB;


import androidx.room.Database;

import com.example.project1grades.userlog;

@Database(entities = {userlog.class}, version = 1)
public abstract class AppDatabase {
    public static final String DBNAME = "db-userlog";

    public static final String USERLOG_TABLE = "userlog";

    public abstract UserLogDAO getUserlogDAO();

}
