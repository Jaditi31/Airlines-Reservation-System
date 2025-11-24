
package com.srs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="SRSUser")
public class User {
	
	//@Column(name="FISTNAME")
	private String fname;
	//@Column(name="LASTNAME")
	private String lname;
	//@Column(name="COUNTRY")
	private String country;
	//@Column(name="COUNTRY")
	private String email;
	//@Column(name="MOBILENO")
	private Long mobileNo;
	//@Id
	//@Column(name="USERNAME")
	private String uname;
	//@Column(name="PASSWORD")
	private String password;
	
	
	public User() {
		super();
		
	}
	public User(String fname, String lname, String country, String email,
			Long mobileNo, String uname, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.country = country;
		this.email = email;
		this.mobileNo = mobileNo;
		this.uname = uname;
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return " " + email + " " + password ;
	}
	
	
	

}
