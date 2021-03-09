package com.ams.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Otp")
public class Otp_status {
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	public int user_id;
    
	
	@Column(name="Phone_no")
	public String phoneno;
	
	@Column(name="Ip_address")
	public String ipaddress;
	
	
	@Column(name="Email_id")
	public String emailid;
	
	@Column(name="Otp")
	public String otp;
	
	@Column(name="Generate_time")
	public String generatetime;
	
	@Column(name="Expri_time")
	public String expritime;
	
	
	@Temporal(TemporalType.DATE)
	public  java.util.Date generatedate;

	@Column(name="times",length=5)
    public int times;

    
	
	@Column(name="flag",length=10)
    public	String flag;
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getGeneratetime() {
		return generatetime;
	}

	public void setGeneratetime(String generatetime) {
		this.generatetime = generatetime;
	}

	public String getExpritime() {
		return expritime;
	}

	public void setExpritime(String expritime) {
		this.expritime = expritime;
	}

	public java.util.Date getGeneratedate() {
		return generatedate;
	}

	public void setGeneratedate(java.util.Date generatedate) {
		this.generatedate = generatedate;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	
	public String toString()
	{
		
		  return ipaddress+times+flag;
	}



	
	

}
