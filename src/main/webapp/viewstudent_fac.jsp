<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="faculty_home.jsp" %>
<%@ page import="com.klef.ep.models.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.klef.ep.services.FacultyService" %>
<%@ page import="javax.naming.InitialContext" %>
<%
    InitialContext context = new InitialContext();
    FacultyService FacultyService = (FacultyService) context.lookup("java:global/EPProject/FacultyServiceImpl!com.klef.ep.services.FacultyService");
    Department d = (Department) session.getAttribute("department");
    List<Marks> mlist = FacultyService.viewallmarks();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #343a40;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f8f9fa;
        }
        tr:hover {
            background-color: #e9ecef;
        }
    </style>
    <title>View Marks of Students</title>
</head>
<body>
    <div class="container">
        <h3 class="text-center my-4">View Marks Of Students</h3>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Student Name</th>
                    <th>Quiz Name</th>
                    <th>Marks</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Marks m : mlist) {
                %>
                <tr>
                    <td><%= m.getId() %></td>
                    <td><%= m.getStudentname() %></td>
                    <td><%= m.getQuizname() %></td>
                    <td><%= m.getMarks() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
