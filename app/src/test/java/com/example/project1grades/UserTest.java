package com.example.project1grades;

import org.junit.Test;
import com.example.project1grades.DB.User;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserTest {
    @Test
    public void create_user(){
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void set_username_pass(){
        User user = new User();
        user.setUsername("Victor");
        user.setPassword("Cuin");
        assertTrue(user.getUsername()=="Victor" && user.getPassword()=="Cuin");
    }
}
