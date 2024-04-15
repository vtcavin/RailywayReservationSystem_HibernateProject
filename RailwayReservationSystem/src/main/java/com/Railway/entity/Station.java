package com.Railway.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity

public class Station{ 
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "station_gen")
    @GenericGenerator(
        name = "station_gen", 
        strategy = "com.Railway.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "S_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
		@Column(name="StationId", length = 20)
	private String stationId;


	@Column(name = "StationName",length = 30)
	private String stationName;

	@Column(name="Hault", length = 10)
	private String hault;

	@Column(name="City", length = 20)
	private String city;
	
	
	
	
	//Many To One - Station to ticket
	@ManyToOne(cascade = CascadeType.ALL)
	private Ticket ticket;




	public String getStationId() {
		return stationId;
	}




	public void setStationId(String stationId) {
		this.stationId = stationId;
	}




	public String getStationName() {
		return stationName;
	}




	public void setStationName(String stationName) {
		this.stationName = stationName;
	}




	public String getHault() {
		return hault;
	}




	public void setHault(String hault) {
		this.hault = hault;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	




	public Ticket getTicket() {
		return ticket;
	}




	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}




	public Station(String stationId, String stationName, String hault, String city,
			Ticket ticket) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
		this.hault = hault;
		this.city = city;
		this.ticket = ticket;
	}




	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", stationName=" + stationName + ", hault=" + hault + ", city="
				+ city  + ", ticket=" + ticket + "]";
	}


	
	
	

		

		

	
	
	
	

}