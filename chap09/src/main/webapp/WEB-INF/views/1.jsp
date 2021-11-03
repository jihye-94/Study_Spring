<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1.jsp</title>
</head>
<body>

	<h1>/WEB-INF/views/1.jsp</h1>
	
	<hr/>
	
	<h2>1. name: <%= request.getParameter("name") %></h2>
	<h2>2. age: <%= request.getParameter("age") %></h2>
	
	<hr/>
	
	<h2>1. name: ${param.name}</h2>
	<h2>2. age: ${param.age}</h2>
	
</body>
</html>