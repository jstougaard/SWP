<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>QuickPoll</title>
  </head>
  <body>
	<h1>QuickPoll</h1>
	
	<h2>${model.question}</h2>
	<p>Total votes : ${model.total }</p>
    <table border=0>
		<s:iterator value="model.votes" id="vote">
			<tr>
				<td><s:property value="key" /></td>
				<td style="width:300px;background:#f1f1f1;"><div style="background:#2668BD;height:20px;width:${ (model.total==0 ? 0 : 300 * vote.value / model.total) }px"></div></td>
				<td><s:property value="value"/></td>
			</tr>
		</s:iterator>
    </table>
    <br />
    <a href="ask.action">&lt; Vote again</a> | <a href="setup.action">New question</a>
  </body>
</html>
