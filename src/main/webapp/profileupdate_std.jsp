<%@page import="com.klef.ep.models.*"%>
<%@page import="com.klef.ep.services.*"%>
<%@page import="javax.naming.InitialContext"%>
<%

int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String username= request.getParameter("username");
String password = request.getParameter("password");
String contact = request.getParameter("contact");


InitialContext context = new InitialContext();

StudentService studentService = (StudentService) context.lookup("java:global/EPProject/StudentServiceImpl!com.klef.ep.services.StudentService");

Student s = studentService.viewstudentbyid(id);

    //System.out.println("ID Found");
    Student std = new Student();
    std.setId(id);
    std.setName(name);
    std.setContact(contact);
    std.setPassword(password);
    std.setUsername(username);
    
    studentService.update(std);
   	response.sendRedirect("viewallstudent.jsf");



%>