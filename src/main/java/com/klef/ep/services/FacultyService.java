package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Faculty;
import com.klef.ep.models.Marks;
import com.klef.ep.models.Student;
@Remote
public interface FacultyService {
    public String addfaculty(Faculty f);
    public Faculty validateLogin(String username, String password);
    public List<Faculty> viewall();
    public String update(Faculty f); 
    public String delete(int id);
    public Faculty viewfacultybyid(int id);
    public List<Marks> viewallmarks();
    
}