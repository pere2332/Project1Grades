/**
 * This activity creates an account for our user and stores it into the database.
 */
package com.example.project1grades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project1grades.DB.AppDatabase;
import com.example.project1grades.DB.DAO;
import com.example.project1grades.DB.User;

import java.util.List;

public class CreateAccout extends Activity {

    /**
     * Initializing variables for our user to be filled out.
     */
    EditText user_name;
    EditText user_pass;
    int counter = 0;
    int count_dupe = 0;

    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        //AppDatabase.getAppDatabase*(this).loadData(this);
        final DAO dao = AppDatabase.getAppDatabase(this).dao();

        /**
         * When create account is created it initializes variables for user to input information and
         * creates a create_button that will add the new account into the database.
         */
        user_name = findViewById(R.id.create_user);
        user_pass = findViewById(R.id.create_password);
        Button create_button = findViewById(R.id.create_button);



        /**
         * When the create_button is click on by the user, it creates the username and password
         * that was entered.
         * First it checks if the username is in the database or not and it if it isn't then it
         * will add the user to the database, if account exist then it will display a message to
         * the user that the username or password already exist.
         */
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname;
                String upass;
                uname = user_name.getText().toString();
                upass = user_pass.getText().toString();

                List<User> users = dao.getAllUsers();
                boolean forward = false;

                /**
                 * Checking to see if the user already exist in our database.
                 */
                for(int i = 0; i < users.size(); i++){
                    if(uname.equals(users.get(i).getUsername()) || upass.equals(users.get(i).getPassword())){
                        forward = true;
                        break;
                    }
                }
                if(forward == true){
                    Toast.makeText(CreateAccout.this, "Error, username or password already exist! ", Toast.LENGTH_LONG).show();
                } else{
                    User newUser = new User(uname, upass);
                    dao.addUser(newUser);
                    Toast.makeText( CreateAccout.this, "New account has been created under " + uname + "!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CreateAccout.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
