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
    <a href="save">保存</a><a href="read">读取</a>
    <form action="/find">
        名称:<input type="text" name="beyond" id="name"><button type="submit">查询</button>
    </form>

    <table>
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
        </tr>
        <c:forEach items="${goodsList}" var="goods">
            <tr>
                <td>${goods.id}</td>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td><a href="/edit?id=${goods.id}">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="/home?type=1&page=${page}">上一页</a></td>
            <td><a href="/home?type=2&page=${page}">下一页</a></td>
        </tr>
    </table>
</body>
</html>
