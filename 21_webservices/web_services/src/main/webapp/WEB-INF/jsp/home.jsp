<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:general_template title="Home Page">
    <jsp:attribute name="content_area">
        <h2>Welcome, Dear <c:out value="${user.getFirstName()}"/> <c:out value="${user.getLastName()}"/></h2><br>
        
        <form>  
           <table id="myTable" style="width:80%">
           <caption><h2>Books of our library</h2></caption>
                	<tr>
                      <th>Name</th>
                      <th>Author</th>
                      <th>Genre</th>
                      <th>Language</th>
                	  <th>Current count</th>
                	</tr>
        <c:forEach var="book" items="${books}">
          <tr>
            <td><c:out value="${book.getName()}"/> </td>
            <td><c:out value="${book.getAuthor().getLastName()}"/> </td>
            <td><c:out value="${book.getGenre().getName()}"/> </td>
            <td><c:out value="${book.getLanguage().getLanguage()}"/> </td>
            <td><c:out value="${book.getCurrentCount()}"/> </td>
            
            <td id="buttons">
               <button class="btn-amazing" id="infoButton" name=<c:out value="${book.getId()}"/>
                value=<c:out value="${book.getId()}"/> formaction="${'book/' += book.id}" formmethod="get">
                  detailed info
               </button>
           </td> 
           
          </tr>    
       </c:forEach>
           </table> 
           </form>  
    <script type="text/javascript">
        highlight("myTable", "clickedRow");
    </script>
    
    </jsp:attribute>
</t:general_template>