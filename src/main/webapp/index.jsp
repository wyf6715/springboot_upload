<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/3/11
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<a>上传用这个</a>
<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    <input type="file" name="file"/><br>
    <input type="submit"/><br>
</form>
<a>下载用这个</a>
<a href="${pageContext.request.contextPath}/download">下载文件</a>

</body>
</html>
