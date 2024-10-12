package com.klef.ep.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "irp_table")
public class IRP implements Serializable
{
	@Id
	@Column(name="iuname",length = 30)
	private String username;
	@Column(name = "ipwd",length = 30,nullable = false)
	private String password;
	
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
