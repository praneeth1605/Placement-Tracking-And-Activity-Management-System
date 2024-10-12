<%@page import="com.klef.ep.services.*,com.klef.ep.models.*"%>
<%@page import="java.util.*"%>
<%@include file="studenthome.jsp"  %>
<%
String qname= request.getParameter("name");
DepartmentService service = new DepartmentServiceImpl();
List<Quiz> qlist = service.displayquiz(qname);
int marks=0,i=0;
for(Quiz q:qlist)
{
  i++;
  String param="crtanswer"+i;
  int option= Integer.parseInt(request.getParameter(param));
  if(service.quizmarks(q.getId(), option))
  {
    marks++;
  }
}
%>
<%
StudentService sservice = new StudentServiceImpl();
Student ss=(Student)session.getAttribute("student");
Marks m=new Marks();
m.setSid(ss.getId());
m.setStudentname(ss.getName());
m.setQuizname(qname);
m.setMarks(marks);
sservice.addMarks(m);
out.println("<center><b>Secured Marks are  "+marks+"</b>");
%>
<br><br>
<a href="viewallquizes.jsp">Take Another Quiz</a>
</center>