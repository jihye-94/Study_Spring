<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1.jsp</title>
</head>
<body>
	
	<h1>/WEB-INF/views/1.jsp = <%= request.getRequestURI() %></h1>

	<p>name:  <%= request.getParameter("name") %> = ${param.name}</p>
	<p>age: <%= request.getParameter("age") %> = ${param.age}</p>
</body>
</html>