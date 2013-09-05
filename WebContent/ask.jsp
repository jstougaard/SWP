<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>QuickPoll</title>
</head>
<body>
	<h1>QuickPoll</h1>
	Vote on the question: <br>
	<h2>${question}?</h2>
	<form method=post action=vote>
		<input name=vote type=radio value=yes> Fuck yeah!<br>
		<input name=vote type=radio value=no> Hell no!<br>
		<input type=submit name=submit value=vote>
	</form>
</body>
</html>