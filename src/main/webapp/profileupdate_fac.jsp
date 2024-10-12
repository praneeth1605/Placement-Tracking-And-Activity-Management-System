<%@page import="com.klef.ep.models.*"%>
<%@page import="com.klef.ep.services.*"%>
<%@page import="javax.naming.InitialContext"%>
<%

int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String username= request.getParameter("username");
String password = request.getParameter("password");


InitialContext context = new InitialContext();

FacultyService FacultyService = (FacultyService) context.lookup("java:global/EPProject/FacultyServiceImpl!com.klef.ep.services.FacultyService");

Faculty f = FacultyService.viewfacultybyid(id);

    //System.out.println("ID Found");
    Faculty fac = new Faculty();
    fac.setId(id);
    fac.setName(name);
    fac.setPassword(password);
    fac.setUsername(username);
    
    FacultyService.update(fac);
   	response.sendRedirect("viewallfaculty.jsf");



%>