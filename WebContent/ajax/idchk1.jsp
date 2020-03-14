<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String kid = request.getParameter("kid");
	int idCnt = 0;
	boolean b = false;
	
	if(idCnt == 0){
		b = true;
	}
	

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<?xml version='1.0' encoding='UTF-8'?>
			<login>
				<result><%=b %></result>
			</login>
	</body>
</html>