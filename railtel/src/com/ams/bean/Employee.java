package com.ams.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int empid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email_id",unique=true, length=60)
	private String emailid;
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Column(name="Phoneno",length=40,unique=true)
	private String phoneno;
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public String toString()
	{
		return name +phoneno+empid;
	}

}
