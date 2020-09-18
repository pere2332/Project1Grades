package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1grades.DB.Assignments;

import java.util.List;

public class AssignmentsPage extends AppCompatActivity {




    Button addassignment;
    Button deleteassignment;


    List<Assignments> showing;
    TextView allassign;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignmentspage);

        addassignment = findViewById(R.id.add_assignmets);
        deleteassignment = findViewById(R.id.delete_assignment);
        allassign = findViewById(R.id.allassignments);


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
        return true;
    }

    void remove(){

    }




}