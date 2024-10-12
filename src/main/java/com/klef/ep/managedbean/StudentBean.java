package com.klef.ep.managedbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import com.klef.ep.models.JobProfile;
import com.klef.ep.models.Student;
import com.klef.ep.services.StudentService;

@ManagedBean(name = "sbean",eager = true)
public class StudentBean 
{
   @EJB(lookup = "java:global/EPProject/StudentServiceImpl!com.klef.ep.services.StudentService")
   
   StudentService service;
   
    private int id;
    private String name;
    private String username;
    private String password;
    private String department;
    private String contact;
    private List<Student> studentlist;
    private List<JobProfile> jlist;
    
    
  public List<JobProfile> getJlist() {
		return service.viewalljobs();
	}
	public void setJlist(List<JobProfile> jlist) {
		this.jlist = jlist;
	}
public List<Student> getStudentlist() {
		return service.viewall();
	}
	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = service.viewall();
	}
public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getDepartment() {
    return department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }
  public String getContact() {
    return contact;
  }
  public void setContact(String contact) {
    this.contact = contact;
  }
  
  public String addstudent()
  {
    Student s = new Student();
    s.setId(id);
    s.setName(name);
    s.setUsername(username);
    s.setPassword(password);
    s.setDepartment(department);
    s.setContact(contact);
    
   service.addstudent(s);
    
    return "student_reg.jsf?faces-redirect=true";
  }
  
  public void validatelogin() throws IOException
  {
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
      
    HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();  
    
    
    Student s  = service.checkstdlogin(username, password);
    if(s!=null)
    { 
       
      HttpSession session = request.getSession();
      session.setAttribute("student", s);
      
      response.sendRedirect( "studenthome.jsp");
    
    }
    else
    {
        response.sendRedirect("studentloginfail.jsf");
    }
  }
  
  public String delete(int id)
  {
	  service.deletestd(id);
		return "viewallstudent.jsf";

  }
  public void updateStud(int id) throws IOException
  {
	  FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	      
	    HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();
	    response.sendRedirect("update_student.jsp?id="+id);
  }
}