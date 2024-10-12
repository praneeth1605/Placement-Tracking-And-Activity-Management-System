package com.klef.ep.managedbean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.IRP;
import com.klef.ep.services.IRPService;

@ManagedBean(name = "irpbean",eager = true)
public class IRPBean 
{
  @EJB(lookup = "java:global/EPProject/IRPServiceImpl!com.klef.ep.services.IRPService")
  IRPService service;
  
  private String username;
  private String password;
  
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

  public void verifylogin() throws IOException
  {
	   FacesContext facesContext = FacesContext.getCurrentInstance();
	     ExternalContext externalContext = facesContext.getExternalContext();
	  
	     HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
	   HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	  
	   IRP irp = service.validatelogin(username, password);
	   
	   if(irp!=null)
	   {
	     HttpSession session = request.getSession();
	     session.setAttribute("irp",irp );
	    
	     response.sendRedirect("irp_home.jsp");
	   }
	   else
	   {
	    response.sendRedirect("loginfail.jsf");
	   }
	  }
}