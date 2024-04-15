package com.Railway.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.stat.SessionStatistics;
import org.hibernate.stat.Statistics;

import com.Railway.dao.UserDao;
import com.Railway.entity.Train;
import com.Railway.entity.User;
import com.Railway.entity.Payment;
import com.Railway.entity.Reservation;
import com.Railway.util.HibernateUtil;


public class UserDaoImpl implements UserDao{

	@Override
	public User createUser(User user) 
	{
		try(Session session=HibernateUtil.getSession()){
		        	        
		session.beginTransaction();
		
		//Many to Many- reservation
		//Create a user
		User u1=new User();
		u1.setFirstName(user.getFirstName());
		u1.setLastName(user.getLastName());
		u1.setGender(user.getGender());
		u1.setAge(user.getAge());
		u1.setCity(user.getCity());
		u1.setState(user.getState());
		
		//Create an user 2
		User u2=new User();
		u2.setFirstName("Cavin");
		u2.setLastName("Vadala");
		u2.setGender("Male");
		u2.setAge(22);
		u2.setCity("Hyderabad");
		u2.setState("Telangana");
		
		//Create an user 3
		User u3=new User();
		u3.setFirstName("Manohar");
		u3.setLastName("Byneedi");
		u3.setGender("Male");
		u3.setAge(23);
		u3.setCity("Chennai");
		u3.setState("TamilNadu");
		
		//Create reservation 1
		Reservation res1= new Reservation();
		res1.setReservationId("RS_01");
		
		//Create reservation 2
		Reservation res2= new Reservation();
		res2.setReservationId("RS_02");

		
		List<User> userOfReservation1=new ArrayList<>();
		userOfReservation1.add(u1);
		userOfReservation1.add(u2);
		userOfReservation1.add(u3);

		List<User> userOfReservation2= new ArrayList<>();
		userOfReservation2.add(u1);
		userOfReservation2.add(u2);
		
		// Set user for reservations
        res1.setUsers(userOfReservation1);
        res2.setUsers(userOfReservation2);

		session.save(res1);
		session.save(res2);	
		
		
			
	     
		//session.save(passenger);
		session.getTransaction().commit();
		return user;
		}
		catch(HibernateException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
		
	}

public User getUserById(String userId) {
		
	User user=null;
	
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			user =session.get(User.class, userId);
			
			System.out.println("User details:");
    	    System.out.println("User ID : " + user.getUserId());
    	    System.out.println("First Name : " + user.getFirstName());
    	    System.out.println("Last Name : " +user.getLastName());
    	    System.out.println("Gender: " + user.getGender());
    	    System.out.println("Age: " + user.getAge());
    	    System.out.println("Mobile No: " + user.getMobileNo());
    	    System.out.println("City: " + user.getCity());
    	    System.out.println("State: " + user.getState());

			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return user;
		
	}
	
	
   public void updateUser(User user) {
		
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			session.saveOrUpdate(user);
			
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}
   
   @SuppressWarnings("unchecked")
public List<User> getAllPassengers() {
		
		List<User> users=new ArrayList<>();
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
					    
		    TypedQuery<User> p = session.createQuery("SELECT DISTINCT a FROM Flight a LEFT JOIN FETCH a.reservations", User.class);
		    users = p.getResultList();
		    
		    TypedQuery<User> p1 = session.createQuery("SELECT DISTINCT a FROM Flight a LEFT JOIN FETCH a.flights", User.class);
		    users = p1.getResultList();
		    
		    
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return users;
		
	}
   
   
   public void deleteUser(String userId) {
	   User user=null;

		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			user=session.get(User.class,userId);
			
			session.delete(user);
			
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}

@Override
public List<User> getAllUser() {
	// TODO Auto-generated method stub
	return null;
}
   
   
   
   
	

	
}
	