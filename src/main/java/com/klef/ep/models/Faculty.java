package com.klef.ep.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty_table")
public class Faculty implements Serializable
{  
  @Id
    @Column(name="uid")
    private int id;
    @Column(name="uname", nullable = false, length = 30)
    private String name;
    @Column(name="username", nullable = false, length = 30, unique = true)
    private String username;
    @Column(name="upassword", nullable = false, length=30)
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

}