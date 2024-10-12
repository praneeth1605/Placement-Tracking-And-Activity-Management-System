package com.klef.ep.services;

import javax.ejb.Remote;

import com.klef.ep.models.IRP;
import com.klef.ep.models.JobProfile;
@Remote
public interface IRPService 
{
 public IRP validatelogin(String username,String password);
 public String addjob(JobProfile j);
}