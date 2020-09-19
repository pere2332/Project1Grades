package com.example.project1grades;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class deleteCourse extends AppCompatActivity {

    EditText class_name;
    

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_course);
    }
}
