<%@page import="com.klef.ep.models.QuizName"%>
<%@page import="com.klef.ep.services.DepartmentServiceImpl"%>
<%@page import="com.klef.ep.models.JobProfile"%>
<%@page import="com.klef.ep.services.StudentServiceImpl"%>

<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@ include file="studenthome.jsp" %>


<%
    
    DepartmentServiceImpl service = new DepartmentServiceImpl();
    List<QuizName> qnlist = service.displayquizNames();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Jobs</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif; /* Using a more visible font */
        }
        .card {
            margin-bottom: 20px;
        }
        .card-title {
            font-size: 1.25em;
            font-weight: bold;
        }
        .card-text {
            font-size: 1em;
        }
        .btn-apply {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn-apply:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h3 class="text-center my-4">View All Quizes</h3>
    <div class="row">
        <%
            for(QuizName qn : qnlist) {
        %>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= qn.getQuizname() %></h5>
                    <a href="student_quiz.jsp?quizname=<%= qn.getQuizname() %>" class="btn btn-apply">Take Quiz</a>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
