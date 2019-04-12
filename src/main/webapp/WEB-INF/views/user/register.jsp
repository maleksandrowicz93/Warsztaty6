<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tweeter - registration</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
Rejestracja<br>
<form:form modelAttribute="user" method="post">
    Imię: <form:input path="firstName"/>
    <form:errors path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/>
    <form:errors path="lastName"/><br>>
    Email: <form:input path="email"/>
    <form:errors path="email"/><br>
    Password: <form:password path="password"/>
    <form:errors path="password"/><br>
    <input type="submit" value="Rejestracja">
</form:form>
</body>
</html>
