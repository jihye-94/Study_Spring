<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>list.jsp</title>
</head>

<body>
	<h1>/WEB-INF/views/board/list.jsp</h1>
	
	<p>${list}</p> <!-- BoardController.list() <에서 model addattbu "list", << 얘 이름 따라감 -->
	
	<hr>
	<p><%= request.getParameter("result") %></p>
	<p>${param.result}</p><!-- 내장객체.전송파라메터명 -->
	
	
	<p>${result}</p>
</body>
</html>