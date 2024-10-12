package com.klef.ep.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.klef.ep.models.JobProfile;
import com.klef.ep.services.IRPService;
import com.klef.ep.services.IRPServiceImpl;
import com.klef.ep.services.StudentServiceImpl;


@WebServlet("/insertjobprofile")
@MultipartConfig
public class InsertJobProfile extends HttpServlet 
{
  protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    try
    {
      int jid = (int)((Math.random()*999)+1);
      String cname = request.getParameter("cname");
      String jtitle = request.getParameter("jtitle");
      String jobloc = request.getParameter("jobloc");
      String jtype = request.getParameter("jtype");
      String jdes = request.getParameter("jdes");
      String jlink = request.getParameter("jlink");
      Part file = request.getPart("jimage");
      
      System.out.println(file);
      
      //InitialContext context = new InitialContext();
      //IRPService service = (IRPService) context.lookup("java:global/EPProject/IRPServiceImplementation!com.klef.ep.services.IRPService");
      
      
          InputStream inputStream = file.getInputStream();
          Blob blob = new javax.sql.rowset.serial.SerialBlob(getBytesFromInputStream(inputStream));


          JobProfile j = new JobProfile();

          j.setJid(jid);
          j.setCname(cname);
          j.setJtitle(jtitle);
          j.setJloc(jobloc);
          j.setJtype(jtype);
          j.setJdes(jdes);
          j.setJlink(jlink);
          j.setImagedata(blob);

          IRPServiceImpl irpservice = new IRPServiceImpl();

          irpservice.addjob(j);
          
         response.sendRedirect("insertjob.jsp");
    }
    catch(Exception e)
    {
      out.print(e);
    }
  }

  
  
  
  
   // Method to convert InputStream to byte array
    private byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }

}