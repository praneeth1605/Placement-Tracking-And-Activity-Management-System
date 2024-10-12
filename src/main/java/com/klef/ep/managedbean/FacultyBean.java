package com.klef.ep.managedbean;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Faculty;
import com.klef.ep.services.FacultyService;

@ManagedBean(name="fbean", eager = true)
public class FacultyBean {

    @EJB(lookup="java:global/EPProject/FacultyServiceImpl!com.klef.ep.services.FacultyService")
    FacultyService service;

    private int id;
    private String name;
    private String username;
    private String password;
    private List<Faculty> facultylist;
   

    public List<Faculty> getFacultylist() {
		return service.viewall();
	}

	public void setFacultylist(List<Faculty> facultylist) {
		this.facultylist = facultylist;
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

    public String addfaculty()
    {
      Faculty f = new Faculty();
      f.setId(id);
      f.setName(name);
      f.setUsername(username);
      f.setPassword(password);
      
      service.addfaculty(f);
      
      return "faculty_reg.jsf?faces-redirect=true";
      
    }
    public String verifylogin()
    {
    	FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
          
        HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();  
        
      Faculty f=service.validateLogin(username, password);
      if(f==null)
      {
        return "loginfail_faculty.jsf";
      }
      else
      {
    	  HttpSession session = request.getSession();
          session.setAttribute("faculty", f);
        return "faculty_home.jsp";
      }
    }
    public String delete(int id)
    {
  	  service.delete(id);
  		return "viewallfaculty.jsf";

    }
    public void updateF(int id) throws IOException
    {
  	  FacesContext facesContext = FacesContext.getCurrentInstance();
  	    ExternalContext externalContext = facesContext.getExternalContext();
  	      
  	    HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();
  	    response.sendRedirect("update_faculty.jsp?id="+id);
    }
  }