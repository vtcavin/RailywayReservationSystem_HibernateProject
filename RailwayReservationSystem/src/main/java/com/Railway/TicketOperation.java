package com.Railway;

import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.Railway.dao.TicketDao;
import com.Railway.daoimpl.TicketDaoImpl;
import com.Railway.entity.Ticket;
import com.Railway.entity.Station;
import com.Railway.entity.Train;
import com.Railway.entity.User;

public class TicketOperation {

	//Ticket
		
	static Scanner sc = new Scanner(System.in);

    static TicketDao ticketDao = new TicketDaoImpl();
    
    private static Ticket ticketInputs() {
        sc.nextLine();
        
        System.out.println("Enter Ticket ID: ");
        String ticketId = sc.nextLine();
        
        System.out.println("Enter TicketName ");
        String ticketName = sc.nextLine();
        sc.nextLine();
        
        System.out.println("Enter Train No: ");
        int trainNo = sc.nextInt();
        
        
        System.out.println("Enter TicketPrice: ");
        int ticketprice = sc.nextInt();

        System.out.println("Enter PNR No: ");
        int pnrno = sc.nextInt();

       
    	
        List<Station> stations = new ArrayList<Station>();
        


        return new Ticket(ticketId, ticketName, trainNo, ticketprice,pnrno,stations);

    }


	public static void ticketDetails() {
        
        System.out.println("1.Insert Ticket Details");
		System.out.println("2.Get Ticket details based on id");
		System.out.println("3.Update Ticket Details");
		System.out.println("4.Get all Ticket details");
		System.out.println("5.Delete Ticket Details");
		System.out.println("6.Join Ticket and Station Details");
		System.out.println("7.Join  Ticket Status Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	Ticket ticket = ticketInputs();
            	Ticket savedTicket = ticketDao.createTicket(ticket);
               System.out.println("Ticket "+savedTicket+" added successfully:");
           
                break;
                
                
            case 2:
          	   
                System.out.println("Enter Ticket ID:");
                String ticketId = sc.next();
                
                Ticket ticketById = ticketDao.getTicketById(ticketId); 
                if (ticketById != null) {
                    System.out.println("Ticket details: " + ticketById);
                } else {
                    System.out.println("Ticket not found.");
                }
                    
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Ticket ID to update:");
                String updateTicketId = sc.next(); 
            	
                Ticket ticketToUpdate = ticketDao.getTicketById(updateTicketId); 
                
                
                if (ticketToUpdate != null) {
                	
                	ticketToUpdate.setPNRNo(467887);
                	//ticketToUpdate.setTicketName("AC Ticket");
                	ticketDao.updateTicket(ticketToUpdate); 
                    System.out.println("Ticket updated successfully.");
                } else {
                    System.out.println("Ticket not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<Ticket> tickets = ticketDao.getAllTickets();
            	for (Ticket a : tickets) {
            	    System.out.println("Ticket details:");
            	    System.out.println("Ticket ID: " + a.getTicketId());
            	    System.out.println("Ticket Name: " + a.getTicketName());
            	    System.out.println("Train No " + a.getTrainNo());
            	    System.out.println("Ticket Price: " + a.getTicketPrice());
            	    System.out.println("PNR No : " + a.getPNRNo());
            	    System.out.println("-----------------------------------");

            	}
            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter Ticket ID to delete:");
                String deleteTicketId = sc.next();
                ticketDao.deleteTicket(deleteTicketId);
                System.out.println("Ticket deleted successfully.");
            	
            	break;
            	
            	
            case 6:
            	
            	System.out.println("Joining Ticket and Station:");
            	List<Ticket> joinStation= ticketDao.getAllTickets();
            	for (Ticket a : joinStation) {
					System.out.println(a.getTicketId() + ", " +
			                   a.getStations().stream()
			                                  .map(ap -> String.valueOf(ap.getStationId()))
			                                  .collect(Collectors.joining(", ")));	    
				}
            	
            	break;
            	
            
            	
            
            
            	
            
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        
    }
}
