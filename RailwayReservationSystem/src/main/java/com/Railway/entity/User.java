package com.Railway.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.JoinColumn;


@Entity

public class User{ 
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @GenericGenerator(
        name = "user_gen", 
        strategy = "com.Railway.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "P_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	
	@Column(name="UserId", length = 20)
	private String userId;

	@Column(name = "FirstName",length = 30)
	private String firstName;

	@Column(name = "LastName",length = 30)
	private String lastName;

	@Column(name="Gender", length = 10)
	private String gender;

	@Column(name="Age", length = 50)
	private int age;
	
	@Column(name="MobieNo", length = 50)
	private double mobileno;
	
	@Column(name="City", length = 20)
	private String city;
	
	@Column(name="State", length = 20)
	private String state;
	
	
	//Many to Many User to Reservation -
	@ManyToMany(mappedBy="users",cascade = CascadeType.ALL)
	private List<Reservation> reservations;
	
	
	//Many to Many User to Train 
    @ManyToMany(mappedBy="users",cascade = CascadeType.ALL)
	private List<Train> trains;
    
    


	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getMobileNo() {
		return mobileno;
	}



	public void setMobileNo(double mobileno) {
		this.mobileno = mobileno;
	}
	
	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}


	public List<Reservation> getReservation() {
		return reservations;
	}



	public void setReservation(List<Reservation> reservation) {
		this.reservations = reservation;
	}



	public List<Train> getTrain() {
		return trains;
	}



	public void setTrain(List<Train> train) {
		this.trains = train;
	}



	public User(String userId, String firstName, String lastName, String gender, int age, double mobileno,String city,String state,
			List<Reservation> reservation, List<Train> train) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.mobileno = mobileno;
		this.city=city;
		this.state=state;
		this.reservations = reservation;
		this.trains = train;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", age=" + age + ",mobileno="+mobileno+", city=" + city + ",state="+state+", reservation=" + reservations
				+ ", train=" + trains + "]";
	}



	

	
		
	

}
