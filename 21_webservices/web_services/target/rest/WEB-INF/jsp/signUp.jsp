<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <html>
  <head>
  <title>Login</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" /> 
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" media="screen">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" media="screen">
    <meta http-equiv="content-type" content="text/html; charset=windows-1252" />		
  </head>
  <body>
	 <form class = "addUser" action = <c:url value="/signUp"/> method = "post"> 
     <caption><h4>Registration</h4></caption><br>
     
	      <br><input type = "text" name = "firstName" value="${user.firstName}"><br>
			<br><input type = "text" name = "lastName" value="${user.lastName}"><br>
			<br><input type = "text" name = "reputation" placeholder="Reputation"  value="${user.reputation}"><br>
		    <br><input type = "text" name = "eMail" value="${user.eMail}"><br>
			<br><input type="password" name = "password" placeholder="Password"  value="${user.password}"><br>
			<br><input type = "text" name = "phone" placeholder="Phone"  value="${user.phone}"><br>
			<br><input type = "text" name = "document" placeholder="Document" list="documents"  value="${user.document}"><br><br>
			<datalist id="documents">
                 <option value="True">
                 <option value="False">
            </datalist>	
            <br><input type = "text" name = "region" placeholder="Region" value="${address.region}"><br>
			<br><input type = "text" name = "city" placeholder="City" value="${address.city}"><br>
		    <br><input type = "text" name = "street" placeholder="Street" value="${address.street}"><br>
		    <br><input type = "text" name = "building" placeholder="Building" value="${address.building}"><br>
			<br><input type = "text" name = "flat" placeholder="Flat" value="${address.flat}"><br>
			<br><input type = "text" name = "postalCode" placeholder="Postal code" value="${address.postalCode}"><br><br>		
			
		      <button class="submit" type="submit">Submit</button><br><br>	  
		</form>
  </body>
</html>