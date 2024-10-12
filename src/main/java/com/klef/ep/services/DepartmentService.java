package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Department;
import com.klef.ep.models.Quiz;
import com.klef.ep.models.QuizName;
import com.klef.ep.models.Student;

@Remote
public interface DepartmentService 
{
	public String addDepartment(Department d);
	public Department validateLogin(String name,String password);
	public List<Department> viewall();
	 public String update(Department d) ;
	public String delete(int id);
	public Department viewdeptbyid(int id);
	public String addQuiz(Quiz q);
	public boolean quizmarks(int id,int option);
	//public String addQuizName(QuizName qn);
	//public List<QuizName> viewallquizes();
	 public List<Quiz> displayquiz(String qname);
	//public List<Quiz> viewallquizes(String quizname);
	public List<Student> viewallbydept(String dname);
	public String addquizname(String quizname);
	public List<QuizName> displayquizNames();
}
