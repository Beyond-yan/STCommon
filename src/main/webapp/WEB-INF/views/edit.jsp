<%--
  Created by IntelliJ IDEA.
  User: 闫波
  Date: 2018/12/3 0003
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/update">
        <input type="hidden" name="id" value="${goods.id}">
        名称:<input type="text" name="name" value="${goods.name}">
        价格:<input type="text" name="price" value="${goods.price}">
        <button type="submit">修改</button>
    </form>


</body>
</html>
