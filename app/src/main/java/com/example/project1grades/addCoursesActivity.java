/**
 * This activity gets information from the user about the course
 * and adds the course the user creates to our database
 */

package com.example.project1grades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project1grades.DB.User;
import com.example.project1grades.DB.Course;
import com.example.project1grades.DB.DAO;
import com.example.project1grades.DB.AppDatabase;


public class addCoursesActivity extends AppCompatActivity {

    /**
     * Initializing variables for our course to be filled out.
     */
    EditText mInstructorName;
    EditText mCourseTitle;
    EditText mCourseDescription;
    EditText mStartDate;
    EditText mEndDate;
    static String name;
    // im just trying different things
    /**
     * this gets the user that is logged in and adds course to their account.
     */
    User mUser = LoginPage.nUser; //GET THE USER THAT'S LOGGED IN


    Button addCourseButton;
    Button returnMainMenu;

    /**
     * When add course is created it initializes variables for user to input information and
     * creates an add course button
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        addCourseButton = findViewById(R.id.add_course);

        mInstructorName = findViewById(R.id.instructor_name);
        mCourseTitle = findViewById(R.id.course_title);
        mCourseDescription = findViewById(R.id.course_description);
        mStartDate = findViewById(R.id.start_date);
        mEndDate = findViewById(R.id.end_date);

        /**
         * When add course button is clicked it runs addCourse function and goes to show course activity.
         */
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCourse();
                Intent intent = new Intent(addCoursesActivity.this,showCourseActivity.class);
                startActivity(intent);

            }
        });

    }

    /**
     * The add course function gets all variables for course, adds them to the database,
     * and displays a message to the user that the course was added.
     */
    boolean addCourse(){

        String courseTitle = mCourseTitle.getText().toString();
        String instructorName = mInstructorName.getText().toString();
        String courseDescription = mCourseDescription.getText().toString();
        String startDate = mStartDate.getText().toString();
        String endDate = mEndDate.getText().toString();

        DAO dao = AppDatabase.getAppDatabase(addCoursesActivity.this).dao();

        Course newCourse = new Course(mUser.getUsername(),instructorName,courseTitle,courseDescription,startDate,endDate);
        dao.addNewCourse(newCourse);
        name = courseTitle;

        long num = newCourse.getId();



        Toast.makeText(this, "" + num, Toast.LENGTH_SHORT).show();


        Toast.makeText(this, "Course was added.", Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent(addCoursesActivity.this,showCourseActivity.class);
//        startActivity(intent);

        return true;
    }
}
