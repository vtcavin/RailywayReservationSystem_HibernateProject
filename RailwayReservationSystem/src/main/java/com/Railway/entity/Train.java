package com.Railway.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity

public class Train{ 
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "train_gen")
    @GenericGenerator(
        name = "train_gen", 
        strategy = "com.Railway.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TR_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
		@Column(name="TrainId", length = 20)
	private String trainId;


	@Column(name = "TrainName",length = 30)
	private String trainName;

	@Column(name = "Capacity",length = 30)
	private int capacity;

	@Column(name="Destination", length = 30)
	private String destination;

	@Column(name="Description", length = 30)
	private String description;
	
	@Column(name ="DepartureDateTime",length = 20)
    private LocalDateTime departureDateTime;
	
	@Column(name ="ArrivalDateTime",length = 20)
    private LocalDateTime arrivalDateTime;


	//One to Many - Train to Reservation -
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
    
    /*
	//Many to One - Train to Ticket 
	@ManyToOne(cascade=CascadeType.ALL)
	private Ticket ticket;
   */
	
	
	//Many to Many - Train to User(R) 
	@ManyToMany( cascade = CascadeType.ALL)
	 private List<User> users = new ArrayList<>();   

    
  
	public String getTrainId() {
		return trainId;
	}


	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}


	
	public String getTrainName() {
		return trainName;
	}


	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	

	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}


	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}


	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}


	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}



	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Train(String trainId, String trainName,int capacity, String destination, String description, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
			List<User> userss, List<Reservation> reservations) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.capacity=capacity;
		this.destination=destination;
		this.description=description;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.users = users;
		this.reservations = reservations;
		
	}


	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainName=" + trainName + ",capacity="+capacity+",destination="+destination+",description="+description+", departureDateTime="
				+ departureDateTime + ", arrivalDateTime=" + arrivalDateTime + ", users=" + users + ", reservations=" + reservations + "]";
	}


	
	

	

}
