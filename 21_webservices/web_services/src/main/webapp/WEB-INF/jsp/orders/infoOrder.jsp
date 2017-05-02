<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:general_template title="Edit book">
   <jsp:attribute name="content_area">

		    <h4>Info about order</h4><br>
			<hr style="width:50%">
			<table border = "0" width="100%" cellpadding="0" class="info">
                     <tbody><tr height="50">
                           <td width="100%">Book's name:</td>
                           <td><c:out value="${order.getBook().getName()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>User's name:</td>
                           <td><c:out value="${order.getUser().getFirstName()}"/>
                            <c:out value="${order.getUser().getLastName()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Order's date:</td>
                           <td><c:out value="${order.getOrderDate()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Expected date of return:</td>
                           <td><c:out value="${order.getExpectedReturnDate()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Actual date of return:</td>
                           <td><c:out value="${order.getActualReturnDate()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Order's type: </td>
                           <td><c:out value="${order.getType().getTypeName()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Comment: </td>
                           <td><c:out value="${order.getComment()}"/></td>
                        </tr>
                        
          </tbody></table> 
             <h4>Info about address</h4><br>
             <hr style="width:50%">
             <table border = "0" width="100%" cellpadding="0" class="info">
                     <tbody><tr height="50">
                           <td width="100%">City</td>
                           <td><c:out value="${order.getUser().getAddress().getCity()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Street:</td>
                           <td><c:out value="${order.getUser().getAddress().getStreet()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Building:</td>
                           <td><c:out value="${order.getUser().getAddress().getBuilding()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Flat:</td>
                           <td><c:out value="${order.getUser().getAddress().getFlat()}"/></td>
                        </tr>    
          </tbody></table> 
          <form class="signing-add">
                 <br><button class="btn-amazing" type="submit" formaction=<c:url value="/orders"/> formmethod="get">
                       cancel
                     </button>
         </form>
   </jsp:attribute>
</t:general_template>