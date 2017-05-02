<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true"%>
<%@attribute name="content_area" fragment="true"%>
<%@attribute name="sidebar_area" fragment="true"%>
<c:url value="/resources/css/style.css" var="css"/>
<c:url value="/resources/css/bootstrap.min.css" var="bootstrap"/>

<html>

<head>
  <script type="text/javascript" src=<c:url value="/resources/js/table.js"/>></script>
  <title>${title}</title>
   <meta name="description" content="website description" />
   <meta name="keywords" content="website keywords, website keywords" />
   <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
   <link href="${bootstrap}" rel="stylesheet" media="screen">
   <link href="${css}" rel="stylesheet" media="screen">
   <jsp:invoke fragment="head_area" />
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/general_menu.jsp" />
	
	<form class="user-form">
		<br>
		<button class="btn-amazing" type="submit" formaction=<c:url value="/logout"/>
			formmethod="get">Exit</button>
	</form>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
	<jsp:invoke fragment="content_area" />
</body>