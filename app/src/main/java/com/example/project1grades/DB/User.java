package com.example.project1grades.DB;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private long id;
    /**
     * Initializes the variables for assignments.
     */

    private String username;
    private String password;

    private String firstName;
    private String lastName;

    public User(){}

    @Ignore
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Setters and getters for initialized variables.
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFirstName(){ return firstName; }

    public void setFirstName(String firstName){ this.firstName = firstName; }

    public String getLastName(){ return firstName; }

    public void setLastName(String lastName){ this.lastName = lastName; }



}
