package com.Railway;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.Railway.dao.StationDao;
import com.Railway.daoimpl.StationDaoImpl;
import com.Railway.entity.Ticket;
import com.Railway.entity.Station;
import com.Railway.entity.User;

public class StationOperation {

	//Station
	
	static Scanner sc = new Scanner(System.in);

    static StationDao stationDao = new StationDaoImpl();
    
    private static Station stationInputs() {
        sc.nextLine();
        
        System.out.println("Enter Station ID: ");
        String stationId = sc.nextLine();
        
        
        System.out.println("Enter Station Name:");
        String stationName = sc.nextLine();
        

        System.out.println("Enter Hault: ");
        String hault = sc.nextLine();
        
        System.out.println("Enter Station City");
        String city=sc.nextLine();
        
        Ticket ticket = new Ticket();

        return new Station(stationId, stationName, hault, city, ticket);

    }


	public static void stationDetails() {
        
        System.out.println("1.Insert Station Details");
		System.out.println("2.Get Station details based on id");
		System.out.println("3.Update Station Details");
		System.out.println("4.Get all Station details");
		System.out.println("5.Delete Station Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	Station station = stationInputs();
            	Station savedStation = stationDao.createStation(station);
               System.out.println("Station "+savedStation+" added successfully:");
           
                break;
                
            case 2:
          	   
                System.out.println("Enter Station ID:");
                String StationId = sc.next();
                
                Station stationById = stationDao.getStationById(StationId); 
                if (stationById != null) {
                    System.out.println("Station details: " + stationById);
                } else {
                    System.out.println("Station not found.");
                }
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Station ID to update:");
                String updateStationId = sc.next();
            	
                Station stationToUpdate = stationDao.getStationById(updateStationId); 
                if (stationToUpdate != null) {
                	stationToUpdate.setCity("UAE");
                	stationDao.updateStation(stationToUpdate); 
                    System.out.println("Station updated successfully.");
                } else {
                    System.out.println("Station not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<Station> stations = stationDao.getAllStations();
            	
            	for (Station a : stations) {
            	    System.out.println("Station details:");
            	    System.out.println("Station ID: " + a.getStationId());
            	    System.out.println("Station Name: " + a.getStationName());
            	    System.out.println("Hault: " + a.getHault());
            	    System.out.println("City: " + a.getCity());
            	    System.out.println("-----------------------------------");

            	}

            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter Station ID to delete:");
                String deleteStationId = sc.next(); 
                stationDao.deleteStation(deleteStationId); 
                System.out.println("Station deleted successfully.");
            	
            	break;
            
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        
    }
}
