<%@page import="com.klef.ep.services.*"%>
<%@page import="com.klef.ep.models.Student"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="com.klef.ep.models.*" %>
<%@include file="irp_home.jsp" %>
<%
int id = Integer.parseInt(request.getParameter("id"));
FacultyService service = new FacultyServiceImpl();
Faculty f = service.viewfacultybyid(id);
%>
<!DOCTYPE html>
<html>
<head>
    <style>
        .container {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-top: 50px;
        }
        .container img {
            width: 150px;
            margin-bottom: 20px;
        }
        .container h2 {
            color: #333;
        }
        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 1em;
        }
        .form-group input[type="submit"] {
            width: 100%;
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px;
            cursor: pointer;
            font-size: 1.1em;
            border-radius: 4px;
        }
        .form-group input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .form-group input[type="reset"] {
            width: 100%;
            background-color: red;
            color: #fff;
            border: none;
            padding: 10px;
            cursor: pointer;
            font-size: 1.1em;
            border-radius: 4px;
        }
        .form-group input[type="reset"]:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3 align="center"><u>Update Faculty Profile</u></h3>
        <form method="post" action="profileupdate_fac.jsp">
            <div class="form-group">
                <label for="id"><b>ID</b></label>
                <input type="number" id="id" name="id" value="<%=f.getId()%>" readonly required>
            </div>
            <div class="form-group">
                <label for="name"><b>Enter Name</b></label>
                <input type="text" id="name" name="name" value="<%=f.getName()%>" required>
            </div>
            <div class="form-group">
                <label for="username"><b>Enter UserName</b></label>
                <input type="text" id="username" name="username" value="<%=f.getUsername()%>" required>
            </div>
            <div class="form-group">
                <label for="password"><b>Enter Password</b></label>
                <input type="password" id="password" name="password" value="<%=f.getPassword()%>" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Update">
            </div>
        </form>
    </div>
</body>
</html>
