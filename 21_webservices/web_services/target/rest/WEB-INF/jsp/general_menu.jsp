<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="/resources/css/style.css" var="css"/>
<c:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>

<head>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" /> 
  <link href="${bootstrap}" rel="stylesheet" media="screen">
  <link href="${css}" rel="stylesheet" media="screen"> 
</head>

<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal.authorities" var="authorities" />
      <c:forEach items="${authorities}" var="authority">
        <c:if test="${authority.authority == 'admin'}">
          <c:set var="highestAuthority" value="admin"/>
        </c:if>
        <c:if test="${authority.authority == 'librarian' && empty highestAuthority}">
          <c:set var="highestAuthority" value="librarian"/>
        </c:if>
      </c:forEach>
      
      <c:choose>       
        <%-- Admin menu --%>
        <c:when test="${highestAuthority == 'admin' || highestAuthority == 'librarian'}">
          <div class="container">
	      	<div class="row">	
			  <div class="col-md-12 head-block"></div>
			    <div class="col-md-12 top-menu">
				  <ul>
					  <li><a href="<c:url value="/user"/>">Users</a></li>
					  <li><a href="<c:url value="/book"/>">Books</a></li>
					  <li><a href="<c:url value="/orders"/>">Orders</a></li>
					  <li><a href="<c:url value="/home"/>">Home</a></li>
				  </ul>
		       </div>
		    </div>
	      </div><br>
        </c:when>
        
        <%-- User menu --%>
        <c:otherwise>
          <div class="container">
		    <div class="row">	
			  <div class="col-md-12 head-block"></div>
		    </div>
	      </div>
        </c:otherwise>
      </c:choose>
</sec:authorize>

