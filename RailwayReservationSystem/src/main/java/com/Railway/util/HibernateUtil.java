package com.Railway.util;


import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.Railway.entity.Ticket;
import com.Railway.entity.Station;
import com.Railway.entity.Train;
import com.Railway.entity.User;
import com.Railway.entity.Payment;
import com.Railway.entity.Reservation;


public class HibernateUtil {
	
	
private final static SessionFactory sessionFactory=buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
				
		try {
			return new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(User.class)
					.addAnnotatedClass(Station.class)
					.addAnnotatedClass(Train.class)
					.addAnnotatedClass(Reservation.class)
					.addAnnotatedClass(Payment.class)
					.addAnnotatedClass(Ticket.class)
					.buildSessionFactory();
			
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public static Session getSession(){
	  return getSessionFactory().openSession(); //session opened
	}			
			
		

	
}

