package com.example.project1grades.DB;

import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignments {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int courseid;
    private int categoryid;

    private double maxscore;
    private double earnedscore;

    String details;


    DateFormat assign_date = new SimpleDateFormat("MM/dd/yyyy");
    DateFormat due_date = new SimpleDateFormat("MM/dd/yyyy");

    public Assignments(int courseid, int categoryid, double maxscore, double earnedscore, String details, DateFormat assign_date, DateFormat due_date) {
        this.courseid = courseid;
        this.categoryid = categoryid;
        this.maxscore = maxscore;
        this.earnedscore = earnedscore;
        this.details = details;
        this.assign_date = assign_date;
        this.due_date = due_date;
    }

    public int getId() {
        return id;
    }

    public int getCourseid() {
        return courseid;
    }

    public int getCategoryid() {
        return categoryid;
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

    public DateFormat getAssign_date() {
        return assign_date;
    }

    public DateFormat getDue_date() {
        return due_date;
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

    public void setAssign_date(DateFormat assign_date) {
        this.assign_date = assign_date;
    }

    public void setDue_date(DateFormat due_date) {
        this.due_date = due_date;
    }
}
