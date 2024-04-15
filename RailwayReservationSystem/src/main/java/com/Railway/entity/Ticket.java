package com.Railway.entity;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity

public class Ticket{ 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_gen")
    @GenericGenerator(
        name = "ticket_gen", 
        strategy = "com.Railway.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "T_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	@Column(name="TicketId", length = 20)
	private String ticketId;


	@Column(name = "TicketName",length = 30)
	private String ticketname;

	@Column(name = "Train No",length = 30)
	private int trainno;

	@Column(name="TicketPrice", length = 20)
	private int ticketprice;

	@Column(name="PNRNo", length = 150)
	private int pnrNo;
	
	
	
	
	//One to Many Ticket to Station  
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Station> stations =new ArrayList<>();

		
		
   
	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketName() {
		return ticketname;
	}

	public void setTrainName(String ticketname) {
		this.ticketname = ticketname;
	}

	public int getTrainNo() {
		return trainno;
	}

	public void setTrainNo(int trainno) {
		this.trainno = trainno;
	}

	public int getTicketPrice() {
		return ticketprice;
	}

	public void setTicketPrice(int ticketprice) {
		this.ticketprice = ticketprice;
	}

	public int getPNRNo() {
		return pnrNo;
	}

	public void setPNRNo(int pnrno) {
		this.pnrNo = pnrno;
	}

	

	


	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public Ticket(String ticketId, String ticketname, int trainno, int ticketprice, int pnrNo, List<Station> stations) {
		super();
		this.ticketId = ticketId;
		this.ticketname = ticketname;
		this.trainno = trainno;
		this.ticketprice = ticketprice;
		this.pnrNo = pnrNo;
		this.stations = stations;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketname=" + ticketname + ", trainno="
				+ trainno + ", ticketprice=" + ticketprice + ", pnrNo=" + pnrNo
				+",stations="+stations+"]";
	}

		
    
    
   

	
	
}	
	
