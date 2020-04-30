<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<p>new user</p>
<form:form action="registration.htm" commandName="user" method="post">
    <form:input path="firstName"/>
    <form:input path="lastName"/>
    <input type="submit" value="add user">
</form:form>
</body>
</html>
