package com.example.project1grades.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Assignments {
    /**
     * Initializes the variables for assignments.
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    private long courseid;
    //private int categoryid;

    private double maxscore;
    private double earnedscore;

    String details;
    String date;
    //String type;


    //DateFormat assign_date = new SimpleDateFormat("MM/dd/yyyy");
    //DateFormat due_date = new SimpleDateFormat("MM/dd/yyyy");


    public Assignments(long courseid, double maxscore, double earnedscore, String details, String date) {
        this.courseid = courseid;
        this.maxscore = maxscore;
        this.earnedscore = earnedscore;
        this.details = details;
        this.date = date;
    }


    /**
     * Setters and getter for initialized variables.
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public long getCourseid() {
        return courseid;
    }

    public double getMaxscore() {
        return maxscore;
    }

    public double getEarnedscore() {
        return earnedscore;
    }

    public String getDetails() {
        return details;
    }

    public void setMaxscore(double maxscore) {
        this.maxscore = maxscore;
    }

    public void setEarnedscore(double earnedscore) {
        this.earnedscore = earnedscore;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    @Override
    public String toString() {
        return  "Details: " + details + '\n' +
                "Maxscore:" + maxscore + '\n' +
                "Earnedscore: " + earnedscore + '\n' +
                "Date: '" + date + '\'' +
                "================================\n";
    }
}