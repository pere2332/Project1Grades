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
import java.util.List;

import com.example.project1grades.DB.AppDatabase;
import com.example.project1grades.DB.DAO;
import com.example.project1grades.DB.User;
import com.example.project1grades.DB.Course;

import static java.lang.Integer.parseInt;


public class showCourseActivity extends AppCompatActivity {

    static Course nCourse = null;
    List<Course> courses;
    Button addCourseButton;
    Button logoutButton;
    Button move;
    EditText title;
    EditText user;
    User mUser = LoginPage.nUser;
    ListView courses_view;
    DAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_courses_page);

        addCourseButton = findViewById(R.id.activity_add_course_button);
        logoutButton = findViewById(R.id.logout);
        move = findViewById(R.id.movingtoAssignmet);
        title = findViewById(R.id.course_title);
        user = findViewById(R.id.userinput);
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

                Intent intent = new Intent(showCourseActivity.this, AssignmentsPage.class);
                startActivity(intent);
            }
        });
    }

    public void change(){
        String check = user.getText().toString();
        int attempt = 0;
        courses = dao.getCoursesForUser(mUser.getUsername());
//      String titles = title.getText().toString();
        if(!check.isEmpty()){
            for(Course log : courses){
                if(true){
                    Toast.makeText(this, "Complete", Toast.LENGTH_LONG).show();
                    nCourse = log;
                    Intent intent = new Intent(showCourseActivity.this, AssignmentsPage.class);
                    startActivity(intent);
                    break;
                }else{
                    String convert = String.valueOf(attempt);
                    Toast.makeText(this, mUser.getUsername() + convert, Toast.LENGTH_LONG).show();
                }
                attempt++;
            }
        }else{
            Toast.makeText(this,"does not work", Toast.LENGTH_LONG).show();
        }
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
