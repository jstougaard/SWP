<%@ taglib prefix="poll" tagdir="/WEB-INF/tags" %>
<poll:wrap title="Setup">
	<h1>QuickPoll</h1>
	<form method=post>
		What is your question?<br />
		<input name=question type=text size=40><br />
		<input type=submit name=submit value="Register my question">
	</form>
	<br />
    <a href="ask">&lt; Back</a>
</poll:wrap>