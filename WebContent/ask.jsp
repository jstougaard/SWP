<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>QuickPoll</title>
  </head>
  <body>
    <h1>QuickPoll</h1>  
    <s:form>
      <h2><s:property value="model.question"/></h2>
      <s:radio name="vote" list="model.options"/>
      <s:submit value="Vote"/>
    </s:form>
  </body>
</html>
