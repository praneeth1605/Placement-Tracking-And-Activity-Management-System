package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marks_table")
public class Marks implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sid")
    private int sid;
    @Column(name = "sname", nullable = false,length = 30)
    private String studentname;
    @Column(name = "qname", nullable = false,length = 30)
    private String quizname;
    @Column(name = "smarks",nullable = false)
    private int marks;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public int getSid() {
    return sid;
  }
  public void setSid(int sid) {
    this.sid = sid;
  }
  public String getStudentname() {
    return studentname;
  }
  public void setStudentname(String studentname) {
    this.studentname = studentname;
  }
  public String getQuizname() {
    return quizname;
  }
  public void setQuizname(String quizname) {
    this.quizname = quizname;
  }
  public int getMarks() {
    return marks;
  }
  public void setMarks(int marks) {
    this.marks = marks;
  }
    
}