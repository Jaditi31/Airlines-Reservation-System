package com.srs.model;

public class Flight_Details_Table {
	
	
	
	private int Flight_id;
	private int price;
	private String classtype;
	private int Seat_Available;
	private String Flight_Time;
	public Flight_Details_Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight_Details_Table(int flight_id, int price, String classtype,
			int seat_Available, String flight_Time) {
		super();
		Flight_id = flight_id;
		this.price = price;
		this.classtype = classtype;
		Seat_Available = seat_Available;
		Flight_Time = flight_Time;
	}
	public int getFlight_id() {
		return Flight_id;
	}
	public void setFlight_id(int flight_id) {
		Flight_id = flight_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
	public int getSeat_Available() {
		return Seat_Available;
	}
	public void setSeat_Available(int seat_Available) {
		Seat_Available = seat_Available;
	}
	public String getFlight_Time() {
		return Flight_Time;
	}
	public void setFlight_Time(String flight_Time) {
		Flight_Time = flight_Time;
	}
	@Override
	public String toString() {
		return "Flight_Details_Table [Flight_id=" + Flight_id + ", price="
				+ price + ", classtype=" + classtype + ", Seat_Available="
				+ Seat_Available + ", Flight_Time=" + Flight_Time + "]";
	}
	
	

}
