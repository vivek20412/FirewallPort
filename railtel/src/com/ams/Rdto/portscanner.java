package com.ams.Rdto;

import java.util.Calendar;

import org.apache.log4j.chainsaw.Main;

public class portscanner {
	
	
	
	
	public void getcalendar()
	{
		
		Calendar cal = Calendar.getInstance();

		// Set time of calendar to 18:00
		cal.set(Calendar.HOUR_OF_DAY, 18);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		// Check if current time is after 18:00 today
		boolean afterSix = Calendar.getInstance().after(cal);

		if (afterSix) {
		    System.out.println("Go home, it's after 6 PM!");
		}
		else {
		    System.out.println("Hello!");

	
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
	}
		
	}
		
	
	
		
	
	
	
	
	
	

	 
		


