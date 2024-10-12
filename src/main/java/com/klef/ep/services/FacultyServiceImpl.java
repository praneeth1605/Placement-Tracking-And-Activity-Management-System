package com.klef.ep.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.klef.ep.models.Faculty;
import com.klef.ep.models.Marks;
import com.klef.ep.models.Student;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FacultyServiceImpl implements FacultyService 
{

    @Override
    public String addfaculty(Faculty f) 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
          
        return "Faculty added Successfully";
    }
    public Faculty validateLogin(String username, String password) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
          EntityManager em=emf.createEntityManager();

          Query qry=em.createQuery("select f from Faculty f where f.username=? and f.password=?");
          qry.setParameter(1, username);
          qry.setParameter(2,password);
          
          Faculty f=null;
          
          if(qry.getResultList().size()>0)
          {
            f=(Faculty)qry.getSingleResult();
          }
          
          em.close();
          emf.close();
          
          return f;
    }
  @Override
  public List<Faculty> viewall() {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Query qry=em.createQuery("select f from Faculty f");
    List<Faculty> FacultyList =qry.getResultList();
    
    em.close();
    emf.close();
    
    return FacultyList;
  }
  @Override
  public String delete(int id) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    em.getTransaction().begin();
    Faculty f = em.find(Faculty.class,id);
    em.remove(f);
    em.getTransaction().commit();
    
    em.close();
    emf.close();
    
    return "Faculty Deleted Successfully";
  }
  @Override
  public Faculty viewfacultybyid(int id) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Faculty f = em.find(Faculty.class,id);
    
    em.close();
    emf.close();
    return f;
  }
  @Override
  public String update(Faculty f) {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();
    
    em.getTransaction().begin();
    Faculty fac = em.find(Faculty.class, f.getId());
    
    fac.setUsername(f.getUsername());
    fac.setName(f.getName());
    fac.setPassword(f.getPassword());
    em.getTransaction().commit();
    
    
    em.close();
    emf.close();
    
    return "Faculty Updated Successfully";
  }
  @Override
  public List<Marks> viewallmarks() {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Query qry=em.createQuery("select m from Marks m");
    List<Marks> markList =qry.getResultList();
    
    em.close();
    emf.close();
    
    return markList;
  }

    
}