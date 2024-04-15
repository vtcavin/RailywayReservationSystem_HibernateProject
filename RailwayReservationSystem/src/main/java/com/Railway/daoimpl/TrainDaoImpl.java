package com.Railway.daoimpl;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Railway.dao.TrainDao;
import com.Railway.entity.Train;
import com.Railway.entity.Station;
import com.Railway.entity.Train;
import com.Railway.entity.User;
import com.Railway.entity.Reservation;
import com.Railway.util.HibernateUtil;

public class TrainDaoImpl implements TrainDao{

	
	//Flight
	@Override
	public Train createTrain(Train train) {
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			
		        
           
				
			session.save(train);
			session.getTransaction().commit();
			return train;

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
	
  public Train getTrainById(String trainId) {
		
	  Train train=null;
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			train =session.get(Train.class, trainId);
			System.out.println("Train details:");
     	    System.out.println("Train Id" + train.getTrainId());
     	    System.out.println("Train Name: " + train.getTrainName());
     	    System.out.println("Capacity: " +train.getCapacity());
     	    System.out.println("Destination: " + train.getDestination());
     	    System.out.println("Description" + train.getDescription());
     	    System.out.println("DepartureDateTime" +train.getDepartureDateTime());
     	    System.out.println("Arrival: " + train.getArrivalDateTime());
     	    
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
		return train;
		
	}
	
	
   public void updateTrain(Train train) {
		
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			session.saveOrUpdate(train);
			
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
public List<Train> getAllTrains() {
		
		List<Train> trains=new ArrayList<>();
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			

			trains =session.createQuery("FROM Train").list();
		        
		        
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
		return trains;
		
	}
   
   
   public void deleteTrain(String trainId) {
		Train train=null;

		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			train=session.get(Train.class,trainId);
			
			session.delete(train);
			
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



