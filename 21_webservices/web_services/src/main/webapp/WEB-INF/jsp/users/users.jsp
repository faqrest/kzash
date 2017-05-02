<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<t:general_template title="Users">
	<jsp:attribute name="content_area">
	<form class="signing-add">
        <button class="btn-amazing" type="submit" formaction=<c:url value="/user/new"/> formmethod="get">	 
        Add new user </button><br>
    </form>
        <form>
           <table style="width:80%">
              <caption><h2>List of users</h2></caption>
                	<tr>
                      <th>First name</th>
                      <th>Last name</th>
                      <th>Role</th>
                      <th>Reputation</th>
                	  <th>E-mail</th>
                      <th>Phone</th>
                	</tr>
        <c:forEach var="user" items="${users}">
         <c:if test="${user.getRole().getName() ne 'admin'}">
          <tr>
            <td><c:out value="${user.getFirstName()}"/> </td>
            <td><c:out value="${user.getLastName()}"/> </td>
            <td><c:out value="${user.getRole().getName()}"/> </td>
            <td><c:out value="${user.getReputation()}"/> </td>
            <td><c:out value="${user.geteMail()}"/> </td>
            <td><c:out value="${user.getPhone()}"/> </td>
            
            <td id="buttons">
               <button class="btn-amazing" id="deleteButton" name=<c:out value="${user.getUserId()}" />
                value=<c:out value="${user.geteMail()}"/> formaction="${'user/' += user.userId += '/delete'}" formmethod="post">
                  delete
               </button>
               <button class="btn-amazing" name=<c:out value="${user.getUserId()}"/> 
               value=<c:out value="${user.geteMail()}"/> formaction="${'user/' += user.userId += '/edit'}" formmethod="get">
                   edit
               </button>
           </td> 
           
          </tr> 
          </c:if>     
       </c:forEach>
           </table> 
           </form>
    </jsp:attribute>
</t:general_template>