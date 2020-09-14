package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.project1grades.DB.Assignments;

import java.util.List;

public class AssignmentsPage extends AppCompatActivity {

    Button addassignment;
    Button deleteassignment;

    List<Assignments> showing;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignmentspage);



    }

}