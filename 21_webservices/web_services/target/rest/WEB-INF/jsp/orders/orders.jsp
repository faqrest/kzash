<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<t:general_template title="Orders Page">
	<jsp:attribute name="content_area">
        <form>
           <table style="width:80%">
           <caption><h2>List of orders</h2></caption>
                	<tr>
                      <th>Book</th>
                      <th>First name of user</th>
                      <th>Last name of user</th>
                      <th>Order date</th>
                	  <th>Expected return date</th>
                	  <th>Actual return date</th>
                	  <th>Order type</th>
                	  <th>Comment</th>
                	</tr>
        <c:forEach var="order" items="${orders}">
          <tr>
            <td><c:out value="${order.getBook().getName()}"/> </td>
            <td><c:out value="${order.getUser().getFirstName()}"/> </td>
            <td><c:out value="${order.getUser().getLastName()}"/> </td>
            <td><c:out value="${order.getOrderDate()}"/> </td>
            <td><c:out value="${order.getExpectedReturnDate()}"/> </td>
            <td><c:out value="${order.getActualReturnDate()}"/> </td>
            <td><c:out value="${order.getType().getTypeName()}"/> </td>
            <td><c:out value="${order.getComment()}"/> </td>
            
            <td id="buttons">
               <button class="btn-amazing" id="infoButton" name=<c:out value="${order.getOrdersId()}" />
                value=<c:out value="${order.getOrdersId()}"/> formaction="${'orders/' += order.ordersId}" formmethod="get">
                  detailed info
               </button>
           </td> 
           
          </tr>    
       </c:forEach>
           </table> 
           </form>
    </jsp:attribute>
</t:general_template>