/**
 * This is our main activity, it gives the user 2 options at the beginning of our app.
 */

package com.example.project1grades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button login;
    Button create;

    /**
     * User is given 2 options during the main activity,
     * 1 to login, 2 to create an account.
     */

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

    /**
     * Sends user to the Login page.
     */
    private void Loginpage(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    /**
     * Sends user to the create account page.
     */
    private void createPage(){
        Intent in = new Intent(this, CreateAccout.class);
        startActivity(in);
    }
}
