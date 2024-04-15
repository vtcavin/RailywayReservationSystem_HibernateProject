package com.Railway;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.Railway.dao.ReservationDao;
import com.Railway.daoimpl.ReservationDaoImpl;
import com.Railway.entity.Train;
import com.Railway.entity.User;
import com.Railway.entity.Payment;
import com.Railway.entity.Reservation;

public class ReservationOperation {

	//Reservation
	
	static Scanner sc = new Scanner(System.in);

    static ReservationDao reservationDao = new ReservationDaoImpl();
    
    private static Reservation reservationInputs() {
        sc.nextLine();
        
        System.out.println("Enter Reservation ID: ");
        String reservationId = sc.nextLine();


        System.out.println("Enter Reservation DateTime in the format yyyy-MM-dd HH:mm:ss :");
        String reservationDateTimeInput=sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime reservationDateTime = LocalDateTime.parse(reservationDateTimeInput, formatter);

        System.out.println("Enter Seat Number:");
        int seatNumber = sc.nextInt();

        System.out.println("Enter Status:");
        String status = sc.nextLine();
        
        sc.nextLine();

        
        List<User> user = new ArrayList<User>();
        Train train= new Train();
        
        Payment payment=new Payment();
        
       
        return new Reservation(reservationId,reservationDateTime, seatNumber, status,user,train,payment);

    }


	public static void reservationDetails() {
        
        System.out.println("1.Insert Reservation Details");
		System.out.println("2.Get Reservation details based on id");
		System.out.println("3.Update Reservation Details");
		System.out.println("4.Get all Reservation details");
		System.out.println("5.Delete Reservation Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	Reservation  reservation = reservationInputs();
            	Reservation savedReservation = reservationDao.createReservation( reservation);
               System.out.println("Reservation "+savedReservation+" added successfully:");
           
                break;
                
                
          case 2:
            	   
                System.out.println("Enter Reservation ID:");
                String reservationId = sc.next();
                
                Reservation reservationById = reservationDao.getReservationById(reservationId); 
                if (reservationById != null) {
                    System.out.println("Reservation details: " + reservationById);
                } else {
                    System.out.println("Reservation not found.");
                }
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Reservation ID to update:");
                String updateReservationId = sc.next(); 
            	
                Reservation reservationToUpdate = reservationDao.getReservationById(updateReservationId); 
                if (reservationToUpdate != null) {
                	reservationToUpdate.setSeatNumber(45);
                	reservationDao.updateReservation(reservationToUpdate);
                    System.out.println("Reservation updated successfully.");
                } else {
                    System.out.println("Reservation not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<Reservation> reservations = reservationDao.getAllReservation();
            	for (Reservation a : reservations) {
            	    System.out.println("Reservation details:");
            	    System.out.println("Reservation ID: " + a.getReservationId());
            	    System.out.println("Date and Time : " + a.getReservationDateTime());
            	    System.out.println("Seat Number : " + a.getSeatNumber());
            	    System.out.println("Status: " + a.getStatus());
            	    System.out.println("-----------------------------------");

            	}
            	
            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter Reservation ID to delete:");
                String deleteReservationId = sc.next(); 
                reservationDao.deleteReservation(deleteReservationId); 
                System.out.println("Reservation deleted successfully.");
            	
            	break;
            
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
      
        }
        
	}
	
	
}
        
    


