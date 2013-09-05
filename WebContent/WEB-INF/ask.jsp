<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="poll" tagdir="/WEB-INF/tags" %>
<poll:wrap title="Ask">
	<h1>QuickPoll</h1>
	<form method=post>
		<h2>${model.question}</h2>
        <c:forEach var="item" items="${model.optionMap}">
        	<input name=vote type=radio id="rd_${item.key}" value="${item.key}"><label style="padding:1px 15px 1px 10px;" for="rd_${item.key}">${item.value}</label><br />
        </c:forEach>
        <input type=submit name=submit value=Vote>
	</form>
</poll:wrap>