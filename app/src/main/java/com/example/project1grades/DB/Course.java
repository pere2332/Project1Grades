package com.example.project1grades.DB;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)

    private long id;

    /**
     * Initializing variables for our course class.
     */
    private String userName;
    private String title;
    private String instructor;
    private String description;
    private String startDate;
    private String endDate;

    public Course() {}

    /**
     * Initializing course creation.
     */
    @Ignore
    public Course(String userName, String title, String instructor, String description, String startDate, String endDate) {
        this.userName = userName;
        this.title = title;
        this.instructor = instructor;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Initializing getters and setter for each variable.
     */
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
        return  "Course Title:  "+ title + "\n" + "id=" + id + "Instructor: " + instructor + "\n" +
                "Description: "+ description + "\n" + "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n";
    }

    /*@Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", userName='" + userName + '\n' +
                ", title='" + title + '\n' +
                ", instructor='" + instructor + '\n' +
                ", description='" + description + '\n' +
                ", startDate='" + startDate + '\n' +
                ", endDate='" + endDate + '\n' +
                '}';
    }*/
}
