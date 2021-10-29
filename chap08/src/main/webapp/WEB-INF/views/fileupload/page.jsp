<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>page.jsp</title>
</head>
<body>
    <h1>/WEB-INF/views/fileupload/page.jsp</h1>

    <hr>

    <form 
        action="/fileupload/doit" 
        method="POST" 
        enctype="multipart/form-data">

        <input type="text" name="name" value="Yoseph">
        <input type="text" name="age" value="23">

        <div>1. file1: <input type="file" name="files" multiple></div>

        <p>&nbsp;</p>

        <div><input type="submit" value="Upload"></div>
    </form>
</body>
</html>