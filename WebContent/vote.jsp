<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QuickPoll</title>
</head>
<body>
	Thank you for your vote! You voted <h5>${model.getLatestVote()}</h5> on question: <h5>${model.getQuestion() }</h5>
	<form method=get action=results>
		<input type=submit name=seeResults value="Go to results">
	</form>
</body>
</html>