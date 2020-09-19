package com.example.project1grades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import com.example.project1grades.DB.AppDatabase;
import com.example.project1grades.DB.User;
import com.example.project1grades.DB.Course;

public class showCourseActivity extends AppCompatActivity {
    //new code
    static long nCourse;

    List<Course> courses;
    Button addCourseButton;
    Button logoutButton;
    //new code
    Button move;
    EditText user;

    User mUser = LoginPage.nUser;
    ListView courses_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_courses_page);

        addCourseButton = findViewById(R.id.activity_add_course_button);
        logoutButton = findViewById(R.id.logout);
        // new code
        move = findViewById(R.id.movingtoAssignmet);
        user = findViewById(R.id.userinput);

        //TAKES USER TO ADD COURSES ACTIVITY
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(showCourseActivity.this, addCoursesActivity.class);
                startActivity(intent);

            }
        });
        //new code
//        move.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                change();
//            }
//        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(showCourseActivity.this, MainActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        courses = AppDatabase.getAppDatabase(this).dao().getCoursesForUser(mUser.getUsername());

        courses_view = findViewById(R.id.course_list);



        // this pretty much shows the courses that were set up
        courses_view.setAdapter(new CourseListAdapter(this, courses));
        courses_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(showCourseActivity.this, AssignmentsPage.class);
                startActivity(intent);
            }
        });
    }

    // new code
//    public void change(){
//        String check = user.getText().toString();
//        if(!check.isEmpty()){
//            for(Course log : courses){
//                if(check == log.getTitle()){
//                    nCourse = log.getId();
//                    Intent intent = new Intent(showCourseActivity.this, AssignmentsPage.class);
//                    startActivity(intent);
//                }
//            }
//        }
//    }

    public class CourseListAdapter extends ArrayAdapter<Course> {

        public CourseListAdapter(Activity context, List<Course> courses){
            super(context, R.layout.rowlayout ,courses);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater= showCourseActivity.this.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.rowlayout, null,true);
            TextView rowField = rowView.findViewById(R.id.row_id);
            rowField.setText(courses.get(position).toString());

            return rowView;
        }

    }
}
