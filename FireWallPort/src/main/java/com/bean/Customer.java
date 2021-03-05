
package com.bean;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity

@Table(name = "customer")
public class Customer {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id", nullable = false)

	private int id;

	@NotNull

	@Size(min = 1, message = "Customer Name is required")
	private String customername;	
	private String mob;
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "serverid")
	private List<ServerDetails> serverDetails = null;
	private String username;
	private String configure;
    private String isUserCreated;
   

	public String getIsUserCreated() {
		return isUserCreated;
	}

	public void setIsUserCreated(String isUserCreated) {
		this.isUserCreated = isUserCreated;
	}

	public String getConfigure() {
		return configure;
	}

	public void setConfigure(String configure) {
		this.configure = configure;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ServerDetails> getServerDetails() {
		return serverDetails;
	}

	public void setServerDetails(List<ServerDetails> serverDetails) {
		this.serverDetails = serverDetails;
	}
	
}
