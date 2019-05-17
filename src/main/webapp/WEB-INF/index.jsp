<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2019/5/5
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello Word!</h1>
<div id="logbox">
</div>

请输入：<input maxlength="200" id="inputbox" class="inputbox" onkeypress="return onSendBoxEnter(event);" type="text" />
<input type="button" class="button" onclick="send(inputbox.value);" value="回车发送" />
<input onclick = "aaa()" type="button" value="点击"/>
</body>
<script type="text/javascript" src="resources/js/comet4j/comet4j.js"></script>
<script type="text/javascript" src="resources/js/comet4j/talk.js"></script>
<script>
    function aaa(){

        alert(1);
    }

</script>
</html>
