/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academicapp.beans;

/**
 *
 * @author Madhur
 */
public class Course {
    private int courseID;
    private String courseName;
    private String courseDescription;
    private String courseTime;
    
    public Course(){
    }
    
    public int getCourseID(){
        return courseID;
    }
    
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getCourseDescription(){
        return courseDescription;
    }
    
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
    public String getCourseTime(){
        return courseTime;
    }
    
    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
    
}
