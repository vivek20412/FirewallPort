package com.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKeyEntity implements Serializable {

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -7848548265647111825L;
	
	@Column(name="username")
	private String username;
	@Column(name="ticketno")
	private String ticketno;
	
//	/*
//	 * 
//	 * 
//	 * 
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	public CompositeKeyEntity(String username, String ticketno) {
		super();
		this.username = username;
		this.ticketno = ticketno;
	}
	public CompositeKeyEntity() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTicketno() {
		return ticketno;
	}
	public void setTicketno(String ticketno) {
		this.ticketno = ticketno;
	}
	
	

}
