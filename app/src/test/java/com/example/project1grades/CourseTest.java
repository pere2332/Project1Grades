package com.example.project1grades;
import org.junit.Test;
import com.example.project1grades.DB.Course;
import com.example.project1grades.DB.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CourseTest {
    @Test
    public void create_course(){
        Course course = new Course();
        assertNotNull(course);
    }
// public Course(String userName, String title, String instructor, String description, String startDate, String endDate)
    @Test
    public void set_course(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");
        //assertTrue(user.getUsername()=="Victor" && user.getPassword()=="Cuin");
        //assert
    }

    @Test
    public void testGetCourseTitle(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");
        assertEquals("Algorithms",course.getTitle());
    }

    @Test
    public void testGetCourseInstructor(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");
        assertEquals("Dr. Byun",course.getInstructor());
    }

    @Test
    public void testGetCourseStartDate(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");
        assertEquals("03/09/21",course.getStartDate());
    }
    @Test
    public void testGetCourseEndDate(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");
        assertEquals("03/09/22",course.getEndDate());
    }
    @Test
    public void testGetCourseDescription(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");
        assertEquals("This class sucks",course.getDescription());
    }

    @Test
    public void testSetCourseTitle(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");

        course.setTitle("DataScience");
        assertEquals("DataScience",course.getTitle());
    }
    @Test
    public void testSetCourseDescription(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");

        course.setDescription("This class doesnt suck");
        assertEquals("This class doesnt suck",course.getDescription());
    }
    @Test
    public void testSetCourseInstructor(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");

        course.setInstructor("Not. Byun");
        assertEquals("Not. Byun",course.getInstructor());
    }
    @Test
    public void testSetCourseStartDate(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");

        course.setStartDate("09/12/20");
        assertEquals("09/12/20",course.getStartDate());
    }
    @Test
    public void testSetCourseEndDate(){
        Course course = new Course();
        course.setTitle("Algorithms");
        course.setInstructor("Dr. Byun");
        course.setDescription("This class sucks");
        course.setStartDate("03/09/21");
        course.setEndDate("03/09/22");

        course.setEndDate("09/12/21");
        assertEquals("09/12/21",course.getEndDate());
    }

}
