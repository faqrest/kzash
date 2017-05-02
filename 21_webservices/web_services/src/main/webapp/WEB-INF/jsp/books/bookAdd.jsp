<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:general_template>
 <jsp:attribute name="head_area" title="Edit book">
 </jsp:attribute>
 
   <jsp:attribute name="content_area">
   
	    <form class = "addUser" action = <c:url value="/book/new"/> method = "post"> 
		<caption><h4>New book</h4></caption><br>
			
		    <br><input type = "text" name = "name" placeholder="Name" value="${book.name}"><br>
		    <br><input type = "text" name = "firstName" placeholder="First name of Author" value="${author.firstName}"><br>
			<br><input type = "text" name = "lastName" placeholder="Last name of Author" value="${author.lastName}"><br>
			<br><input type = "text" name = "totalCount" placeholder="Total count" value="${book.totalCount}"><br>
			<br><input type = "text" name = "currentCount" placeholder="Current Count" value="${book.currentCount}"><br>
			<br><input type = "text" name = "shelfCode" placeholder="Shelf code" value="${place.shelfCode}"><br>
			<br><input type = "text" name = "readcount" placeholder="Read Count" value="${book.readCount}"><br>
			<br><input type = "text" name = "description" placeholder="Description" value="${book.description}"><br><br>
			
		      <button class="submit" type="submit">Submit</button><br>
			  
		</form>
   </jsp:attribute>
</t:general_template>