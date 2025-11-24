package com.srs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.srs.model.FlightDetails;
import com.srs.model.Flight_Details_Table;
import com.srs.model.Previous_booking;
import com.srs.model.User;
import com.srs.model.UserLogin;
import com.srs.service.UserService;
import com.srs.service.UserServiceImpl;

@Controller
public class SRS_controller1 {
		
		@Autowired
		public UserService userService;
		
		
		@RequestMapping(value="/home" ,method=RequestMethod.GET)
		public ModelAndView display0()
		{
			ModelAndView view=new ModelAndView("Login2");
			return view;
		}
		@RequestMapping(value="/LoginAgain" ,method=RequestMethod.GET)
		public ModelAndView display12()
		{
			ModelAndView view=new ModelAndView("Login");
			return view;
		}
		@RequestMapping(value="/Logout" ,method=RequestMethod.GET)
		public ModelAndView display123(HttpSession hs2)
		{
			hs2.invalidate();
			ModelAndView view=new ModelAndView("Login");
			return view;
		}
		@RequestMapping(value="/register" ,method=RequestMethod.GET)
		public ModelAndView display1()
		{
			ModelAndView view=new ModelAndView("Register");
			return view;
		}
		@RequestMapping(value="/Payment" ,method=RequestMethod.GET)
		public ModelAndView display236()
		{
			ModelAndView view=new ModelAndView("ConfirmSuccess");
			return view;
		}
		@RequestMapping(value="/Admin" ,method=RequestMethod.GET)
		public ModelAndView display10()
		{
			ModelAndView view=new ModelAndView("Admin Login");
			return view;
		}
		@RequestMapping(value="/registervalidate" ,method=RequestMethod.POST)
		public ModelAndView display1(@ModelAttribute("register") User users,HttpSession hs2)
		{
			
			hs2.setAttribute("Fname", users.getFname());
			hs2.setAttribute("Fname", users.getLname());
			hs2.setAttribute("email", users.getEmail());
			 userService.addUser(users); 
		
			ModelAndView view=new ModelAndView("RegisterSuccess");
			return view;
			
		}
		@RequestMapping(value="/loginvalidate" ,method=RequestMethod.POST)
		public ModelAndView display2(@ModelAttribute("login")UserLogin userslogin,HttpSession hs2)
		{
			hs2.setAttribute("email", userslogin.getEmail());
			
			if( userService.validateUser(userslogin))
			{
			ModelAndView view=new ModelAndView("Login2");
			return view;
			}
			else{
				ModelAndView view=new ModelAndView("LoginFail");
				return view;
			}
			
			
		}
		@RequestMapping(value="/adminvalidate" ,method=RequestMethod.POST)
		public ModelAndView display23(HttpServletRequest request,HttpSession hs2)
		{
			String username=request.getParameter("admin");
			String password=request.getParameter("password");
			if(username.equals("swapnil") && password.equals("12345")){
				ModelAndView view=new ModelAndView("AdminView");
				return view;
			}
			else{
				ModelAndView view=new ModelAndView("AdminFail");
				return view;
			}
			
		}
		@RequestMapping(value="/showflight" ,method=RequestMethod.GET)
		public ModelAndView display3(@ModelAttribute("showflight")FlightDetails flightdetails,HttpServletRequest request,HttpSession hs2)
		{
			List <Flight_Details_Table> flightdetails3=userService.flightDetails(flightdetails);
			
			hs2.setAttribute("SourceName", flightdetails.getSourceName());
			hs2.setAttribute("DestinationName", flightdetails.getDestinationName());
			hs2.setAttribute("DeptDate",flightdetails.getDeptDate());
			hs2.setAttribute("NoAdults",flightdetails.getNoAdults());
			hs2.setAttribute("NoChildren", flightdetails.getNoChildren());
			hs2.setAttribute("classtype", flightdetails.getClasstype());
			hs2.setAttribute("day", flightdetails.getDay());
			hs2.setAttribute("month", flightdetails.getMonth());
			hs2.setAttribute("year", flightdetails.getYear());
			ModelAndView view=new ModelAndView("FlightDetailsData");
			view.addObject("tabledata",flightdetails3);
		
			return view;
		}
		
		@RequestMapping(value="/bookflight" ,method=RequestMethod.GET)
		public ModelAndView display4(FlightDetails fld,HttpServletRequest request,HttpSession hs2)
		{
			
			String str=request.getParameter("flightId");
			
			fld.setSourceName((String)hs2.getAttribute("SourceName"));
			fld.setDestinationName((String)hs2.getAttribute("DestinationName"));
			fld.setDay((String)hs2.getAttribute("day"));
			fld.setMonth((String)hs2.getAttribute("month"));
			fld.setYear((String)hs2.getAttribute("year"));
			fld.setDeptDate((String)hs2.getAttribute("DeptDate"));
			fld.setNoAdults((Integer)hs2.getAttribute("NoAdults"));
			fld.setNoChildren((Integer)hs2.getAttribute("NoChildren"));
			fld.setClasstype((String)hs2.getAttribute("classtype"));
			int flight_Id=Integer.parseInt(str);
			hs2.setAttribute("FlightId",flight_Id );
			
			List<Flight_Details_Table> bookflight3=userService.bookFlight(flight_Id);
			
			ModelAndView view=new ModelAndView("BookFlight");
			view.addObject("bookdata",bookflight3);
			view.addObject("showflight2",fld);
			return view;
		}
		@RequestMapping(value="/confirmflight" ,method=RequestMethod.GET)
		public ModelAndView display5( UserLogin userslogin,FlightDetails fld,HttpServletRequest request,HttpSession hs2)
		{
			
			int str=(Integer)hs2.getAttribute("FlightId");
		//	System.out.println(str);
			userslogin.setEmail((String)hs2.getAttribute("email"));
			fld.setSourceName((String)hs2.getAttribute("SourceName"));
			fld.setDestinationName((String)hs2.getAttribute("DestinationName"));
			fld.setDeptDate((String)hs2.getAttribute("DeptDate"));
			fld.setNoAdults((Integer)hs2.getAttribute("NoAdults"));
			fld.setNoChildren((Integer)hs2.getAttribute("NoChildren"));
			fld.setClasstype((String)hs2.getAttribute("classtype"));
			hs2.setAttribute("flightId", str);
			 userService.confirmFlight(hs2); 
			
			ModelAndView view=new ModelAndView("PaymentSuccess");
			return view;
			
		}
		@RequestMapping(value="/showHistory" ,method=RequestMethod.GET)
		public ModelAndView display6(@ModelAttribute("viewHistory")Previous_booking prev_booking,UserLogin userslogin,HttpSession hs2)
		{
			userslogin.setEmail((String)hs2.getAttribute("email"));
			List <Previous_booking> historylist=userService.viewHistory(prev_booking,hs2);
			
			ModelAndView view=new ModelAndView("ShowHistory");
			view.addObject("history",historylist);
			return view;
		}
		@RequestMapping(value="/cancelflight" ,method=RequestMethod.GET)
		public ModelAndView display7(@ModelAttribute("cancelFlight")UserLogin userslogin,HttpServletRequest request,HttpSession hs2)
		{
			userslogin.setEmail((String)hs2.getAttribute("email"));
			String str=request.getParameter("BookId");
			int BookId=Integer.parseInt(str);
			userService.CancelFlight(BookId,hs2);
			ModelAndView view=new ModelAndView("CancelFlight");
			
			
			return view;
			
		}
		
	
}
