<%@page import="com.klef.ep.models.Student"%>
<%

Student s = (Student)session.getAttribute("student");

if(s==null)
{
	response.sendRedirect("sessionexpiry.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
    <title>Placement Portal Home</title>
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
    </style>
</head>
<body>
    <center>
        <img src="logo.jpg" alt="TalentSpot Logo" />
        <h2>TalentSpot Placements</h2>
    </center>
    <div class="navbar">
        <div class="logo">Welcome, <%= s.getName() %></div>
        <div>
            <a href="viewalljobs.jsp">Job Profile</a>
            <a href="viewallquizes.jsp">Take Quiz</a>
            <a href="logout.jsp">Logout</a>
        </div>
    </div>
    <h2 align="center">Student Home</h2>
</body>
</html>
