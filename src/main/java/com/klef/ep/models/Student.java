package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student implements Serializable
{
  @Id
  @Column(name = "sid")
  private int id;
  @Column(name = "sname", nullable = false,length = 30)
  private String name;
  @Column(name = "suname", unique = true, nullable = false,length = 30)
  private String username;
  @Column(name = "spassword", nullable = false,length = 30)
  private String password;
  @Column(name = "sdepartment", nullable = false,length = 20)
  private String department;
  @Column(name = "scontact", nullable = false,length = 15)
  private String contact;
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
}
