<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QuickPoll Results</title>
</head>
<body>
	<table border=0>
		<tr>
			<td>Hell yeah!
			<td>
				<table>
					<tr>
						<td bgcolor=black height=20
							width=${model.drawBarLength(model.getYesVotes(), model.getTotalVotes())}>
						<td>${model.getYesVotes() }
					<tr>
						<td bgcolor=black height=20
							width=${model.drawBarLength(model.getNoVotes(), model.getTotalVotes())}>
						<td>${model.getNoVotes()}
				</table>
	</table>
	
	<form action="/">
	<input type=submit name=newQ value="Post a new question">
	</form>
	<br>	
	<form method=get action=ask>
	<input type=submit name=newVote value="Place another vote">
	</form>

</body>
</html>