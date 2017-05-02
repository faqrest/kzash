<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	<div class="container">
	  <c:if test="${param.error != null}">
        <h4 class="message">Wrong password or email.</h4>
      </c:if>
      <h4 class="message">${message}</h4>
		<form class="form-signin" action = "j_spring_security_check" method="Post">
			<h1 class="form-signin-heading text-muted">Sign in</h1><br>
			<input type="email" name = "username" class="form-control" placeholder="Username"><br>
			<input type="password" name = "password" class="form-control" placeholder="Password" required><br><br>		
			<button class="btn btn-lg btn-primary btn-block" type="submit" formaction="j_spring_security_check"> Sign in </button><br>
			<button class="btn btn-lg btn-primary btn-block" type="submit" formaction="<c:url value="/signUp"/>" formmethod="get"> Sign up </button><br>
		</form>
	</div>
  </body>
</html>