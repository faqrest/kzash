<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:general_template title="Edit user">
   <jsp:attribute name="content_area">
   <form class = "addUser"  action = <c:url value="/user/edit"/> method = "post">
		<caption><h1>Edit user</h1></caption><br>
		<br><input type = "hidden" name = "userId" value="${user.userId}"><br>
		<br><input type = "text" name = "firstName" value="${user.firstName}"><br>
		<br><input type = "text" name = "lastName" value="${user.lastName}"><br>
		<br><input type = "text" name = "name" value="${role.name}"><br>
		<br><input type = "text" name = "reputation" value="${user.reputation}"><br>
		<br><input type = "text" name = "eMail" value="${user.eMail}"><br>
		<br><input type="password" name = "password" value="${user.password}"><br>
		<br><input type = "text" name = "phone" value="${user.phone}"><br>
		<br><input type = "text" name = "document" list="documents"  value="${user.document}"><br><br>
			<datalist id="documents">
                 <option value="True">
                 <option value="False">
            </datalist>			
		<button class="submit" type="submit">Submit</button><br><br>
		</form> 
   </jsp:attribute>
</t:general_template>