<%@ taglib prefix="poll" tagdir="/WEB-INF/tags" %>
<poll:wrap title="Setup">
	<h1>QuickPoll</h1>
	<form method=post action=ask>
		<h2>${model.question}</h2>
		<input name=vote type=radio value=yes><label>Yes</label>
        <input name=vote type=radio value=no><label>No</label>
        <input type=submit name=submit value=Vote>
	</form>
</poll:wrap>