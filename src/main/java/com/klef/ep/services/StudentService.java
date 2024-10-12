package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.JobProfile;
import com.klef.ep.models.Marks;
import com.klef.ep.models.Student;

@Remote
public interface StudentService 
{
   public String addstudent(Student s);
   public Student checkstdlogin(String username,String password);
   public List<Student> viewall();
   public String update(Student s) ;
   public String deletestd(int id);
   public Student viewstudentbyid(int id);
   public List<Student> viewallbydept(String dname);
   public List<JobProfile> viewalljobs();
   public String addMarks(Marks m);
   
}