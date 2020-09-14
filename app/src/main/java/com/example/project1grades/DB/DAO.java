package com.example.project1grades.DB;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {


    //Users
    @Insert
    long addUser(User user);

    @Query("select * from User")
    List<User> getAllUsers();

    @Query("select * from User where username = :username")
    List<User> getUserByUsername(String username);

    @Query("select * from User where username = :username and password = :password")
    List<User> getUserByUsernamePassword(String username, String password);


    /*@Update
    void update(userlog... userlogs);
     */

    /*@Query("SELECT * FROM " + AppDatabase.USERLOG_TABLE + " ORDER BY username DESC")
    List<User> getAllUserLogs();
    */
    //Course functions

    //Course
    @Insert
    long addNewCourse(Course course);

    @Query("select * from Course where username = :name")
    List<Course> getCoursesForUser(String name);

    /*//Assignments
    @Insert
    void insert(Assignments... Asssignment);

    @Update
    void update(Assignments... Assignment);

    @Query("select * from Assignments where courseid = :courseid" )
    List<Assignments> getAssignments();*/




}
