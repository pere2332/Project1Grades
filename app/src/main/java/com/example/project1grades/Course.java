package com.example.project1grades;


import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


import com.example.project1grades.DB.*;




public class Course extends AppCompatActivity {

    List<Course> courses;
    Button clear_button;
    Button addCourseButton;
    //User mUser = MainActivity.mUser;

    EditText nInstructorName;
    EditText nCourseTitle;
    EditText nCourseDescription;
    EditText nStartDate;
    EditText nEndDate;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_courses_page);

        Button return_main_button = findViewById(R.id.return_to_main);
        return_main_button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });


        addCourseButton = findViewById(R.id.add_course);

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCourse();

            }
        });

        //courses = TrackerRoom.getTrackerRoom(this).dao().getCoursesForUser(mUser.getUsername());

        ListView courses_view = findViewById(R.id.course_list);
        //Takes in a course arraylist to display
        //courses_view.setAdapter(new CourseListAdapter( this,courses) );
    }



    boolean addCourse(){

        String courseTitle = nCourseTitle.getText().toString();
        String instructorName = nInstructorName.getText().toString();
        String courseDescription = nCourseDescription.getText().toString();
        String startDate = nStartDate.getText().toString();
        String endDate = nEndDate.getText().toString();

        //GETS ACCESS TO THE DAO
        //DAO dao = DAO.getTrackerRoom(AddCourseActivity.this).dao();

        //CREATES A COURSE OBJECT OUT OF OUR INPUT AND INSERTS THROUGH DAO METHOD INSERT
        //NEEDS USER SO WE CAN ADD TO THE USER PROFILE
        //Course newCourse = new Course(nUser.getUsername(),instructorName,courseTitle,courseDescription,startDate,endDate);
        //dao.addNewCourse(newCourse);

        Toast.makeText(this, "Course was added.", Toast.LENGTH_SHORT).show();


        return true;
    }
}