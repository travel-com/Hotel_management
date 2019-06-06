<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	    <fieldset style="width: 50%;background-color: pink;">
	    
	   <form action="add_dept_proccessor.jsp" method="post" >
	        <table>
	        <tr>
	<legend>BOOKING</legend>
		<td>room type:</td>
		<td><select name='dept'>
		<option value='#'>Select</option>
		<option value='10'>AC and single</option>
		<option value='20'>AC AND DOUBLE</option> 
		<option value='30'> NON AC AND SINGLE </option>
		<option value='40'>NON AC AND DOUBLE</option>
		
		</select></td>
	         <tr>
	          <td>select date from</td>
	           
	           <td><input type="date" name="dept_loc" ></td>
	         </tr>
	        
	          <tr>
	           <td>select date to</td>
	           
	           <td><input type="date" name="dept_loc" ></td>
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