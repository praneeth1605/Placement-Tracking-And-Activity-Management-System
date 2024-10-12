<%@page import="com.klef.ep.services.IRPServiceImpl"%>
<%@page import="com.klef.ep.models.*"%>
<%@page import="com.klef.ep.services.StudentServiceImpl"%>

<%@ page import="java.sql.*" %>

<%
int jid = (int)((Math.random()*999)+1);
String cname = request.getParameter("cname");
String jtitle = request.getParameter("jtitle");
String jobloc = request.getParameter("jobloc");
String jtype = request.getParameter("jtype");
String jdes = request.getParameter("jdes");
String jlink = request.getParameter("jlink");

JobProfile j = new JobProfile();

j.setJid(jid);
j.setCname(cname);
j.setJtitle(jtitle);
j.setJloc(jobloc);
j.setJtype(jtype);
j.setJdes(jdes);
j.setJlink(jlink);

IRPServiceImpl service = new IRPServiceImpl();

service.addjob(j);

%>