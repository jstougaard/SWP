<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>QuickPoll</title></head><body>
     <h1>QuickPoll</h1>
     <form method=post action=vote>
     <c:out value="${question}"/><p>
     <input name=vote type=radio value=yes> yes<br>
     <input name=vote type=radio value=no> no<p>
     <input type=submit name=submit value=Vote>
  </form>
</body></html>