<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:general_template title="Info about book">
   <jsp:attribute name="content_area">
       
		    <h2><c:out value="${book.getName()}"/></h2><br>
			<hr style="width:50%">
			<table border = "0" width="100%" cellpadding="0" class="info">
                     <tbody><tr height="50">
                           <td width="100%">Author:</td>
                           <td><c:out value="${book.getAuthor().getFirstName()}"/> 
                           <c:out value="${book.getAuthor().getLastName()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Genre:</td>
                           <td><c:out value="${book.getGenre().getName()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Average rate:</td>
                           <td><c:out value="${book.getAvarageRate()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Total count:</td>
                           <td><c:out value="${book.getTotalCount()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Current count: </td>
                           <td><c:out value="${book.getCurrentCount()}"/></td>
                        </tr>
                        <tr height="50">
                           <td>Language: </td>
                           <td><c:out value="${book.getLanguage().getLanguage()}"/></td>
                        </tr>
                        
          </tbody></table> 
             <h4>Description</h4><br>
             <hr style="width:50%">
             <table border = "0" width="100%" cellpadding="0" class="info">
                        <tr height="50">
                           <td>Description:</td>
                           <td><c:out value="${book.getDescription()}"/></td>
                        </tr>    
          </tbody></table> 
          
          <form class="signing-add">
                 <br><button class="btn-amazing" type="submit" formaction=<c:url value="/book"/> formmethod="get">
                       cancel
                     </button>
         </form>
   </jsp:attribute>
</t:general_template>