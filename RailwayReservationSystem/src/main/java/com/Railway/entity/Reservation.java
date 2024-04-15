package com.Railway.entity;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity

public class Reservation{ 
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_gen")
    @GenericGenerator(
        name = "reservation_gen", 
        strategy = "com.Railway.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RS_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
		@Column(name="ReservationId", length = 20)
	private String reservationId ;

	
	@Column(name ="ReservationDateTime",length = 20)
    private LocalDateTime reservationDateTime;

	@Column( name="SeatNumber",length = 50)
	private int seatNumber;
	
	@Column(name="Status", length = 50)
	private String status;
	
	
	
	//Many to Many Reservation to User(U) 
	@ManyToMany(cascade=CascadeType.ALL)
	private List<User> users;
	

	//Many to One Reservation to Train 
	@ManyToOne(cascade = CascadeType.ALL)
	private Train train;
	
	
	//One to One Reservation to Payment
    @OneToOne(cascade = CascadeType.ALL)
	private Payment payment;


	public String getReservationId() {
		return reservationId;
	}


	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}


	public LocalDateTime getReservationDateTime() {
		return reservationDateTime;
	}


	public void setReservationDateTime(LocalDateTime reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}


	public int getSeatNumber() {
		return seatNumber;
	}


	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Train getTrain() {
		return train;
	}


	public void setTrain(Train train) {
		this.train = train;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public Reservation(String reservationId, LocalDateTime reservationDateTime, int seatNumber, String status,
			List<User> users, Train train, Payment payment) {
		super();
		this.reservationId = reservationId;
		this.reservationDateTime = reservationDateTime;
		this.seatNumber = seatNumber;
		this.status = status;
		this.users = users;
		this.train = train;
		this.payment = payment;
	}


	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", reservationDateTime=" + reservationDateTime
				+ ", seatNumber=" + seatNumber + ", status=" + status + ", users=" + users + ", train="
				+ train + ", payment=" + payment + "]";
	}


	
  	

	

}


