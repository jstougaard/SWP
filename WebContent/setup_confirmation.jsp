<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>QuickPoll</title>
  </head>
  <body>
	<h1>Quick Poll</h1>
	<h3>Your question has been registered</h3>
	<p><i>"${question}"</i></p>
	<br />
    <p><a href="ask.action">Let the polling begin!</a></p>
  </body>
</html>