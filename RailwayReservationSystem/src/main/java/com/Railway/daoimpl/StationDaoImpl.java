package com.Railway.daoimpl;

import java.time.LocalDateTime;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Railway.dao.StationDao;
import com.Railway.entity.Ticket;
import com.Railway.entity.Station;
import com.Railway.util.HibernateUtil;

public class StationDaoImpl implements StationDao{


       //Station
		@Override
		public Station createStation(Station station) 
		{
			try(Session session=HibernateUtil.getSession()){
				
			session.beginTransaction();
			
			
			// Create Ticket objects
			Ticket a1 = new Ticket();
			a1.setTicketId(a1.getTicketId()); 

						
		    // Create Ticket_Status objects
			Station ap1 = new Station();
			ap1.setStationName(station.getStationName());
			ap1.setCity(station.getCity());
			ap1.setTicket(a1);
			
			Station ap2 = new Station();
			ap2.setStationName("Bandra Station");
			ap2.setCity("Mumbai");
			
			ap2.setTicket(a1);
			
			// Create lists of Stations for each Ticket
			List<Station> stationsOfTicket = new ArrayList<Station>();
			stationsOfTicket.add(ap1);
			stationsOfTicket.add(ap2);

			// Set the maintenance lists for each Ticket
			a1.setStations(stationsOfTicket);

            session.save(a1);
			
			
	        
			session.getTransaction().commit();
			return station;
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
		
		public Station getStationById(String stationId) {
			
			Station station=null;
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				station =session.get(Station.class, stationId);
				 System.out.println("Station details:");
         	    System.out.println("Station ID: " + station.getStationId());
         	    System.out.println("Hault: " + station.getHault());
         	    System.out.println("City: " + station.getCity());
         	    
         	    System.out.println("-----------------------------------");

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
			return station;
			
		}
		
		
	   public void updateStation(Station station) {
			
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				session.saveOrUpdate(station);
				
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
	public List<Station> getAllStations() {
			
			List<Station> stations=null;
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				stations =session.createQuery("FROM Station").list();
				
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
			return stations;
			
		}
	   
	   
	   public void deleteStation(String stationId) {
		   Station station=null;

			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				station=session.get(Station.class,stationId);
				
				session.delete(station);
				
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