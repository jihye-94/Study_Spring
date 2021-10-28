<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>basic.jsp</title>
</head>
<body>
	
	<h1>/WEB-INF/views/basic.jsp = <%= request.getRequestURI() %></h1>
	<hr/>	
	<h2>계좌이체 성공여부: ${transfer}</h2>

<p>page: ${page}</p>
<p>sampleDTO: ${sampleDTO}</p>
	<p>name: ${sampleDTO.name}</p>
	<p>age: ${sampleDTO.age}</p>
</body>
</html>