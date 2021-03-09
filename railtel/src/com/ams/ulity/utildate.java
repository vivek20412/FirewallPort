package com.ams.ulity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class utildate {
	
	
	public Date currenttime()
	{
		
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;
		dateFormat.format(date);
		
		return date;
	}
	
	public Date expritime() throws ParseException
	{
		Date date = new Date() ;
	    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.MINUTE,1);
		String time = dateFormat.format(calendar.getTime());
		return new SimpleDateFormat("HH:mm").parse(time);
		
	}
	
	
	

	
	public void testdate(Date date) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;
		System.out.println(dateFormat.format(date)+"time");

		if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("19:06")))
		{
		    System.out.println("Current time is greater than 15:06 ");
		}else{
		   System.out.println("current time is less then 15:06");
	}

	}
		
 public static void main(String[] args) throws ParseException {

	 Date date = new utildate().expritime();
	 new utildate().testdate(date);
}
	}
