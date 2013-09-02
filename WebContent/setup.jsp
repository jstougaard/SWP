<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>QuickPoll</title></head><body>
<h1>QuickPoll</h1>
<c:choose>
<c:when test="${question==null}">
	<form method=post action=setup>
	What is your question?<br>
	<input name=question type=text size=40>?<br>
	<input type=submit name=submit value="Register my question">
	</form>
</c:when>
<c:otherwise>
   	<p> Your question has been registered.</p> 
    <p>  Let the vote begin!</p>
</c:otherwise>
</c:choose>


</body></html>