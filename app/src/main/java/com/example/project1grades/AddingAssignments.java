package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project1grades.DB.AppDatabase;
import com.example.project1grades.DB.Assignments;
import com.example.project1grades.DB.Course;
import com.example.project1grades.DB.DAO;

import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class AddingAssignments extends AppCompatActivity {


    String getid = showCourseActivity.num;
    EditText detail;
    EditText earn;
    EditText max;
    EditText dates;
    long mCourse = 00;


    Button doneadding;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_assignments);

        doneadding = findViewById(R.id.done);
        detail = findViewById(R.id.detials);
        earn = findViewById(R.id.earned);
        max = findViewById(R.id.max);
        dates = findViewById(R.id.date);


        doneadding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check1, check2, check3, check4;
                check1 = detail.getText().toString();
                check2 = earn.getText().toString();
                check3 = max.getText().toString();
                check4 = dates.getText().toString();
                if(!check1.isEmpty() || !check2.isEmpty() || !check3.isEmpty() || !check4.isEmpty()){
                    goingtoadd();
                    backtoview();
                }else{
                    failed();
                }

            }
        });

    }

    public void backtoview(){
        Intent intent = new Intent(AddingAssignments.this, AssignmentsPage.class);
        startActivity(intent);
    }

    public void failed(){
        Toast.makeText(this, "everything", Toast.LENGTH_LONG).show();
    }

    public void goingtoadd(){
        String descrip = detail.getText().toString();
        double points = parseDouble(earn.getText().toString());
        double total = parseDouble(max.getText().toString());
        String fecha = dates.getText().toString();


        DAO dao = AppDatabase.getAppDatabase(AddingAssignments.this).dao();
        StringBuilder temp = new StringBuilder();
        int count = 0;
        for(int i = 0; i < getid.length(); i++){
            if(getid.charAt(i) == '='){
                count++;
            }
            if(count > 0){
                temp.append(getid.charAt(i));
            }
        }
        String temp2 = temp.toString();
        long num = parseLong(temp2);
        Assignments newAssign = new Assignments(num, total, points, descrip, fecha);
        dao.insert(newAssign);

        Toast.makeText(this,"Assignment was added.", Toast.LENGTH_LONG).show();
    }


}