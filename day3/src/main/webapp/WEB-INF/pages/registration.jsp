<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        span.error {
            color: red;
            display: inline-block;
        }
    </style>
</head>
<body>
<div class="container">
    <form:form modelAttribute="user" method="post">
        <div class="from-row md-4">
            <label for="firstName"><spring:message code="user.firstName"/></label>
            <form:input path="firstName" cssClass="form-control" id="firstName"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div class="from-row">
            <label for="lastName"><spring:message code="user.lastName"/> </label>
            <form:input path="lastName" cssClass="form-control" id="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>

        <div>
            <label for="salary"><spring:message code="user.salary"/> </label>
            <form:input path="salary" cssClass="form-control" id="salary" type="number" min="0" step="0.01"/>
            <form:errors path="salary" cssClass="error"/>
        </div>
        <br>
        <input type="submit" value="add user">
    </form:form>

</div>
</body>
</html>
