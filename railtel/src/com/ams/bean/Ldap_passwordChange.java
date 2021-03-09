package com.ams.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ldap_passwordchange")
public class Ldap_passwordChange {
	
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="userid")
		public int user_id;
	    
			
		@Column(name="email_id")
		public String emailid;
	
		@Column(name="Change_time")
		public String changetime;
		
	
		public String getChangetime() {
			return changetime;
		}

		public void setChangetime(String changetime) {
			this.changetime = changetime;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

	


}
