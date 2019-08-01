package travel.com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.com.bo.Guest;
import travel.com.bo.Availability;
import travel.com.dao.GuestDao;
import travel.com.dao.Factory.DaoFactory;
import travel.com.bo.*;
public class CheckAvailabilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
		String RoomType= request.getParameter("RoomType");
		Date arrivalDate=null;
		Date departureDate=null;
		try {
			
			arrivalDate= sdf.parse(request.getParameter("arrival"));
			departureDate= sdf.parse(request.getParameter("departure"));
		/*	System.out.println("checkavailabilitycontrooler:");
			 System.out.println();
			   System.out.println("arrivalDATE=  "+arrivalDate);*/
			   System.out.println("Departure="+departureDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GuestDao dao=DaoFactory.getGuestDaoOracle();
		List<Guest> listOfGuest=dao.getAllBookedByRoomType(RoomType);
		
		//creation of data structure
		List<travel.com.bo.Availability>[] listOfDates=null;
		listOfDates=new ArrayList[listOfGuest.size()];
		for(int i=0;i<listOfGuest.size();i++){
	    listOfDates[i]=new ArrayList<travel.com.bo.Availability>();
		}
		//creation of data structure
		
		
		//insertion of data to data structure
		int count=0;
		Map<Integer,Integer>map=new HashMap<Integer,Integer>();
		for(Guest guest:listOfGuest){
			Date departure=guest.getDepartureDate();
			Date arrival=guest.getArrivalDate();
			long roomno=guest.getRoomNo();
			if(!map.containsKey((int)roomno))
		{
				map.put((int)roomno,count);
				count++;
			}
			travel.com.bo.Availability avail=new travel.com.bo.Availability();
			avail.setArrival(arrival);
			avail.setDeparture(departure);
			avail.setRoomno(roomno);
			listOfDates[map.get((int)roomno)].add(avail);
        }
		//insertion of data to data structure
		
		for(int j=0;j<listOfDates.length;j++){
			System.out.println("jkkls="+listOfDates[j].size());
		}
		
		
		//calculation
		ArrayList<Integer>availableRoomNo=new ArrayList<Integer>();
		int n=listOfDates.length;
		for(int j=0;j<(n);j++){
			
			List<travel.com.bo.Availability>RoomWiseBooking=listOfDates[j];
			Collections.sort(RoomWiseBooking);
			//System.out.println("RoomWiseBooking size"+RoomWiseBooking.size());
		    ListIterator<travel.com.bo.Availability>ite=RoomWiseBooking.listIterator();
		   while(ite.hasNext()){
			travel.com.bo.Availability a= ite.next();
			//System.out.println("availability-"+a);
				if(arrivalDate.after(a.getDeparture())){
				travel.com.bo.Availability b=null;
				//System.out.println("AVAILABLE ROOM NO SIZE="+availableRoomNo.size());
				if(ite.hasNext()){
					b=ite.next();
	             if(departureDate.before(b.getArrival())){
						availableRoomNo.add((int)a.getRoomno());
						//System.out.println("AVAILABLE ROOM NO SIZE="+availableRoomNo.size());
						break;
										}
	             ite.previous();
				}else{	
					availableRoomNo.add((int)a.getRoomno());
					System.out.println("AVAILABLE ROOM NO SIZE="+availableRoomNo.size());
					break;
				}//end of else
			}//end of if
			
		}//end of for
}//end of outer for
		
for(int j=0;j<(n);j++){
List<travel.com.bo.Availability>RoomWiseBooking1=listOfDates[j];
			if(RoomWiseBooking1.size()>=1){
Collections.sort(RoomWiseBooking1);
			System.out.println("RoomWiseBooking size"+RoomWiseBooking1.size());
		    if((departureDate.before(RoomWiseBooking1.get(0).getArrival())) &&(arrivalDate.before(RoomWiseBooking1.get(0).getArrival()))){
		    	availableRoomNo.add((int)RoomWiseBooking1.get(0).getRoomno());
		    }
}
		 
}//end of outer for
			//calculation
	
		
		for(Integer data:availableRoomNo){
			System.out.println(data);
		}
		
		System.out.println("SIZE="+availableRoomNo.size());
		request.setAttribute("noOfRoom",availableRoomNo.size());
		if(request.getParameter("page").equalsIgnoreCase("booking_controller")==true){
			
			String roomsstr=request.getParameter("rooms");
			Integer requiredRooms=Integer.parseInt(roomsstr);
			if(requiredRooms<=availableRoomNo.size()){
			request.setAttribute("requiredRooms", requiredRooms);
			request.setAttribute("arrivalDate", arrivalDate);
			request.setAttribute("departureDate", departureDate);
			request.setAttribute("roomDetail",availableRoomNo);
			
			request.getRequestDispatcher("BookingForm.jsp").include(request, response);
			}else{
				request.setAttribute("msg", "not enough rooms");
				request.getRequestDispatcher("errormsgpage.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("home1.jsp").forward(request, response);
		}

	}
}