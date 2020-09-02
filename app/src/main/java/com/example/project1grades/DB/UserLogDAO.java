package com.example.project1grades.DB;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project1grades.userlog;

import java.util.List;

@Dao
public interface UserLogDAO {

    @Insert
    void insert(userlog... userlogs);

    @Update
    void update(userlog... userlogs);

    @Query("SELECT * FROM " + AppDatabase.USERLOG_TABLE + " ORDER BY username DESC")
    List<userlog> getAllUserLogs();

}
