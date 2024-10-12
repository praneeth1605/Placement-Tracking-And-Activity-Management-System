package com.klef.ep.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.IRP;
import com.klef.ep.models.JobProfile;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IRPServiceImpl implements IRPService
{
  @Override
  public IRP validatelogin(String username, String password)
  {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa");
    EntityManager em=emf.createEntityManager();

    Query qry=em.createQuery("select ir from IRP ir where ir.username=? and ir.password=?");
    qry.setParameter(1, username);
    qry.setParameter(2,password);
    
    IRP ir=null;
    
    if(qry.getResultList().size()>0)
    {
      ir=(IRP)qry.getSingleResult();
    }
    
    em.close();
    emf.close();
    
    return ir;
  }

@Override
public String addjob(JobProfile j) 
{
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
     EntityManager em = emf.createEntityManager();
       
       em.getTransaction().begin();
       em.persist(j);
       em.getTransaction().commit();
       
       em.close();
       emf.close();
   
   return "Job Profile Added Successfully";
}

}