<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweeter - strona główna</title>
</head>
<body>
<c:choose>
    <c:when test="${empty userID}">
        <button onClick="javascript:document.location.href='/user/login/'">Logowanie</button>
        <button onClick="javascript:document.location.href='/user/register/'">Rejestracja</button>
    </c:when>
    <c:otherwise>
        <button onClick="javascript:document.location.href='/user/logout/'">Wyloguj</button>
    </c:otherwise>
</c:choose>
</body>
</html>
