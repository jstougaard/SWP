<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>QuickPoll</title>
  </head>
  <body>
	<h1>QuickPoll</h1>

	<h2>Thank you for voting</h2>
	<p>${message }</p>

    <p><s:a href="ask.action">Vote again</s:a> | <s:a href="results.action">View results</s:a></p>

    
  </body>
</html>