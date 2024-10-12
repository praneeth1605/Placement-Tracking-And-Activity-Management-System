package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Department;
import com.klef.ep.models.IRP;
import com.klef.ep.models.Quiz;
import com.klef.ep.models.QuizName;
import com.klef.ep.models.Student;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DepartmentServiceImpl implements DepartmentService
{
  public String addDepartment(Department d) 
  {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
      EntityManager em=emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(d);
      em.getTransaction().commit();
      
      return "Department Added Successfully";
  }

  @Override
  public Department validateLogin(String name, String password) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
      EntityManager em=emf.createEntityManager();

      Query qry=em.createQuery("select d from Department d where d.name=? and d.password=?");
      qry.setParameter(1, name);
      qry.setParameter(2,password);
      
      Department d=null;
      
      if(qry.getResultList().size()>0)
      {
        d=(Department)qry.getSingleResult();
      }
      
      em.close();
      emf.close();
      
      return d;
  }

  @Override
  public List<Department> viewall() {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Query qry=em.createQuery("select d from Department d");
    List<Department> deptlist =qry.getResultList();
    
    em.close();
    emf.close();
    
    return deptlist;
  }

  @Override
  public String delete(int id) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    em.getTransaction().begin();
    Department d = em.find(Department.class,id);
    em.remove(d);
    em.getTransaction().commit();
    
    em.close();
    emf.close();
    
    return "Department Deleted Successfully";
  }

  @Override
  public Department viewdeptbyid(int id) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Department d = em.find(Department.class,id);
    
    em.close();
    emf.close();
    return d;
  }

  @Override
  public String update(Department d) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    em.getTransaction().begin();
    Department dept = em.find(Department.class, d.getId());
    
    dept.setName(d.getName());
    dept.setPassword(d.getPassword());
    em.getTransaction().commit();
    
    
    em.close();
    emf.close();
    
    return "Department Updated Successfully";
  }

  @Override
  public String addQuiz(Quiz q) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
      EntityManager em=emf.createEntityManager();
      
      addquizname(q.getQname());
      
      em.getTransaction().begin();
      em.persist(q);
      em.getTransaction().commit();
      
      return "Question Added Successfully";
  }

  @Override
  public List<Quiz> displayquiz(String qname) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Query qry=em.createQuery("select q from Quiz q where q.qname=?");
    qry.setParameter(1, qname);
    List<Quiz> qlist =qry.getResultList();
    
    em.close();
    emf.close();
    
    return qlist;
  }
  
  @Override
  public boolean quizmarks(int id,int option) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    Quiz q = em.find(Quiz.class,id);
    if(q.getCrtoption()==option)
    {
      return true;
    }
    else 
      return false;
  }

  @Override
  public List<Student> viewallbydept(String dname) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Query qry=em.createQuery("select s from Student s where s.department=?");
    qry.setParameter(1, dname);
    List<Student> slist =qry.getResultList();
    
    em.close();
    emf.close();
    
    return slist;
  }

  @Override
  public String addquizname(String quizname) {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
      EntityManager em=emf.createEntityManager();
      QuizName qn1 = em.find(QuizName.class,quizname);
      if(qn1==null) {
      QuizName qn=new QuizName();
      qn.setQuizname(quizname);
      
      em.getTransaction().begin();
      em.persist(qn);
      em.getTransaction().commit();
      
      return "Quiz Added Successfully";
      }
      return null;
  }

  @Override
  public List<QuizName> displayquizNames() {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Query qry=em.createQuery("select qn from QuizName qn ");
    List<QuizName> qnlist =qry.getResultList();
    
    em.close();
    emf.close();
    
    return qnlist;
  }

}