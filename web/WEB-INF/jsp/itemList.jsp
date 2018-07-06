<%--
  Created by IntelliJ IDEA.
  User: WX
  Date: 2018/6/27
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>item</title>
</head>
<body>
<%--<c:when test="${itemsList!= null }">
    <c:forEach items="${itemsList }" var="item">
        ${item.name}
        ${item.price}
    </c:forEach>
</c:when>--%>
<c:forEach items="${itemsList }" var="item">
    <td>${item.name}</td>
    <td>${item.price}</td>
</c:forEach>

</body>
</html>


