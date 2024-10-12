<%@page import="com.klef.ep.services.*,com.klef.ep.models.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="studenthome.jsp" %>
<%
String quizname = request.getParameter("quizname");
DepartmentServiceImpl service = new DepartmentServiceImpl();
List<Quiz> qlist = service.displayquiz(quizname);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .quiz-container {
            max-width: 700px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h3 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
            font-weight: bold;
        }
        label {
            font-weight: bold;
            color: #343a40;
        }
        .form-check-label {
            margin-left: 5px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: block;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="quiz-container">
        <h3>Quiz</h3>
        <form action="quiz_marks.jsp?name=<%= quizname%>" method="post">
            <%
            int i = 0;
            for (Quiz q : qlist) {
                i++;
            %>
                <div class="form-group">
                    <label><%= q.getQuestion() %>?</label><br>
                    <div class="form-check">
                        <input type="radio" id="crtanswer<%= i %>1" value="1" name="crtanswer<%= i %>" class="form-check-input" required>
                        <label class="form-check-label" for="crtanswer<%= i %>1">1) <%= q.getOption1() %></label>
                    </div>
                    <div class="form-check">
                        <input type="radio" id="crtanswer<%= i %>2" value="2" name="crtanswer<%= i %>" class="form-check-input" required>
                        <label class="form-check-label" for="crtanswer<%= i %>2">2) <%= q.getOption2() %></label>
                    </div>
                    <div class="form-check">
                        <input type="radio" id="crtanswer<%= i %>3" value="3" name="crtanswer<%= i %>" class="form-check-input" required>
                        <label class="form-check-label" for="crtanswer<%= i %>3">3) <%= q.getOption3() %></label>
                    </div>
                    <div class="form-check">
                        <input type="radio" id="crtanswer<%= i %>4" value="4" name="crtanswer<%= i %>" class="form-check-input" required>
                        <label class="form-check-label" for="crtanswer<%= i %>4">4) <%= q.getOption4() %></label>
                    </div>
                </div>
                <br>
            <%
            }
            %>
            <input type="submit" value="Submit" class="btn btn-primary">
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
