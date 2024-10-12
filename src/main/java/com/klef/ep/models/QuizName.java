package com.klef.ep.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quizname_table")
public class QuizName 
{
  @Id
  @Column(name = "quizname",length = 50,nullable = false)
  private String quizname;

public String getQuizname() {
	return quizname;
}

public void setQuizname(String quizname) {
	this.quizname = quizname;
}
}
