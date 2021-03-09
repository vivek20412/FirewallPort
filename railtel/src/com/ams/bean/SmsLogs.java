package com.ams.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SmsLogs")
public class SmsLogs {

	
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="smsid")
		public int smsid;
	    
	    
	    @Column(name="logs",length = 255)
		private String logs;


		public int getSmsid() {
			return smsid;
		}


		public void setSmsid(int smsid) {
			this.smsid = smsid;
		}


		public String getLogs() {
			return logs;
		}


		public void setLogs(String logs) {
			this.logs = logs;
		}
		
	    
	    
	    
	
}
