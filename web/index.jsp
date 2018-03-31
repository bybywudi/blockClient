<%--
  Created by IntelliJ IDEA.
  User: 白杨
  Date: 2018/3/28
  Time: 13:39
3333  To change this template use File | Settings | File Templates.
  http://39.106.194.129:8080/upfiles/block/blocks.xml
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>区块链</title>
  </head>
  <body>
  <body>
  ${message }
  <form action="${pageContext.request.contextPath }/BlockServlet" method="post">
    hash：<input class="inputtext" type="text" name="blockid" />
    user：<input class="inputtext" type="text" name="userid" />
    <input class="btn" type="submit" value="submit" />
  </form>
  </body>
  </body>
</html>
