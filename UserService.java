package com.srs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.srs.model.FlightDetails;
import com.srs.model.Flight_Details_Table;
import com.srs.model.Previous_booking;
import com.srs.model.User;
import com.srs.model.UserLogin;

public interface UserService {

	//public boolean saveOrUpdate(User users);
	 
	public String addUser(User users);
	
	public boolean validateUser(UserLogin userslogin);
	public List<Flight_Details_Table> flightDetails(FlightDetails flightdetails);
	public List<Flight_Details_Table>  bookFlight(int str);
	public String confirmFlight(HttpSession hs2);
	public List<Previous_booking> viewHistory(Previous_booking prev_booking,HttpSession hs2);
	public String CancelFlight(int BookId ,HttpSession hs2);
	
}
