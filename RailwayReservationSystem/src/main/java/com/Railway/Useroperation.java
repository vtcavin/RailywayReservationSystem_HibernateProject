package com.Railway;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.Railway.dao.UserDao;
import com.Railway.daoimpl.UserDaoImpl;
import com.Railway.entity.Ticket;
import com.Railway.entity.Train;
import com.Railway.entity.User;
import com.Railway.entity.Payment;
import com.Railway.entity.Reservation;

public class Useroperation {

	
	//User

    static Scanner sc = new Scanner(System.in);

    static UserDao userDao = new UserDaoImpl();
    
    private static User userInputs() {
        sc.nextLine();
        
        System.out.println("Enter User ID:");
        String userId = sc.nextLine();

        System.out.println("Enter First Name:");
        String firstName = sc.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = sc.nextLine();

        System.out.println("Enter Gender:");
        String gender = sc.nextLine();

        System.out.println("Enter Age:");
        int age = sc.nextInt();

        System.out.println("Enter Mobile Number:");
        double mobileno = sc.nextDouble();
        
        System.out.println(" Enter name of City: ");
        String city = sc.nextLine();
        sc.nextLine();
        
        System.out.println("Enter name of State: ");
        String state = sc.nextLine();
                

        List<Reservation> reservation = new ArrayList<Reservation>();
        
        List<Train> train = new ArrayList<Train>();
        


        return new User(userId, firstName, lastName, gender, age, mobileno,city,state,reservation,train);


    }


    public static void userDetails() {
        
        System.out.println("1.Insert User Details");
		System.out.println("2.Get User details");
		System.out.println("3.Update User Details");
		System.out.println("4.Get all User Details");
		System.out.println("5.Delete User Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                User user = userInputs();
                User savedUser = userDao.createUser(user);
               System.out.println("User "+savedUser+" added successfully:");
           
                break;
                
            case 2:
         	   
                System.out.println("Enter User ID:");
                String userId = sc.next();
                
                User userById = userDao.getUserById(userId); 
                if (userById != null) {
                    System.out.println("User details: " + userById);
                } else {
                    System.out.println("User not found.");
                }
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter User ID to update:");
                String updateUserId = sc.next(); 
            	
                User userToUpdate = userDao.getUserById(updateUserId); 
                if (userToUpdate != null) {
                	userToUpdate.setFirstName("Cavin");
                	userToUpdate.setCity("Hyderabad");

                	userDao.updateUser(userToUpdate); 
                    System.out.println("User updated successfully.");
                } else {
                    System.out.println("User not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<User> users = userDao.getAllUser();
            	for (User a : users) {
            	    System.out.println("User details:");
            	    System.out.println("User ID : " + a.getUserId());
            	    System.out.println("First Name : " + a.getFirstName());
            	    System.out.println("Last Name : " + a.getLastName());
            	    System.out.println("Gender: " + a.getGender());
            	    System.out.println("Mobile No : " + a.getMobileNo());
            	    System.out.println("City : " + a.getCity());
            	    System.out.println("State : " + a.getCity());

            	    System.out.println("-----------------------------------");

            	}

            	
            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter User ID to delete:");
                String deleteUserId = sc.next(); 
                userDao.deleteUser(deleteUserId); 
                System.out.println("User deleted successfully.");
            	
            	break;
            	
                        
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;

        }
    }
}


