<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>all users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="container">
<a href="/webMvc-day2/userReport.htm" class="btn btn-primary"><i class="fa fa-print">print</i></a>
<table class="table">
    <thead class="table table-dark">
    <tr>
        <td>firstName</td>
        <td>lastName</td>
        <td>salary</td>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty users}">
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.salary}</td>
            </tr>
        </c:forEach>

    </c:if>
    </tbody>

</table>
</body>
</html>
