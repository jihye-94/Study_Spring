<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page.jsp</title>
</head>
<body>
    <h1>/WEB-INF/views/fileupload/page.jsp</h1>

    <form action="/fileupload/doit" method="post" enctype="multipart/form-data">
        <input type="text" name="name" value="jihye">
        <input type="text" name="age" value="28">
        <div>1. file1: <input type="file" name="files" multiple></div>
<input type="submit" value="Upload">
    </form>
</body>
</html>