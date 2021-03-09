package com.ams.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ServerDateTime
{
  
	

  public ServerDateTime() {}
  
  public String serverTime() {
    java.util.Date date = new java.util.Date();
    String strDateFormat = "yyyy MMM dd hh:mm:ss a";
    DateFormat dateFormat = new java.text.SimpleDateFormat(strDateFormat);
    String formattedDate = dateFormat.format(date);  
    return formattedDate;
  }
  
  
  
  public String getGenerateTime() {
	    
	  SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");	
	  Calendar calendar = new GregorianCalendar();
      String time = sdf.format(calendar.getTime());
      return time;
	  }
  

  public String serverDate() {
    DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
    java.util.Date dateobj = new java.util.Date();
    
    System.out.println(df.format(dateobj));
    String currentDate = df.format(dateobj);
    System.out.println(currentDate);
    
    return currentDate;
  }
 
  
  
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
  
  public String serverPreviousDate()
  {
    java.util.Calendar cal = java.util.Calendar.getInstance();
    DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
    cal.add(5, -3);
    String previourDate = dateFormat.format(cal.getTime());
    System.out.println("Yesterday's date was " + dateFormat.format(cal.getTime()));
    return previourDate;
  }
  
  
  public String getExpriTime() {
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");	
	  Calendar calendar = new GregorianCalendar();
	  calendar.add(Calendar.MINUTE,1);
      String time=sdf.format(calendar.getTime());
	
	  return time;
	}

  public String serverPreviousDateforOUT()
  {
    java.util.Calendar cal = java.util.Calendar.getInstance();
    DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
    cal.add(5, -1);
    String previourDate = dateFormat.format(cal.getTime());
    System.out.println("Yesterday's date was " + dateFormat.format(cal.getTime()));
    return previourDate;
  }
  
   public static void main(String[] args) {
	   
	   String time = new ServerDateTime().getExpriTime();
	   System.out.println(time);
	   
   }
	
	           
	         
}
