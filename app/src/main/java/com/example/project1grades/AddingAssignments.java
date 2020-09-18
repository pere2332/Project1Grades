package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddingAssignments extends AppCompatActivity {


    EditText detial;
    EditText earn;
    EditText max;
    EditText dates;


    Button doneadding;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_assignments);

        doneadding = findViewById(R.id.done);
        detial = findViewById(R.id.detials);
        earn = findViewById(R.id.earned);
        max = findViewById(R.id.max);
        dates = findViewById(R.id.date);


        doneadding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check1, check2, check3, check4;
                check1 = detial.getText().toString();
                check2 = earn.getText().toString();
                check3 = max.getText().toString();
                check4 = dates.getText().toString();
                if(!check1.isEmpty() || !check2.isEmpty() || !check3.isEmpty() || !check4.isEmpty()){
                    //goingtoadd
                    backtoview();
                }else{
                    failed();
                }

            }
        });

    }

    void backtoview(){
        Intent intent = new Intent(AddingAssignments.this, AssignmentsPage.class);
        startActivity(intent);
    }

    void failed(){
        Toast.makeText(this, "everything", Toast.LENGTH_LONG).show();
    }


}