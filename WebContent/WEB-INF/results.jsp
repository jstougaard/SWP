<%@ taglib prefix="poll" tagdir="/WEB-INF/tags" %>
<poll:wrap title="Setup">
	<h1>QuickPoll</h1>
	
	<h2>${model.question}</h2>
    <table border=0>
       <poll:resultrow count="${model.votes['yes']}" total="${model.total}">Yes</poll:resultrow>
       <poll:resultrow count="${model.votes['no']}" total="${model.total}">No</poll:resultrow>
    </table>
</poll:wrap>