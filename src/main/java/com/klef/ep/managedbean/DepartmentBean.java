package com.klef.ep.managedbean;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Department;
import com.klef.ep.models.IRP;
import com.klef.ep.models.Student;
import com.klef.ep.services.DepartmentService;


@ManagedBean(name = "deptbean",eager = true)
public class DepartmentBean 
{
   @EJB(lookup = "java:global/EPProject/DepartmentServiceImpl!com.klef.ep.services.DepartmentService")
   
   DepartmentService service;
   
    private int id;
    private String name;
    private String password;
    private List<Department> deptlist;
  public List<Department> getDeptlist() {
		return service.viewall();
	}
	public void setDeptlist(List<Department> deptlist) {
		this.deptlist = deptlist;
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
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  
  public String adddepartment()
  {
    Department d = new Department();
    d.setId(id);
    d.setName(name);
    d.setPassword(password);
    
    service.addDepartment(d);
    
    return "dept_reg.jsf?faces-redirect=true";
  }
  public String verifylogin()
  {
	  FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	      
	    HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
	    HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();  
	    
	    Department d=service.validateLogin(name, password);
	    if(d!=null)
	    { 
	       
	      HttpSession session = request.getSession();
	      session.setAttribute("department", d);
	      
	      return "dept_home.jsp";
	    
	    }

	    	else
	    	{
	    	return "loginfaildept.jsf";
	    	}
  }
  public String delete(int id)
  {
	  service.delete(id);
		return "viewalldept.jsf";

  }
public void updateDept(int id) throws IOException
{
	  FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	      
	    HttpServletResponse response = (HttpServletResponse)externalContext.getResponse();
	    response.sendRedirect("update_dept.jsp?id="+id);
}
}