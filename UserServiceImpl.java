package com.srs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srs.dao.UserDao;
import com.srs.dao.UserDaoImpl;
import com.srs.model.FlightDetails;
import com.srs.model.Flight_Details_Table;
import com.srs.model.Previous_booking;
import com.srs.model.User;
import com.srs.model.UserLogin;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserDao userDao;
	
	public String addUser(User users)
	{
	//	UserDao userDao=new UserDaoImpl();
		return userDao.addUser(users);
		
	}
	public boolean validateUser(UserLogin userslogin)
	{
		return userDao.validateUser(userslogin);	
	}
	public List<Flight_Details_Table> flightDetails(FlightDetails flightdetails){
		return userDao.flightDetails(flightdetails);
	}
	public List<Flight_Details_Table>  bookFlight(int str){
		return userDao.bookFlight(str);
	}
	public String confirmFlight(HttpSession hs2){
		return userDao.confirmFlight(hs2);
	}
	public List<Previous_booking> viewHistory(Previous_booking prev_booking,HttpSession hs2){
		return userDao.viewHistory(prev_booking,hs2);
	}
	public String CancelFlight(int BookId ,HttpSession hs2){
		return userDao.CancelFlight(BookId,hs2);
	}

}
