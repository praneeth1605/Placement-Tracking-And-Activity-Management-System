
<%@page import="com.klef.ep.services.DepartmentServiceImpl"%>
<%@page import="com.klef.ep.services.DepartmentService"%>
<%@ page language="java" import="com.klef.ep.models.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="dept_home.jsp" %>
<%
String qname = request.getParameter("qname");
String question=request.getParameter("question");
String option1=request.getParameter("option1");
String option2=request.getParameter("option2");
String option3=request.getParameter("option3");
String option4=request.getParameter("option4");
int crtoption=Integer.parseInt(request.getParameter("crtanswer"));
Quiz q=new Quiz();
q.setQname(qname);
q.setQuestion(question);
q.setOption1(option1);
q.setOption2(option2);
q.setOption3(option3);
q.setOption4(option4);
q.setCrtoption(crtoption);
DepartmentService service=new DepartmentServiceImpl();
service.addQuiz(q);
service.addquizname(qname);
%>
<center>
Question Added Successfully
<br><br>
<a href="dept_quiz.jsp?qname=<%=qname%>">Add Next Question</a>
</center>