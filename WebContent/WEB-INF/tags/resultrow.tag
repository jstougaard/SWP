<%@ tag %>
<%@ attribute name="count" required="true" %>
<%@ attribute name="total" required="true" %>
<tr>
	<td><jsp:doBody/></td>
	<td style="width:300px"><div style="background:#666;height:20px;width:${ (total==0 ? 0 : 300 * count / total) }px"></div></td>
	<td>${count} / ${total}</td>
</tr>