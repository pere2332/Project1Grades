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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import com.example.project1grades.DB.AppDatabase;
import com.example.project1grades.DB.User;
import com.example.project1grades.DB.Course;

public class showCourseActivity extends AppCompatActivity {

    static long nCourse;
    List<Course> courses;
    Button addCourseButton;
    Button logoutButton;
    Button move;
    EditText user;
    User mUser = LoginPage.nUser;
    ListView courses_view;
    static Course mCourse = null;
    String ct = addCoursesActivity.name;
    String n;
    Button deleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_courses_page);

        addCourseButton = findViewById(R.id.activity_add_course_button);
        logoutButton = findViewById(R.id.logout);

        //TAKES USER TO ADD COURSES ACTIVITY
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(showCourseActivity.this, addCoursesActivity.class);
                startActivity(intent);

            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(showCourseActivity.this, MainActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });

        courses = AppDatabase.getAppDatabase(this).dao().getCoursesForUser(mUser.getUsername());

        courses_view = findViewById(R.id.course_list);



        //Takes in a course arraylist to display
        courses_view.setAdapter(new CourseListAdapter(this, courses));
        courses_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //change();
                TextView textView = view.findViewById(R.id.course_title);
                String name = parent.getItemAtPosition(position).toString();
                //Course courses = courses_view.getItemAtPosition(position);
                /*Intent intent = new Intent(showCourseActivity.this, AssignmentsPage.class);
                startActivity(intent);*/
                Toast.makeText(showCourseActivity.this, name, Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void change(){
        View v;
        ArrayList<String> names = new ArrayList<String>();
        EditText et;

        for(int i = 0; i < courses_view.getCount(); i++){
            v = courses_view.getAdapter().getView(i, null, null);
            et = (EditText) v.findViewById(i);
            names.add(et.getText().toString());
            n = et.getText().toString();
        }


        Toast.makeText(showCourseActivity.this, n, Toast.LENGTH_SHORT).show();

    }

    public class CourseListAdapter extends ArrayAdapter<Course> {

        public CourseListAdapter(Activity context, List<Course> courses){
            super(context, R.layout.rowlayout ,courses);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater= showCourseActivity.this.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.rowlayout, null,true);
            TextView rowField = rowView.findViewById(R.id.row_id);
            //set the value of a row in the ListView to the flight info using toString()
            rowField.setText(courses.get(position).toString());



            return rowView;
        }

    }
}
