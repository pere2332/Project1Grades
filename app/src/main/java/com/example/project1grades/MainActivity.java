package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button login;
    Button create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.LOGIN);
        create = (Button) findViewById(R.id.CREATE);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPage();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loginpage();
            }
        });
    }

    private void Loginpage(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    private void createPage(){
        Intent in = new Intent(this, CreateAccout.class);
        startActivity(in);
    }
}
