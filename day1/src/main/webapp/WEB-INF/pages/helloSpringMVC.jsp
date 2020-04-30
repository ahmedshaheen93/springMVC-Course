<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Spring MVC</title>
</head>
<body>
<H1>Spring WebMVC Course</H1>
<c:if test="${!empty msg}">
    <p>!{msg}</p>
</c:if>
</body>
</html>
