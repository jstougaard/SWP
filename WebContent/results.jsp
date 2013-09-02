<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>QuickPoll</title></head><body>
	<h1>QuickPoll</h1>
  <c:out value="${question}"/>?
  <table border=0>
    <tr><td>Yes:<td><table><tr><td bgcolor=black height=20 width=<c:out value="${(300)*(yes/total)}"/>></table><td> yes
  	<tr><td>no:<td><table><tr><td bgcolor=black height=20 width=<c:out value="${(300)*(no/total)}"/>></table><td> no
  </table>
</body></html>