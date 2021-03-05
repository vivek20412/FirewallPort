package com.bean;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "customerdetails")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", nullable = false)

	private int id;
	@NotNull
	@Size(min = 1, message = "Customer Name is required")
	private String customername;
	private String username_cust_details;
	private String service_no;

	private String mob;
	private String email;
	private String ticketStatus;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "serverid")
	private List<ServerDetailsTicket> serverDetailsForTicket = null;

	private String configurationDesc;
	private String adminComment;
	

	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}

	public String getConfigurationDesc() {
		return configurationDesc;
	}

	public void setConfigurationDesc(String configurationDesc) {
		this.configurationDesc = configurationDesc;
	}

	public List<ServerDetailsTicket> getServerDetailsForTicket() {
		return serverDetailsForTicket;
	}

	public void setServerDetailsForTicket(List<ServerDetailsTicket> serverDetailsForTicket) {
		this.serverDetailsForTicket = serverDetailsForTicket;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "iplistid")
	private List<IPList> iplist = null;

	public String getService_no() {
		return service_no;
	}

	public void setService_no(String service_no) {
		this.service_no = service_no;
	}

	public String getUsername_cust_details() {
		return username_cust_details;
	}

	public void setUsername_cust_details(String username_cust_details) {
		this.username_cust_details = username_cust_details;
	}

	public List<IPList> getIplist() {
		return iplist;
	}

	public void setIplist(List<IPList> iplist) {
		this.iplist = iplist;
	}

	public CustomerDetails() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

}
