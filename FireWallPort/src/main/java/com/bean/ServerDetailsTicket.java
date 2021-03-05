
  package com.bean;
  import javax.persistence.Entity; 
  import javax.persistence.GeneratedValue; 
  import javax.persistence.GenerationType;
  import javax.persistence.Id; 
  
  @Entity public class ServerDetailsTicket {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.AUTO) 
  private int id;
  private String hostname;
  private String os;
  private String privateip;
  private String publicip;
  
  private String nat; public String getNat() { return nat; }
  
  public void setNat(String nat) { this.nat = nat; }
  
  public String getPublicip() { return publicip; }
  
  public void setPublicip(String publicip) { this.publicip = publicip; }
  
  
  public int getId() { return id; }
  
  public void setId(int id) { this.id = id; }
  
  public String getHostname() { return hostname; }
  
  public void setHostname(String hostname) { this.hostname = hostname; }
  
  public String getOs() { return os; }
  
  public void setOs(String os) { this.os = os; }
  
  public String getPrivateip() { return privateip; }
  
  public void setPrivateip(String privateip) { this.privateip = privateip; }
  
  }
 