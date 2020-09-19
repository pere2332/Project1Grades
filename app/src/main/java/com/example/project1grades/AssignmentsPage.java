package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1grades.DB.Assignments;
import com.example.project1grades.DB.Course;
import com.example.project1grades.DB.DAO;
import com.example.project1grades.DB.User;

import java.util.List;

public class AssignmentsPage extends AppCompatActivity {



    DAO getting;
    Button addassignment;
    Button deleteassignment;

    User mUser = LoginPage.nUser;
    Course mCourse = showCourseActivity.mCourse;
    //TODO: still need to set up passing the variable
    //Course num = showCourseActivity.mCourse;
    long num = 00;
    List<Assignments> showing;
    TextView allassign;
    EditText input;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignmentspage);

        addassignment = findViewById(R.id.add_assignmets);
        deleteassignment = findViewById(R.id.delete_assignment);
        allassign = findViewById(R.id.allassignments);
        input = findViewById(R.id.assigndetails);

        //Toast.makeText(AssignmentsPage.this, num.getId(), Toast.LENGTH_LONG).show();


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

        //display();

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

    public void display(){
        showing = getting.getAssignmentbyid(num);
        if(!showing.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for(Assignments log : showing){
                stringBuilder.append(log.toString());
            }
            allassign.setText(stringBuilder);
        }else{
            allassign.setText("No Assignments found");
        }

    }




}