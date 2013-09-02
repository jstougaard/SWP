<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="poll" tagdir="/WEB-INF/tags" %>
<poll:wrap title="Results">
	<h1>QuickPoll</h1>
	
	<c:if test="${param.success!=null}">
	 <p style="border:1px solid #999;background:#f1f1f1;padding:5px;">Your vote has been registered. See results below.</p>
	</c:if>
	
	<h2>${model.question}</h2>
    <table border=0>
		<c:forEach var="item" items="${model.optionMap}">
        	<poll:resultrow count="${model.getVotes( item.key ) }" total="${model.total }">${item.value}</poll:resultrow>
        </c:forEach>
    </table>
    <br />
    <a href="ask">&lt; Back</a>
</poll:wrap>
