package com.srs.model;

public class Previous_booking {
	
	private int BookId;
	private int Flight_id;
	private int price;
	private String classtype;
	private String Flight_Time;
	private String email;
	private String SourceName;
	private String DestinationName;
	private String DeptDate;
	private int NoAdults;
	private int NoChildren;
	
	
	public Previous_booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Previous_booking(int bookId, int flight_id, int price,
			String classtype, String flight_Time,
			String email, String sourceName, String destinationName,
			String deptDate, int noAdults, int noChildren) {
		super();
		BookId = bookId;
		Flight_id = flight_id;
		this.price = price;
		this.classtype = classtype;
		
		Flight_Time = flight_Time;
		this.email = email;
		SourceName = sourceName;
		DestinationName = destinationName;
		DeptDate = deptDate;
		NoAdults = noAdults;
		NoChildren = noChildren;
	}


	public int getBookId() {
		return BookId;
	}


	public void setBookId(int bookId) {
		BookId = bookId;
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

	public String getFlight_Time() {
		return Flight_Time;
	}


	public void setFlight_Time(String flight_Time) {
		Flight_Time = flight_Time;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSourceName() {
		return SourceName;
	}


	public void setSourceName(String sourceName) {
		SourceName = sourceName;
	}


	public String getDestinationName() {
		return DestinationName;
	}


	public void setDestinationName(String destinationName) {
		DestinationName = destinationName;
	}


	public String getDeptDate() {
		return DeptDate;
	}


	public void setDeptDate(String deptDate) {
		DeptDate = deptDate;
	}


	public int getNoAdults() {
		return NoAdults;
	}


	public void setNoAdults(int noAdults) {
		NoAdults = noAdults;
	}


	public int getNoChildren() {
		return NoChildren;
	}


	public void setNoChildren(int noChildren) {
		NoChildren = noChildren;
	}


	@Override
	public String toString() {
		return "Previous_booking [BookId=" + BookId + ", Flight_id="
				+ Flight_id + ", price=" + price + ", classtype=" + classtype
				+ ", Flight_Time="
				+ Flight_Time + ", email=" + email + ", SourceName="
				+ SourceName + ", DestinationName=" + DestinationName
				+ ", DeptDate=" + DeptDate + ", NoAdults=" + NoAdults
				+ ", NoChildren=" + NoChildren + "]";
	}
	

	
	
	
}
