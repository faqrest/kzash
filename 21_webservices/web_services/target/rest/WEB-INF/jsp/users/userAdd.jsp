<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:general_template title="Edit user">
   <jsp:attribute name="content_area">
	    <form class = "addUser" action = <c:url value="/user/new"/> method = "post"> 
		<caption><h4>New user</h4></caption><br>
		
		    <br><input type = "text" name = "firstName" placeholder="First Name" value="${user.firstName}"><br>
			<br><input type = "text" name = "lastName" placeholder="Last Name" value="${user.lastName}"><br>
			<br><input type = "text" name = "reputation" placeholder="Reputation"  value="${user.reputation}"><br>
		    <br><input type = "text" name = "eMail" placeholder="E-mail" value="${user.eMail}"><br>
			<br><input type="password" name = "password" placeholder="Password"  value="${user.password}"><br>
			<br><input type = "text" name = "phone" placeholder="Phone"  value="${user.phone}"><br>
			<br><input type = "text" name = "document" placeholder="Document" list="documents"  value="${user.document}"><br><br>
			<datalist id="documents">
                 <option value="True">
                 <option value="False">
            </datalist>			
			  <h4>Please, enter address of user</h4>
			<br><input type = "text" name = "region" placeholder="Region" value="${address.region}"><br>
			<br><input type = "text" name = "city" placeholder="City" value="${address.city}"><br>
		    <br><input type = "text" name = "street" placeholder="Street" value="${address.street}"><br>
		    <br><input type = "text" name = "building" placeholder="Building" value="${address.building}"><br>
			<br><input type = "text" name = "flat" placeholder="Flat" value="${address.flat}"><br>
			<br><input type = "text" name = "postalCode" placeholder="Postal code" value="${address.postalCode}"><br><br>
				
		      <button class="submit" type="submit">Submit</button><br><br>
			  
		</form>
   
   </jsp:attribute>
</t:general_template>