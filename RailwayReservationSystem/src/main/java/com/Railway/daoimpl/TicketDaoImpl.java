package com.Railway.daoimpl;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Railway.dao.TicketDao;
import com.Railway.entity.Ticket;
import com.Railway.entity.Station;
import com.Railway.entity.Train;
import com.Railway.entity.Payment;
import com.Railway.util.HibernateUtil;

public class TicketDaoImpl implements TicketDao{

//Ticket
		@Override
		public Ticket createTicket(Ticket ticket) {
			
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
		        
				session.save(ticket);
				session.getTransaction().commit();
				return ticket;
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
		
	
		public Ticket getTicketById(String ticketId) {
			
			Ticket ticket=null;
			
			Session session=HibernateUtil.getSession();
				
				session.beginTransaction();
				
				ticket =session.get(Ticket.class, ticketId);
				
				System.out.println("Ticket details:");
        	    System.out.println("Ticket ID: " + ticket.getTicketId());
        	    System.out.println("Ticket Name: " + ticket.getTicketName());
        	    System.out.println("Train No: " + ticket.getTrainNo());
        	    System.out.println("Ticket Price: " + ticket.getTicketPrice());
        	    System.out.println("PNR NO : " + ticket.getPNRNo());
				
				session.getTransaction().commit();
				
			return ticket;
			
		}
		
		
		
		
	   public void updateTicket(Ticket ticket) {
			
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				
				
				session.saveOrUpdate(ticket);
				
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
	   
	   public List<Ticket> getAllTickets() {
		   
		    List<Ticket> tickets = new ArrayList<>();
		    try (Session session = HibernateUtil.getSession()) {
		        session.beginTransaction();

		        TypedQuery<Ticket> q = session.createQuery("SELECT DISTINCT a FROM Ticket a LEFT JOIN FETCH a.stations", Ticket.class);
		        TypedQuery<Ticket> q1 = session.createQuery("SELECT DISTINCT a FROM Aircraft a LEFT JOIN FETCH a.aircraftMaintenances", Ticket.class);

		        tickets = q.getResultList();
		        tickets = q1.getResultList();

		        session.getTransaction().commit();
		    } catch (HibernateException e) {
		        e.printStackTrace();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return tickets;
		}

	   
	   public void deleteTicket(String ticketId) {
		   Ticket ticket=null;

			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				ticket=session.get(Ticket.class,ticketId);
				
				session.delete(ticket);
				
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
		

		

}
