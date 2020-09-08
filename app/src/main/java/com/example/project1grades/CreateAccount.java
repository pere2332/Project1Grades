package com.example.project1grades;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1grades.DB.AppDatabase;
import com.example.project1grades.DB.DAO;
import com.example.project1grades.DB.User;

import java.util.List;

public class CreateAccount extends AppCompatActivity {
    EditText user_name;
    EditText user_pass;
    int counter = 0;
    int count_dupe = 0;

    DAO dao = AppDatabase.getAppDatabase(this).dao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        user_name = findViewById(R.id.create_user);
        user_pass = findViewById(R.id.create_password);
        Button create_button = findViewById(R.id.create_button);

        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname;
                String upass;
                uname = user_name.getText().toString();
                upass = user_pass.getText().toString();

                List<User> users = dao.getAllUsers();
                boolean forward = false;
                for(int i = 0; i < users.size(); i++){
                    if(uname.equals(users.get(i).getUsername()) || upass.equals(users.get(i).getPassword())){
                        forward = true;
                        break;
                    }
                }
                if(forward == true){
                    Toast.makeText(CreateAccount.this, "Error, username or password already exist! ", Toast.LENGTH_LONG).show();
                } else{
                    User newUser = new User(uname, upass);
                    dao.addUser(newUser);
                    Toast.makeText(CreateAccount.this, "New account has been created under " + uname + "!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
