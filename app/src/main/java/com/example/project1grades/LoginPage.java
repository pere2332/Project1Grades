package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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

public class LoginPage extends AppCompatActivity {
    EditText user;
    EditText pwrd;
    DAO check;

    List<User> users;
    Button login;

    static User nUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        final DAO dao = AppDatabase.getAppDatabase(this).dao();

        login = (Button) findViewById(R.id.signin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                users = dao.getAllUsers();
                user = findViewById(R.id.Usr);
                pwrd = findViewById(R.id.Pwd);

                boolean pass = false;
                boolean userRight = false;
                boolean passRight = false;

                final String username = user.getText().toString();
                final String password = pwrd.getText().toString();

                for(int i = 0; i < users.size(); i++){
                    if(username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())){
                        pass = true;
                        //nUser = dao.getUserByUsername();
                        break;
                    }
                    if(username.equals(users.get(i).getUsername())){
                        //password not right
                        if(!password.equals(users.get(i).getPassword())){
                            passRight = true;
                            userRight = false;
                            break;

                        }
                    } else if(password.equals(users.get(i).getPassword())){
                        //username wrong
                        if(!username.equals(users.get(i).getUsername())){
                            userRight = true;
                            passRight = false;
                            break;
                        }
                    } else if(!password.equals(users.get(i).getPassword()) && !username.equals(users.get(i).getUsername())){
                        //both wrong
                        passRight = true;
                        userRight = true;
                    }
                }
                //Changed the for loop so i can get the user, idk if it breaks something

                for(User existingUser:users){

                    if(existingUser.getUsername().equals(username)&&existingUser.getPassword().equals(password)){

                        nUser = existingUser;
                        pass = true;

                    } else {
                        pass = false;
                    }
                }

                String u = username;
                String p = password;

                if(pass == true){
                    //nUser = users;
                    // shouldn't intent just be sent to the showCourseActivity since its pretty much our home?
                    // every time i try to send it there the app breaks, even if i comment out the code and put the same code as
                    // the home activity...
                    Intent intent = new Intent(LoginPage.this, showCourseActivity.class);
                    Toast.makeText(LoginPage.this, "Welcome! " + username + "!", Toast.LENGTH_LONG).show();
                    //Toast.makeText(LoginPage.this, "Welcome! " + nUser + "!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }else if(pass == false){
                    if(userRight && !passRight){
                        Toast.makeText(LoginPage.this, "username is incorrect", Toast.LENGTH_LONG).show();
                        user.setError("Invalid user name");
                    }else if(passRight && !userRight){
                        Toast.makeText(LoginPage.this, "password is incorrect", Toast.LENGTH_LONG).show();
                        pwrd.setError("Invlid password");
                    }else if(userRight && passRight){
                        Toast.makeText(LoginPage.this, "both username and password are incorrect", Toast.LENGTH_LONG).show();
                        user.setError("Invalid user name");
                        pwrd.setError("Invlid password");
                    }

                }
            }

        });
    }
}
