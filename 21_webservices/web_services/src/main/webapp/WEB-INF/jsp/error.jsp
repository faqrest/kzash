
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Error</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" /> 
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" media="screen">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" media="screen">
    <meta http-equiv="content-type" content="text/html; charset=windows-1252" />		
  </head>
  <body>
        <c:choose>
            <c:when test="${statusCode != '500'}">
               <form class="error">
		            <img height="150" src="<c:url value="/resources/style/images/error" />"/><br>
				     <h1>Error!</h1>
				     <h3>Exception message: ${message}</h3>
		       </form>
            </c:when>
            <c:otherwise>
            <form class="error">
		       <img height="150" src="<c:url value="/resources/style/images/error" />"/><br>
		       <h1>Error!</h1>
               <h3>Exception message: ${message}</h3>
            </form>
            </c:otherwise>
         </c:choose>
 </body>
</html>