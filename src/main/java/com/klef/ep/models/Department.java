package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department_table")
public class Department implements Serializable
{
   
	@Id
	@Column(name = "did")
    private int id;
	@Column(name = "dname",nullable = false,unique = true,length = 30)
    private String name;
	@Column(name="dpassword",nullable = false,length = 30)
    private String password;
	
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  
}