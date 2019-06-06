<%@page import="travel.com.bo.Guest"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
List<Guest> listOfGuest=(List<Guest>)request.getAttribute("listOfGuest");
%>
<%for(Guest guest:listOfGuest){ %>

<table width="100%" border="1" style="text-align: center;">
	 <caption>Sharvani </caption>
	 <tr                 >
	   <th>Id</th><td><%=guest.getId() %></td>
	   </tr>
	   
	   <tr>
	   <th>Name</th><td><%=guest.getName() %></td>
	 
	   </tr>
	   
	   <tr>
	   <th>Room no</th>  <td><%=guest.getRoomNo() %></td>
	   </tr>
	   
	   <tr>
	    <th>mobile</th> <td><%=guest.getMobile() %></td>
	   </tr>
	   
	   <tr>
	    <th>email</th>   <td><%=guest.getEmail() %></td>
	   
	   </tr>
	    <tr>
	    <th>id</th>   <td><%=guest.getIdProof() %></td>
	   
	   </tr>
	   <tr>
	    <th>Date of arrival</th><td><%=guest.getArrivalDate() %></td>
	   
	   </tr>
	   <tr>
	    <th>Date of departure</th><td><%=guest.getDepartureDate() %></td>
	   
	   </tr>
	   
	   <tr>
	    <th>Address</th><td><%=guest.getAddress() %></td>
	   
	   </tr>
	  <%} %>
	</table>
</body>
</html>