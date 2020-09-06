package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project1grades.DB.AppDatabase;
import com.example.project1grades.DB.UserLogDAO;

import java.util.List;

public class LoginPage extends AppCompatActivity {

    UserLogDAO check;
    List<userlog> checku;

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login = (Button) findViewById(R.id.signin);

        check = (UserLogDAO) Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .build()
                .getUserlogDAO()
                .getAllUserLogs();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginnow();
            }
        });
    }

    public void loginnow(){
        checku = check.getAllUserLogs();
        if(!checku.isEmpty()){
            for(userlog log : checku){

            }
        }

    }
}
