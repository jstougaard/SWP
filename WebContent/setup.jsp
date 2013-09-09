<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>QuickPoll</title>
  </head>
  <body>
	<h1>QuickPoll</h1>
	<s:form>
      <p>What is your question?</p>
      <s:textfield name="question" value="%{model.question}" size="40"/>
      <s:submit value="Save my question"/>
    </s:form>
	<br />
    <a href="ask.action">&lt; Back</a>
  </body>
</html>