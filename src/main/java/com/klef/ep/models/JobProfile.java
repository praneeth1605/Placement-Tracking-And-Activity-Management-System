package com.klef.ep.models;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "jobprofile_table")
public class JobProfile implements Serializable
{
  @Id
  @Column(name = "jid")
   private int jid;
  @Column(name = "cname",nullable = false,length = 50)
   private String cname;
  @Column(name = "jtitle",nullable = false,length = 50)
   private String jtitle;
  @Column(name = "jloc",nullable = false,length = 50)
   private String jloc;
  @Column(name = "jtype",nullable = false,length = 50)
   private String jtype;
  @Column(name = "jdes",nullable = false,length = 255)
   private String jdes;
  @Column(name="jlink",nullable = false,length = 255)
  private String jlink;
  @Lob
  @Column(nullable = false)
  private Blob imagedata;
  
  
public Blob getImagedata() {
    return imagedata;
  }
  public void setImagedata(Blob imagedata) {
    this.imagedata = imagedata;
  }
public int getJid() {
  return jid;
}
public void setJid(int jid) {
  this.jid = jid;
}
public String getCname() {
  return cname;
}
public void setCname(String cname) {
  this.cname = cname;
}
public String getJtitle() {
  return jtitle;
}
public void setJtitle(String jtitle) {
  this.jtitle = jtitle;
}
public String getJloc() {
  return jloc;
}
public void setJloc(String jloc) {
  this.jloc = jloc;
}
public String getJtype() {
  return jtype;
}
public void setJtype(String jtype) {
  this.jtype = jtype;
}
public String getJdes() {
  return jdes;
}
public void setJdes(String jdes) {
  this.jdes = jdes;
}
public String getJlink() {
  return jlink;
}
public void setJlink(String jlink) {
  this.jlink = jlink;
}
}