package com.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="iplisttable")
public class IPList {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;	
    private String activationTime;
	 private String deactivationTime;
	 private String sourceIp;
	 private String ipentry;
	 private String direction;
	 private String port;
	 private String action;
	 private String comments;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="id",nullable=false)
	 */
	 
	 
	 
	public int getId() {
		return id;
	}
	
	public String getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(String activationTime) {
		this.activationTime = activationTime;
	}

	public String getDeactivationTime() {
		return deactivationTime;
	}

	public void setDeactivationTime(String deactivationTime) {
		this.deactivationTime = deactivationTime;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getSourceIp() {
		return sourceIp;
	}
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}
	public String getIpentry() {
		return ipentry;
	}
	public void setIpentry(String ipentry) {
		this.ipentry = ipentry;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	//private int iplistid;
	


	
	
	

	
}
