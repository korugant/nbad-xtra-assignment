/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academicapp.controller;

import com.academicapp.beans.Course;
import com.academicapp.db.CourseDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Madhur
 */
public class AcademicController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CourseDB courseDB = new CourseDB();
        ArrayList<Course> courseList = new ArrayList<>();
        
        //---------------
        // Get submitted request parameters
        //---------------
        String studentID = request.getParameter("studentID");
        String program = request.getParameter("program");
        String semester = request.getParameter("semester");
        String [] courses = request.getParameterValues("course");



        //---------------
        // Create an Object to store the JSP view address
        // Set default address to the home page (index.html)
        //---------------
        String viewURL = "/index.html";

        //---------------
        // Validate program parameter has value. For value of "bachelors" 
        // set address to the bachelors JSP view. 
        // For value of "masters" set address to the masters JSP view
        //---------------
       if(program!=null && program.equalsIgnoreCase("bachelors"))
       {
           viewURL = "/bachelors.jsp";
       }
       else if(program!=null && program.equalsIgnoreCase("masters"))
       {
           viewURL = "/masters.jsp";
       }



        //---------------
        // Get the session Object 
        //---------------
        HttpSession session = request.getSession();
        
        //---------------
        // Validate studentID has value
        // For non-empty value, store in the session as "studentID"
        //---------------
        if(studentID!=null && !studentID.equalsIgnoreCase(""))
        {
            session.setAttribute("studentID", studentID);
        }

        
        //---------------
        // Validate program has value.
        // For non-empty value, store in the session as "program"
        //---------------
       if(program!=null && !program.equalsIgnoreCase(""))
        {
            session.setAttribute("program", program);
        }


        // Validate semester parameter has value. 
        // For non-empty value, add to the REQUEST as "semester" 
     
        if(semester!=null && !semester.equalsIgnoreCase(""))
        {
            request.setAttribute("semester", semester);
        }

        // Validate courses parameter has value.
        // For non-empty value
        // - create a list to store the courses specified in the courses parameter
        // - for each course requested, get the course bean and add it to the list
        // - store the courses in the REQUEST object
      
        if (courses!=null && courses.length>0)
        {
            for (String cid : courses)
            {
                Course c = courseDB.getCourse(Integer.parseInt(cid));
                courseList.add(c);
            }
            request.setAttribute("courses",courseList);
        }

        //dispatch to the proper view
        request.getServletContext().getRequestDispatcher(viewURL).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}