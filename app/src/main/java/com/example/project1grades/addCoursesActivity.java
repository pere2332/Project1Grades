package com.example.project1grades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.project1grades.DB.User;
import com.example.project1grades.DB.Course;
import com.example.project1grades.DB.DAO;
import com.example.project1grades.DB.AppDatabase;

import java.util.List;

public class addCoursesActivity extends AppCompatActivity {

    EditText mInstructorName;
    EditText mCourseTitle;
    EditText mCourseDescription;
    EditText mStartDate;
    EditText mEndDate;
    // im just trying different things
    User mUser = LoginPage.nUser; //GET THE USER THAT'S LOGGED IN

    Button addCourseButton;
    Button returnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        addCourseButton = findViewById(R.id.add_course);
        returnMainMenu = findViewById(R.id.return_button);

        mInstructorName = findViewById(R.id.instructor_name);
        mCourseTitle = findViewById(R.id.course_title);
        mCourseDescription = findViewById(R.id.course_description);
        mStartDate = findViewById(R.id.start_date);
        mEndDate = findViewById(R.id.end_date);

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCourse();

                Intent intent = new Intent(addCoursesActivity.this,showCourseActivity.class);
                startActivity(intent);

            }
        });

        returnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(addCoursesActivity.this,HomePage.class);
                startActivity(intent);
            }
        });
    }

    boolean addCourse(){

        String courseTitle = mCourseTitle.getText().toString();
        String instructorName = mInstructorName.getText().toString();
        String courseDescription = mCourseDescription.getText().toString();
        String startDate = mStartDate.getText().toString();
        String endDate = mEndDate.getText().toString();

        DAO dao = AppDatabase.getAppDatabase(addCoursesActivity.this).dao();

        Course newCourse = new Course(mUser.getUsername(),instructorName,courseTitle,courseDescription,startDate,endDate);
        dao.addNewCourse(newCourse);

        Toast.makeText(this, "Course was added.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(addCoursesActivity.this,showCourseActivity.class);
        startActivity(intent);

        return true;
    }
}
