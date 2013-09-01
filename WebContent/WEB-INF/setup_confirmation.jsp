<%@ taglib prefix="poll" tagdir="/WEB-INF/tags" %>
<poll:wrap title="Thank you">
	<h1>Quick Poll</h1>
	<h3>Your question has been registered</h3>
	<p><i>"${question}"</i></p>
	<br />
    <p><a href="ask">Let the polling begin!</a></p>
</poll:wrap>