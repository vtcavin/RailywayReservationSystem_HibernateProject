package com.Railway;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.Railway.dao.PaymentDao;
import com.Railway.daoimpl.PaymentDaoImpl;
import com.Railway.entity.Ticket;
import com.Railway.entity.Train;
import com.Railway.entity.Payment;
import com.Railway.entity.Reservation;

public class PaymentOperation {
	
	//Payment
	
	static Scanner sc = new Scanner(System.in);

    static PaymentDao paymentDao = new PaymentDaoImpl();
    
    private static Payment paymentInputs() {
        sc.nextLine();
        
        System.out.println("Enter Payment ID: ");
        String paymentId = sc.nextLine();
        
        System.out.println("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
                  
        System.out.println("Enter Payment DateTime in the format yyyy-MM-dd HH:mm:ss :");
        String paymentDateTimeInput=sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime paymentDateTime = LocalDateTime.parse(paymentDateTimeInput, formatter);
        
        System.out.println("Enter Payment Method:");
        String paymentMethod = sc.nextLine();

        System.out.println("Enter Status:");
        String status = sc.nextLine();
        
        Reservation reservation= new Reservation();
        
       
		return new Payment(paymentId,amount, paymentDateTime, paymentMethod, status,reservation);

    }


	public static void paymentDetails() {
        
        System.out.println("1.Insert Payment Details");
		System.out.println("2.Get Payment details based on id");
		System.out.println("3.Update Payment Details");
		System.out.println("4.Get all Payment details");
		System.out.println("5.Delete Payment Details");
		System.out.println("6. Payment ORDERBY  Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	Payment  payment = paymentInputs();
            	Payment savedPayment = paymentDao.createPayment( payment);
               System.out.println("Payment "+savedPayment+" added successfully:");
           
                break;
                
            case 2:
            	
                
            
                
                System.out.println("Enter Payment ID:");
                String paymentId = sc.next(); 
                
                Payment paymentById = paymentDao.getPaymentById(paymentId); 
                if (paymentById != null) {
                    System.out.println("Payment details: " + paymentById);
                } else {
                    System.out.println("Payment not found.");
                }
            	
            	
            	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Payment ID to update:");
                String updatePaymentId = sc.next(); 
                
            
            	
                Payment paymentToUpdate = paymentDao.getPaymentById(updatePaymentId); 
                if (paymentToUpdate != null) {
                	
                  
                	
                	paymentToUpdate.setAmount(5000);
                	paymentToUpdate.setStatus("Failed");
                	paymentToUpdate.setPaymentMethod("Net Banking");
                	
                	
                	
                	paymentDao.updatePayment(paymentToUpdate); 
                    System.out.println("Payment updated successfully.");
                } else {
                    System.out.println("Payment not found.");
                }
            	
            	break;
            	
            	
            case 4:
            	
            	
            	List<Payment> payments = paymentDao.getAllPayments();
                
            	for (Payment a : payments) {
            	    System.out.println("Payment details:");
            	    System.out.println("Payment" + a.getPaymentId());
            	    System.out.println("Date and Time: " + a.getPaymentDateTime());
            	    System.out.println("Amount: " + a.getAmount());
            	    System.out.println("Payment Method" + a.getPaymentMethod());
            	    System.out.println("Status" + a.getStatus());
            	    System.out.println("-----------------------------------");

            	}
            	
            	
            	break;
            	
            case 5:
            	
            	
            	
            	System.out.println("Enter Payment ID to delete:");
                String deletePaymentId = sc.next();
                paymentDao.deletePayment(deletePaymentId); 
                System.out.println("Payment deleted successfully.");
            	
            	break;
            	
            	
            	
            case 6:
            	System.out.println("Payment ORDER BY:");
            	List<Payment> orderPayment= paymentDao.getAllPayments();
        		System.out.println("Payment | Amount  ");

            	for (Payment a : orderPayment) {
					System.out.println(a.getPaymentId()+" - "+ a.getAmount());    
				}
            	
            	break;    
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        }
        
    }
	
	


