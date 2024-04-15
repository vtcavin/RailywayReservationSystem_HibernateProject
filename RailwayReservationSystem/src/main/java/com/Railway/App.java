package com.Railway;

import java.util.Scanner;

import com.google.protobuf.TextFormat.ParseException;

public class App 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	Scanner sc=new Scanner(System.in);
    	
    		System.out.println("Press");
    		System.out.println("1.User Details");
    		System.out.println("2.Station Details");
    		System.out.println("3.Train Details");
    		System.out.println("4.Reservation Details");
    		System.out.println("5.Payment Details");
    		System.out.println("6.Ticket Details");
    		
        	int choice=sc.nextInt();
        	
    	  switch(choice)
    	  {
    	  
    	  case 1:
    		  Useroperation.userDetails();
    		  break;    		 
    		  
    		  
    	  case 2:
    		  StationOperation.stationDetails();

    		  break;
    		  
    	  case 3:
    		  TrainOperation.trainDetails();

    		  break;
    		  
    	  case 4:
    		  ReservationOperation.reservationDetails();

    		  break;
          
    	  case 5:
    		  PaymentOperation.paymentDetails();

    		  break;
    		  
        		  
    	  case 6:
    		  TicketOperation.ticketDetails();

    		  break;
    		  
    	 
    	     		  
    	
    	  }
    	
    	sc.close();
    }
}

	
    	
    	
    
