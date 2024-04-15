package com.Railway;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.Railway.dao.TrainDao;
import com.Railway.daoimpl.TrainDaoImpl;
import com.Railway.entity.Ticket;
import com.Railway.entity.Station;
import com.Railway.entity.Train;
import com.Railway.entity.User;
import com.Railway.entity.Reservation;
import com.google.protobuf.TextFormat.ParseException;

public class TrainOperation {

    //Flight
	
	static Scanner sc = new Scanner(System.in);

    
    
    static TrainDao trainDao = new TrainDaoImpl();
    
        private static Train trainInputs() throws ParseException {
            sc.nextLine();

        System.out.println("Enter Train ID:");
        String trainId = sc.nextLine();
        
        System.out.println("Enter Train Name ");
        String trainName = sc.nextLine();
        sc.nextLine();
        
        System.out.println("Enter Train Capacity: ");
        int capacity = sc.nextInt();

        System.out.println("Enter Train Destination: ");
        String destination = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter Description like(AC/NON AC: ");
        String description = sc.nextLine();
        
        System.out.println("Enter Departure Date and Time in yyyy-MM-dd HH:mm:ss:");
        String departureDateTimeInput=sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime departureDateTime= LocalDateTime.parse(departureDateTimeInput, formatter);
        
                        
        System.out.println("Enter Arrival DateTime in the format yyyy-MM-dd HH:mm:ss :");
        String arrivalDateTimeInput=sc.nextLine();
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeInput, formatter);

        List<User> users = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();
        
        


        return new Train(trainId, trainName, capacity,destination,description,departureDateTime, arrivalDateTime, users,reservations);
    }
    
    
    
    public static void trainDetails() throws ParseException {
        
        System.out.println("1.Insert Flight Details");
		System.out.println("2.Get Flight details based on id");
		System.out.println("3.Update Flight Details");
		System.out.println("4.Get all Flight details");
		System.out.println("5.Delete Flight Details");
		System.out.println("5.Join Reservation and  Train Details");


        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	Train train = trainInputs();
            	Train savedTrain = trainDao.createTrain(train);
               System.out.println("Flight "+savedTrain+" added successfully:");
           
                break;
                
            case 2:
          	   
                System.out.println("Enter Train ID:");
                String trainId = sc.next();
                
                Train trainById = trainDao.getTrainById(trainId); 
                if (trainById != null) {
                    System.out.println("Train details: " + trainById);
                } else {
                    System.out.println("Train not found.");
                }
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Train ID to update:");
                String updateTrainId = sc.next(); 
            	
                Train trainToUpdate = trainDao.getTrainById(updateTrainId);
                if (trainToUpdate != null) {
                	trainToUpdate.setCapacity(20000);
                	trainDao.updateTrain(trainToUpdate); 
                    System.out.println("Train updated successfully.");
                } else {
                    System.out.println("Train not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<Train> trains = trainDao.getAllTrains();
            	for (Train a : trains) {
            	    System.out.println("Flight details:");
            	    System.out.println("Flight Id: " + a.getTrainId());
            	    System.out.println("Flight Name: " + a.getTrainName());
            	    System.out.println("Capacity: " + a.getCapacity());
            	    System.out.println("Destination: " + a.getDescription());
            	    System.out.println("Description: " + a.getDescription());
            	    System.out.println("DepartureDateTime: " + a.getDepartureDateTime());
            	    System.out.println("ArrivalDateTime: " + a.getArrivalDateTime());
            	   
            	    System.out.println("-----------------------------------");

            	}
            	
            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter Train ID to delete:");
                String deleteTrainId = sc.next();
                trainDao.deleteTrain(deleteTrainId);
                System.out.println("Train deleted successfully.");
            	
            	break;
            	
            case 6:
            	
            	System.out.println("Joining Train and Reservations:");
            	List<Train> joinRes= trainDao.getAllTrains();
            	System.out.println("Train - Reservations(time of train)");

            	for (Train a : joinRes) {
					System.out.println(a.getTrainName()+ ", " +
			                   a.getReservations().stream()
			                                  .map(ap -> String.valueOf(ap.getReservationDateTime()))
			                                  .collect(Collectors.joining(", ")));	    
				}
            	
            	break;
            
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        
        
        
    }

}
