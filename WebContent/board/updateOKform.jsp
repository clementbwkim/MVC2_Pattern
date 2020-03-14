<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc2.board.dao.BoardDao" %>
<%@ page import="com.mvc2.board.dao.BoardDaoImpl" %>
<%@ page import="com.mvc2.board.vo.BoardVO" %>
<%@ page import="java.util.ArrayList" %> 
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form id="udtOKform" name="udtOKform" method="post" enctype="application/x-www-form-urlencoded">
		<%
	request.getAttribute("UTF-8");
	Object obj = request.getAttribute("alist");
	if(obj != null){
%>
			<input type="hidden" id="isudType" name="isudType" >
			<script type="text/javascript">
			$(function(){
				alert("updateOKform >>>>");
				$("#isudType").val("S");
				alert("$('#isudType').val('S') >>>" + $('#isudType').val());
				$("#udtOKform").attr("action","/mvc2Project/board").submit();
			});
		</script>
<%	
	}
%>
		</form>
	</body>
</html>