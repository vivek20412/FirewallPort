package com.ams.Doa;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ams.bean.Employee;
import com.ams.bean.Otp_status;
import com.ams.bean.SmsLogs;

import net.sf.gilead.pojo.gwt.collection.SetParameter;

public class Doa {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED)
	public String checkMailId(String email) {
		String Phoneno = null;
		String sqlquery = "select *from employee where email_id=:email_id";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sqlquery).setParameter("email_id", email);

		List result = query.list();

		Iterator it = result.iterator();

		while (it.hasNext()) {
			Object obj[] = (Object[]) it.next();
			String id = String.valueOf(obj[0]);
			String emailid = String.valueOf(obj[1]);
			String name = String.valueOf(obj[2]);
			Phoneno = String.valueOf(obj[3]);
		}

		return Phoneno;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer saveotp(String Email_id, String Expri_time, String Otp, String Phone_no, String generatime,
			int times, String flag, String ipaddress) {

		java.util.Date utilDate = new java.util.Date();
		Date gdate = new Date(utilDate.getTime());

		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"insert into Otp(Email_id,Expri_time,Otp,Phone_no,Generate_time,generatedate,times,flag,Ip_address) values(?,?,?,?,?,?,?,?,?)")
				.setParameter(0, Email_id).setParameter(1, Expri_time).setParameter(2, Otp).setParameter(3, Phone_no)
				.setParameter(4, generatime).setParameter(5, gdate).setParameter(6, times).setParameter(7, flag)
				.setParameter(8, ipaddress);

		int i = query.executeUpdate();
		return i;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer Ldappasswordchange(String email_id, String Change_time) {
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery("insert into ldap_passwordchange(email_id,Change_time) values(?,?)")
				.setParameter(0, email_id).setParameter(1, Change_time);

		int i = query.executeUpdate();
		return i;
	}

	/*
	 * @Transactional(propagation = Propagation.REQUIRED) public Integer
	 * otpid(String phone) {
	 * 
	 * int otpid;
	 * 
	 * Criteria criteria = sessionFactory.getCurrentSession()
	 * .createCriteria(Otp_status.class) .add(Restrictions.eq("phoneno", phone))
	 * .setProjection(Projections.max("user_id")); otpid =
	 * (Integer)criteria.uniqueResult();
	 * 
	 * return otpid;
	 * 
	 * }
	 */

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer verifyotp(String email) {

		int otpid = 0;

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("emailid", email)).setProjection(Projections.max("user_id"));
		otpid = (Integer) criteria.uniqueResult();
		if (otpid == 0) {
			return 0;
		}

		return otpid;

	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Otp_status> limitstatus(String email) {

		int otpid = 0;

		java.util.Date utilDate = new java.util.Date();
		Date gdate = new Date(utilDate.getTime());

		@SuppressWarnings("unused")
		List<Otp_status> list = sessionFactory.getCurrentSession()
				.createSQLQuery("select *from Otp where Email_id=:Email_id and  generatedate=:generatedate")
				.addEntity(Otp_status.class).setParameter("Email_id", email).setParameter("generatedate", gdate).list();

		return list;

	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Otp_status> checkiplist() {

		int otpid = 0;

		java.util.Date utilDate = new java.util.Date();
		Date gdate = new Date(utilDate.getTime());

		@SuppressWarnings("unused")
		List<Otp_status> list = sessionFactory.getCurrentSession()
				.createSQLQuery("select *from Otp where  generatedate=:generatedate").addEntity(Otp_status.class)
				.setParameter("generatedate", gdate).list();

		return list;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Boolean saveLogs(SmsLogs log) {

		Boolean flag = false;

		int i = (Integer) sessionFactory.getCurrentSession().save(log);

		if (i > 0)

		{
			flag = true;

		}

		return flag;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer verifyemaild(String email) {

		int otpid;

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("emailid", email)).setProjection(Projections.max("user_id"));
		otpid = (Integer) criteria.uniqueResult();

		return otpid;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String getphone(String email) {

		String otpid;

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("emailid", email)).setProjection(Projections.max("phoneno"));
		otpid = (String) criteria.uniqueResult();

		return otpid;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer getMaxidEmail(String emailid, String otp) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("otp", otp)).add(Restrictions.eq("emailid", emailid))
				.setProjection(Projections.max("user_id"));
		Integer otpid = (Integer) criteria.uniqueResult();

		return otpid;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String getExpiretime(Integer userid, String otp) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("otp", otp)).add(Restrictions.eq("user_id", userid))
				.setProjection(Projections.property("expritime"));
		String expriTime = (String) criteria.uniqueResult();

		return expriTime;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String getGeneratetime(Integer userid) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("user_id", userid)).setProjection(Projections.property("generatetime"));
		String generatetime = (String) criteria.uniqueResult();
		return generatetime;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String readotp(Integer otpid) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("user_id", otpid)).setProjection(Projections.property("otp"));

		String otp = (String) criteria.uniqueResult();

		return otp;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String getstatus(String emailid) {

		java.util.Date utilDate = new java.util.Date();
		Date gdate = new Date(utilDate.getTime());

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("emailid", emailid)).add(Restrictions.eq("generatedate", gdate))
				.setProjection(Projections.property("flag"));

		String otp = (String) criteria.setMaxResults(1).uniqueResult();

		return otp;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer getlimitstatus(String emailid) {
		Integer times = 0;
		try {
			java.util.Date utilDate = new java.util.Date();
			Date gdate = new Date(utilDate.getTime());

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
					.add(Restrictions.eq("emailid", emailid)).add(Restrictions.eq("generatedate", gdate))
					/* .add(Restrictions.eq("times ",3)) */
					/* .add(Restrictions.eq("Ip_address",ipaddress)) */
					.setProjection(Projections.max("times"))

			;

			times = (Integer) criteria.setMaxResults(1).uniqueResult();

		} catch (NullPointerException e) {
			e.printStackTrace();

		}

		return times;

	}

	/*
	 * @Transactional(propagation = Propagation.REQUIRED) public Long
	 * getlimitstatus(String emailid) {
	 * 
	 * java.util.Date utilDate = new java.util.Date();
	 * 
	 * Date gdate = new Date(utilDate.getTime());
	 * 
	 * Session session = sessionFactory .getCurrentSession();
	 * 
	 * Long query = (Long) session
	 * .createSQLQuery("select count(times),Email_id from Otp where  Email_id=:Email_id"
	 * ) .addEntity(Otp_status.class) .setParameter("Email_id",emailid)
	 * .uniqueResult();
	 * 
	 * 
	 * 
	 * System.out.println("countimes");
	 * 
	 * 
	 * 
	 * 
	 * return query;
	 * 
	 * 
	 * 
	 * }
	 */

	@Transactional(propagation = Propagation.REQUIRED)
	public String getTimeStatus(String emailid) {

		java.util.Date utilDate = new java.util.Date();
		Date gdate = new Date(utilDate.getTime());
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Otp_status.class)
				.add(Restrictions.eq("emailid", emailid)).add(Restrictions.eq("generatedate", gdate))
				.setProjection(Projections.property("flag"));
		String otp = (String) criteria.setMaxResults(1).uniqueResult();
		return otp;

	}

}
