package com.Railway.dao;

import java.util.List;


import com.Railway.entity.Payment;
import com.Railway.entity.Reservation;

public interface PaymentDao {
	
	//Payment
    Payment createPayment(Payment payment); 
    Payment getPaymentById(String paymentId);
    void updatePayment(Payment payment);
    List<Payment> getAllPayments();
    void deletePayment(String paymentId);
    List<Payment> getPaymentsWithReservations();

}

    
