/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academicapp.db;

import com.academicapp.beans.Course;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Madhur
 */
public class CourseDB {
    private Map<Integer, Course> courses;

    public CourseDB() {

        courses = new HashMap<Integer, Course>();
        int courseID = 5166;
        String courseName = "Network Based Application Development";
        String courseDescription = "This course is designed to familiarize "
                + "participants with technologies and protocols that support "
                + "computer communication networks, including the Internet.";
        String courseTime = "Monday 6:30-9:15";

        Course course1 = new Course();
        course1.setCourseID(courseID);
        course1.setCourseName(courseName);
        course1.setCourseTime(courseTime);
        course1.setCourseDescription(courseDescription);

        courses.put(courseID, course1);

        courseID = 6410;
        courseName = "Personalization and Recommender Systems";
        courseDescription = "This course is designed to familiarize "
                + "participants with technologies and protocols that support "
                + "leveraging databases of content and user preferences to deliver "
                + "personalized recommendations to users.";
        courseTime = "Tuesday 6:30-9:15";

        Course course2 = new Course();
        course2.setCourseID(courseID);
        course2.setCourseName(courseName);
        course2.setCourseTime(courseTime);
        course2.setCourseDescription(courseDescription);

        courses.put(courseID, course2);

    }
    // To retrieve all courses
    public Map<Integer,Course> getCourses(){
    return courses;
    }
    
    // To retrieve a course using the course ID
    public Course getCourse(int courseID){
        return((Course)courses.get(courseID));
    }
}
