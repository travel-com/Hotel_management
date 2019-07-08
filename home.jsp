<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="travel.com.bo.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- search by name--%>
<form action="SearchByNameController" method="get">
<input type="text" name="searchName">
<input type="submit" name="search">
</form>


<%--for displaying logged in user name --%>
 <div id="header_login">
	      <%if(session.getAttribute("user_details")!=null){ %>
	          <%
	          User user =  (User)session.getAttribute("user_details");
	          %>
	          <h1><%=user.getName() %><br><%=user.getEmail() %></h1>
	 		<a href="LogoutControllerUrl">Logout</a>
	 	 <%}else{ %>	
	 		<a href="index.jsp">Login</a>
	 	 <%} %>	
	 </div>

<%--check availability --%>
<center>
	    <fieldset style="width: 50%;background-color: pink;">
	    
	   <form action="CheckAvailabilityController" method="post" >
	        <table>
	        <tr>
	<legend>BOOKING</legend>
		<td>room type:</td>
		<td><select name='RoomType'>
		<option value='#'>Select</option>
		<option value='acandsingle'>AC and single</option>
		<option value='acanddouble'>AC AND DOUBLE</option> 
		<option value='nonacandsingle'> NON AC AND SINGLE </option>
		<option value='nonacanddouble'>NON AC AND DOUBLE</option>
		
		</select></td>
	         <tr>
	          <td>select date from</td>
	           
	           <td><input type="date" name="arrival" ></td>
	         </tr>
	        
	          <tr>
	           <td>select date to</td>
	           
	           <td><input type="date" name="departure" ></td>
	         </tr>
	    
	           <td colspan="2" align="right">
	            <input type="submit" value="Availability"></td>
	            <a href="bookingform"> Book Now</a>
	         </tr>
	        </table>
	        
	   </form>
	    </fieldset>
	 
	</center>
	 
</body>
</html>