package com.srs.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srs.model.FlightDetails;
import com.srs.model.Flight_Details_Table;
import com.srs.model.Previous_booking;
import com.srs.model.User;
import com.srs.model.UserLogin;


@Repository("users")
public class UserDaoImpl implements UserDao {
	
//	@Autowired
//	SessionFactory session;
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	
	 public JdbcTemplate getJdbcTemplate() {
	        return jdbcTemplate;
	    }
	 
	 
	 public String addUser(User users) {
		 
		 
		
	        String sql = "INSERT INTO SRSUser VALUES(? ,? ,? ,? ,?, ?, ?)";
	        int returnValue = getJdbcTemplate().update(
	                sql,
	                new Object[] { users.getFname(),users.getLname(), users.getCountry(),users.getEmail(),users.getMobileNo(),users.getUname(),users.getPassword() });
	       
	        if(1 == returnValue)
	        {
	        
	            return "User creation is SUCCESS";
	            
	        }
	        else
	            return "User creation is FAILURE";
	        
	    }
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public boolean validateUser(UserLogin userslogin) {
		 
		 
		 String sql2="select email,password from SRSUser where email=? and password=?";
		// System.out.println(sql2);
		 List<User> output = getJdbcTemplate().query(sql2,new BeanPropertyRowMapper(User.class),userslogin.getEmail(),userslogin.getPassword());
		//  System.out.println(output); 
		 // System.out.println(output.size());
		 if(output.size()==1){
			 return true;
		 }else
			 return false;
	 }
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public List<Flight_Details_Table> flightDetails(FlightDetails flightdetails){
		 
		  String sql3 = "select * from FlightDetail";
		  List<Flight_Details_Table> fliDetails2  = getJdbcTemplate().query(
	               sql3,
	              new BeanPropertyRowMapper(Flight_Details_Table.class));
		
		 
	        return fliDetails2;
		 
		 
	 }
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public List<Flight_Details_Table>  bookFlight(int str){
		 
		 String sql4 = "select * from FlightDetail where flight_id=?";
		  List<Flight_Details_Table> fliDetails3  = getJdbcTemplate().query(
	               sql4,
	              new BeanPropertyRowMapper(Flight_Details_Table.class),str);
		
		  return fliDetails3;
		 
	 }
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public String confirmFlight(HttpSession hs2){
		 String email=(String)hs2.getAttribute("email");
		 String SourceName=(String)hs2.getAttribute("SourceName");
		 String DestinationName=(String)hs2.getAttribute("DestinationName");
		 String DeptDate=(String)hs2.getAttribute("DeptDate");
		 int NoAdults=(Integer)hs2.getAttribute("NoAdults");
		 int NoChildren=(Integer)hs2.getAttribute("NoChildren");
		// String classtype=(String)hs2.getAttribute("classtype");
		 int FlightId=(Integer)hs2.getAttribute("FlightId");
		
			 String sql5 = "select * from FlightDetail where flight_id=?";
			  List<Flight_Details_Table> fliDetails3  = getJdbcTemplate().query(
		               sql5,
		              new BeanPropertyRowMapper(Flight_Details_Table.class),FlightId);
			  String flighttime=null;
			  int price=0;
			  String classtype=null;
		for(Flight_Details_Table s:fliDetails3){
		
			 flighttime=s.getFlight_Time();
			 price=s.getPrice();
			 classtype=s.getClasstype();
		}
	
		int book_id=(int)(Math.random()*1000000);
		  String sql6 = "INSERT INTO Previous_booking VALUES(? ,? ,? ,? ,?, ?, ?,?,?,?,?)";
	        int returnValue = getJdbcTemplate().update(
	                sql6,
	                new Object[] {book_id,FlightId,(price*NoAdults),classtype,flighttime,email,SourceName,DestinationName,DeptDate,NoAdults,NoChildren  });
	       
	        if(1 == returnValue)
	        {
	        	  String sql7 = "update flightdetail set seat_available=seat_available-? where flight_id=?";
	        	getJdbcTemplate().update(
		                sql7,
		                new Object[] { NoAdults,FlightId});
	        	
	            return "Added to History";
	            
	        }
	        else
	            return "Not Added"; 	
	 	}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public List<Previous_booking> viewHistory(Previous_booking prev_booking,HttpSession hs2){
		 String email=(String)hs2.getAttribute("email");
		 
		 String sql8 = "select * from Previous_booking where email=?";
		  List<Previous_booking> historyList  = getJdbcTemplate().query(
	               sql8,
	              new BeanPropertyRowMapper(Previous_booking.class),email);
		
		  return historyList ;
		 
		 
	 }
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public String CancelFlight(int BookId ,HttpSession hs2){
		 String email=(String)hs2.getAttribute("email");
		 String sql9 = "select * from Previous_booking where bookid=?";
		  List<Previous_booking> DeleteList  = getJdbcTemplate().query(
	               sql9,
	              new BeanPropertyRowMapper(Previous_booking.class),BookId);
		  int Flight_Id=0,NoAdults=0;
		  for(Previous_booking pb:DeleteList){
			   Flight_Id=pb.getFlight_id();
			   NoAdults=pb.getNoAdults();
		  }
		 String sql10 = "delete from previous_booking where bookid=? and email=?";
	        int returnValue = getJdbcTemplate().update(
	                sql10,
	                new Object[] { BookId,email });
	        
	       
	        if(1 == returnValue)
	        {
	        	  String sql11 = "update flightdetail set seat_available=seat_available+? where flight_id=?";
		        	getJdbcTemplate().update(
			                sql11,
			                new Object[] { NoAdults,Flight_Id});
		        	
	        	
	        	
	        	return "Flight Cancelled ";
	        }
	        else
		 
		 return " Flight not Cancelled ";
	 }
	 
	

}
