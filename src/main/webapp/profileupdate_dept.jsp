<%@page import="com.klef.ep.models.*"%>
<%@page import="com.klef.ep.services.*"%>
<%@page import="javax.naming.InitialContext"%>
<%

int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String password = request.getParameter("password");



InitialContext context = new InitialContext();

DepartmentService DepartmentService = (DepartmentService) context.lookup("java:global/EPProject/DepartmentServiceImplementation!com.klef.ep.services.DepartmentService");

Department s = DepartmentService.viewdeptbyid(id);

    //System.out.println("ID Found");
    Department dept = new Department();
    dept.setId(id);
    dept.setName(name);
    dept.setPassword(password);
    
    DepartmentService.update(dept);
   	response.sendRedirect("viewalldept.jsf");



%>