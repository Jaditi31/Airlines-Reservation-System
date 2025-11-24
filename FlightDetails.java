package com.srs.model;

import java.sql.Time;

import oracle.sql.DATE;

public class FlightDetails {
	
	private String  classtype;
	private String SourceName;
	private String DestinationName;
	private String DeptDate;
	private String day;
	private String month;
	private String year;
	private int NoAdults;
	private int NoChildren;
	
	
	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public FlightDetails(String classtype, String sourceName,
			String destinationName, String deptDate, String day, String month,
			String year, int noAdults, int noChildren) {
		super();
		this.classtype = classtype;
		SourceName = sourceName;
		DestinationName = destinationName;
		DeptDate = deptDate;
		this.day = day;
		this.month = month;
		this.year = year;
		NoAdults = noAdults;
		NoChildren = noChildren;
	}




	public String getClasstype() {
		return classtype;
	}


	public void setClasstype(String classtype) {
		this.classtype = classtype;
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
	//	return DeptDate;
		return day+"-"+month+"-"+year;
	}


	public void setDeptDate(String deptDate) {
		DeptDate = deptDate;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
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
		return "FlightDetails [classtype=" + classtype + ", SourceName="
				+ SourceName + ", DestinationName=" + DestinationName
				+ ", DeptDate=" + DeptDate + ", NoAdults=" + NoAdults
				+ ", NoChildren=" + NoChildren + "]";
	}
	

}
