<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2019/5/17
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件测试</title>
</head>
<body>
<form action="/upload/uploadOne" method="post" enctype="multipart/form-data">
    <label>上传图片</label>
    <input type="file" name="multipartFile"/>
    <input type="submit" value="上传"/>
</form>
<p>图片:</p>
<img src="${filename }"/>
</body>
</html>
