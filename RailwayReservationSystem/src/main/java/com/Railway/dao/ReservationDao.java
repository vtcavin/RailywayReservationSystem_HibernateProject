package com.Railway.dao;

import java.util.List;


import com.Railway.entity.Reservation;

public interface ReservationDao {
	
	//Reservation
    Reservation createReservation(Reservation reservation);
    Reservation getReservationById(String reservationId);
    void updateReservation(Reservation reservation);
    List<Reservation> getAllReservation();
    void deleteReservation(String reservationId);

}
