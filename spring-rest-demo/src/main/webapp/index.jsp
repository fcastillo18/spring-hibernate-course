<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring Rest demo</title>
</head>
<body>
	Spring REST demo
	<hr>
	
	<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
	<br><br>
	<a href="${pageContext.request.contextPath}/api/students">Get all Students</a>
	
</body>
</html>