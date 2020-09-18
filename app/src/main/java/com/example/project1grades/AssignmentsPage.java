package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        addassignment = findViewById(R.id.add_assignmets);
        deleteassignment = findViewById(R.id.delete_assignment);

        addassignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetoAdd();
            }
        });

    }
        void movetoAdd(){
            Intent intent = new Intent(AssignmentsPage.this, AddingAssignments.class);
            startActivity(intent);
    }

}