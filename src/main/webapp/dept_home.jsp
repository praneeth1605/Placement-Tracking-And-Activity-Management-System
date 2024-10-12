<%@page import="com.klef.ep.models.*" %>
<%
Department dept=(Department)session.getAttribute("department");
if(dept==null)
{
    response.sendRedirect("sessionexpired.html");
}
%>

<!DOCTYPE html>
<html>
<head>
<style>
         body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            padding: 1em;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            padding: 0.5em 1em;
        }
        .navbar a:hover {
            background-color: #575757;
            border-radius: 4px;
        }
        .navbar .logo {
            font-size: 1.5em;
            font-weight: bold;
            color: white;
        }
        .navbar form {
            display: inline;
        }
        .navbar h:commandLink {
            color: white;
            text-decoration: none;
            padding: 0.5em 1em;
        }
        .navbar h:commandLink:hover {
            background-color: #575757;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<center>
    <img src="logo.jpg" alt="Logo">
    <h2>TalentSpot Placements</h2>
</center>
<div class="navbar">
    <div class="logo">Placement Portal</div>
    <a href="quizname_add.jsp">Create Quiz</a>
    <a href="viewstudent_dept.jsp">View Students</a>
    <a href="logout.jsp">Logout</a>
</div>
<h2 align="center">Department Home</h2>
</body>
</html>
