<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<t:general_template title="Books Page">
   <jsp:attribute name="content_area">
	  <form class="signing-add">
          <button class="btn-amazing" type="submit" formaction=<c:url value="/book/new"/> formmethod="get"> Add new book </button><br>
      </form>
      <form>
        <table style="width:80%">
        <caption><h2>List of books</h2></caption>
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
                      <button class="btn-amazing" id="deleteButton" name=<c:out value="${book.getId()}" /> value=<c:out value="${book.getId()}"/> formaction="${'book/' += book.id += '/delete'}" formmethod="post">
                      delete
                      </button>
                      <button class="btn-amazing" name=<c:out value="${book.getId()}"/> value=<c:out value="${book.getId()}"/> formaction="${'book/' += book.id += '/edit'}" formmethod="get">
                      edit
                      </button>
                  </td> 
           
             </tr>    
             </c:forEach>
          </table> 
      </form>
    </jsp:attribute>
</t:general_template>