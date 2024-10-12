package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.JobProfile;
import com.klef.ep.models.Marks;
import com.klef.ep.models.Student;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class StudentServiceImpl implements StudentService
{

  @Override
  public String addstudent(Student s) 
  {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
      EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    
    return "Student Inserted Successfully";
  }

  @Override
  public Student checkstdlogin(String username, String password) 
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
      EntityManager em = emf.createEntityManager();
      
      Query qry = em.createQuery("select s from Student s where s.username=? and s.password=?");
      
      qry.setParameter(1,username);
      qry.setParameter(2,password);
      
      Student student = null;
      
      if(qry.getResultList().size()>0)
      {
           student =(Student)qry.getSingleResult();
      }
      
      em.close();
      emf.close();
      return student;
  }
  public List<Student> viewall() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		EntityManager em=emf.createEntityManager();

		Query qry=em.createQuery("select s from Student s");
		List<Student> studentList =qry.getResultList();
		
		em.close();
		emf.close();
		
		return studentList;
	}

@Override
public String deletestd(int id) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();
	
	em.getTransaction().begin();
	Student s = em.find(Student.class,id);
	em.remove(s);
	em.getTransaction().commit();
	
	em.close();
	emf.close();
	
	return "Student Deleted Successfully";

}

@Override
public Student viewstudentbyid(int id) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();

	Student s = em.find(Student.class,id);
	
	em.close();
	emf.close();
	return s;

}

@Override
public String update(Student s) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		Student std = em.find(Student.class, s.getId());
		
		std.setUsername(s.getUsername());
		std.setContact(s.getContact());
		std.setName(s.getName());
		std.setPassword(s.getPassword());
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
		return "Student Updated Successfully";
}

@Override
public List<Student> viewallbydept(String dname) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();

	Query qry=em.createQuery("select s from Student s where s.department=?");
	qry.setParameter(1, dname);
	List<Student> studentList =qry.getResultList();
	
	em.close();
	emf.close();
	
	return studentList;
}

@Override
public List<JobProfile> viewalljobs() 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();

	Query qry=em.createQuery("select j from JobProfile j");
	List<JobProfile> jList =qry.getResultList();
	
	em.close();
	emf.close();
	
	return jList;
}

@Override
public String addMarks(Marks m) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
      
      em.getTransaction().begin();
      em.persist(m);
      em.getTransaction().commit();
      
      em.close();
      emf.close();
  
  return "Marks Inserted Successfully";
}
  
}