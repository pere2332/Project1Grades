package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1grades.DB.Assignments;
import com.example.project1grades.DB.Course;
import com.example.project1grades.DB.DAO;

import java.util.List;

import static com.example.project1grades.R.layout.rowlayout;

public class AssignmentsPage extends AppCompatActivity {


    DAO getting;
    Button addassignment;
    Button deleteassignment;
    Course nCourse = showCourseActivity.mCourse;
    //TODO: still need to set up passing the variable
    //Course num = showCourseActivity.mCourse;
    long num = 00;
    List<Assignments> showing;
    ListView allassign;
    EditText input;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignmentspage);

        addassignment = findViewById(R.id.add_assignmets);
        deleteassignment = findViewById(R.id.delete_assignment);
        //allassign = findViewById(R.id.allassignments);
        input = findViewById(R.id.assigndetails);


        //Toast.makeText(AssignmentsPage.this, num.getId(), Toast.LENGTH_LONG).show();

        allassign.setAdapter(new AssignmentsPage.CourseListAdapter(this, showing));

        addassignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetoAdd();
            }
        });

        deleteassignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteassign();
            }
        });


    }

    void movetoAdd(){
        Intent intent = new Intent(AssignmentsPage.this, AddingAssignments.class);
        startActivity(intent);
    }

    void deleteassign(){
        if(exist()){
            remove();
        }else{
            Toast.makeText(this, "Does not exist or typo", Toast.LENGTH_LONG).show();
        }
    }

    boolean exist(){
        String usrinput = input.getText().toString();
        showing = getting.getAssignmentbyid(num);
        for(Assignments log : showing){
            if(log.getDetails() == usrinput){
                return true;
            }
        }
        return false;
    }

    public void remove(){
        String userinput = input.getText().toString();
        showing = getting.getAssignmentbyid(num);
        if(!showing.isEmpty()){
            for(Assignments log : showing){
                if(userinput == log.getDetails()){
                    getting.delete();
                }
            }
        }
    }

    public class CourseListAdapter extends ArrayAdapter<Course> {

        public CourseListAdapter(Activity context, List<Assignments> showings){
            super(context, rowlayout2 ,showings);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater= AssignmentsPage.this.getLayoutInflater();
            View rowView=inflater.inflate(rowlayout, null,true);
            TextView rowField = rowView.findViewById(R.id.row_id2);
            //set the value of a row in the ListView to the flight info using toString()
            rowField.setText(showing.get(position).toString());



            return rowView;
        }

    }




}