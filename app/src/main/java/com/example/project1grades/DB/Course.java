package com.example.project1grades.DB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.project1grades.DB.Course;
import com.example.project1grades.DB.DAO;

//import edu.csumb.gradetracker.model.TrackerRoom;
//import edu.csumb.gradetracker.model.User;
@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String userName;

    private String title;
    private String instructor;
    private String description;
    private String startDate;
    private String endDate;

    public Course() {}

    @Ignore
    public Course(String userName, String title, String instructor, String description, String startDate, String endDate) {
        this.userName = userName;

        this.title = title;
        this.instructor = instructor;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return  "Course Title:  "+ title + "\n" + "Instructor: " + instructor + "\n" +
                "Description: "+ description + "\n" + "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n";
    }
}
