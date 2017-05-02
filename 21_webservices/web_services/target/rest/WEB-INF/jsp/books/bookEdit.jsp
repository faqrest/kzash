<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:general_template title="Edit book">
   <jsp:attribute name="content_area">
   <form class = "addUser" action = <c:url value="/book/edit" /> method = "post">
		<h1>Edit book</h1><br>
		<br><input type = "hidden" name="id" value=<c:out value="${book.id}"/>>
		Name:<br><textarea name="name" rows="1" cols="30"> <c:out value="${book.name}"/></textarea><br><br> 
		First name of Author:<br><textarea name="firstName" rows="1" cols="30"><c:out value="${author.firstName}"/></textarea><br><br>
		Last name of Author:<br><textarea name="lastName" rows="1" cols="30"><c:out value="${author.lastName}"/></textarea><br><br>
		Total count:<br><textarea name="totalCount" rows="1" cols="30"><c:out value="${book.getTotalCount()}"/></textarea><br><br>
		Current count:<br><textarea name="currentCount" rows="1" cols="30"><c:out value="${book.getCurrentCount()}"/></textarea><br><br>
		Shelf code:<br><textarea name="shelfCode" rows="1" cols="30"><c:out value="${place.getShelfCode()}"/></textarea><br><br>
		Read count:<br><textarea name="readCount" rows="1" cols="30"><c:out value="${book.getReadCount()}"/></textarea><br><br>
		Description:<br><textarea name="description" rows="1" cols="30"><c:out value="${book.getDescription()}"/></textarea><br><br>
		<button class="submit" type="submit">Submit</button><br><br>
		</form> 
   </jsp:attribute>
</t:general_template>