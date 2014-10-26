
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="jspStyle.css" type="text/css">
        <title>Academic Application</title>
    </head>

    <body>
        <h1>Hello ${program}   Student: ${studentID}               !</h1>
        <h2>You have selected the following courses for the            semester</h2>

        <table>
            <tr>
                <th>Course ID</th><th>Course Name</th><th>Course Description</th><th>Course Time</th>
            </tr>
            <c:forEach var="course"   items="${courses}">
                <tr>
                    <td>
                      ${course.courseID}
                    </td>
                    <td>
                      ${course.courseName}
                    </td>
                    <td>
                       ${course.courseDescription}
                    </td>
                    <td>
                      ${course.courseTime}
                    </td>
                </tr>
            </c:forEach>
        </table>


    </body>
</html>
