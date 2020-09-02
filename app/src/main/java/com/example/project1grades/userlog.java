package com.example.project1grades;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project1grades.DB.AppDatabase;

@Entity(tableName = AppDatabase.USERLOG_TABLE)
public class userlog {

    @PrimaryKey(autoGenerate = true)
    private int mUserID;

    private String username;
    private String password;
    private String Fname;
    private String Lname;


    public userlog(String username, String password, String fname, String lname) {
        this.username = username;
        this.password = password;
        Fname = fname;
        Lname = lname;
    }

    public int getmUserID() {
        return mUserID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }
}
