<%@page import="com.klef.ep.models.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.klef.ep.services.StudentService"%>
<%@page import="javax.naming.InitialContext"%>
<%@include file="dept_home.jsp" %>
<%

InitialContext context = new InitialContext();
StudentService studentService = (StudentService)context.lookup("java:global/EPProject/StudentServiceImpl!com.klef.ep.services.StudentService");
Department d = (Department)session.getAttribute("department");
List<Student> stdlist = studentService.viewallbydept(d.getName());

%>
<head>
<style>
    .table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #333;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
</style>
</head>
<body>
    <h3 align="center">View All Students</h3>
    <table class="table" align="center">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Contact No</th>
        </tr>
        <%
            for(Student std : stdlist) {
        %>
        <tr>
            <td><%=std.getId()%></td>
            <td><%=std.getName()%></td>
            <td><%=std.getUsername()%></td>
            <td><%=std.getContact()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
