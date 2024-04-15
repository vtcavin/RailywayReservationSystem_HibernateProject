package com.Railway.dao;

import java.util.List;

import com.Railway.entity.Ticket;
import com.Railway.entity.Station;


public interface TicketDao {
	
	//Ticket
    Ticket createTicket(Ticket ticket);

    Ticket getTicketById(String ticketId);
    void updateTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    void deleteTicket(String ticketId);

   
}
