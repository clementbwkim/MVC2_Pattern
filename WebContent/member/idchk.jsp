<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	int cnt = (int)request.getAttribute("cnt");

%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<?xml version="1.0" encoding="UTF-8" ?>
		<login>
			<number><%=cnt %></number>
		</login>
	</body>
</html>