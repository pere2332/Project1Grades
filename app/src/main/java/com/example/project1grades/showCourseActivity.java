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
import androidx.appcompat.app.AppCompatActivity;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_courses_page);

        addCourseButton = findViewById(R.id.activity_add_course_button);
        logoutButton = findViewById(R.id.logout);
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

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(showCourseActivity.this, MainActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        /*move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });*/

        courses = AppDatabase.getAppDatabase(this).dao().getCoursesForUser(mUser.getUsername());

        courses_view = findViewById(R.id.course_list);



        //Takes in a course arraylist to display
        courses_view.setAdapter(new CourseListAdapter(this, courses));
        courses_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String CourseInfo = courses_view.getItemAtPosition(position).toString();
                String courseId = CourseInfo.substring(0, CourseInfo .indexOf(" "));
//                Intent i =new Intent(ShowProducerTable.this, TestDataBase.class);
//                i.putExtra("UserInfo", UserInfo);
//                startActivity(i);
//                /***just to check if it has value***/
//                // Toast.makeText(getBaseContext(),"position is : "+position+" and value is +UserInfo,Toast.LENGTH_SHORT).show();
//                Toast.makeText(getBaseContext(), id + "", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(showCourseActivity.this, AssignmentsPage.class);
                startActivity(intent);
            }

//                Intent intent = new Intent(showCourseActivity.this, AssignmentsPage.class);
//                startActivity(intent);
            //}
        });
    }

    public void change(){
        String check = user.getText().toString();
        if(!check.isEmpty()){
            for(Course log : courses){
                if(check == log.getTitle()){
                    mCourse = log;
                    Intent intent = new Intent(showCourseActivity.this, AssignmentsPage.class);
                    startActivity(intent);
                }
            }
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
