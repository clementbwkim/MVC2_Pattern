<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc2.member.dao.MemberDao" %>
<%@ page import="com.mvc2.member.dao.MemberDaoImpl" %>
<%@ page import="com.mvc2.member.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %>   

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
	</head>
	<body>
		<form id="istform" name="istform" enctype="application/x-www-form-urlencoded" method="post">
	<%
	request.getAttribute("UTF-8");
	Object obj = request.getAttribute("alist");
	if(obj != null){
%>
			<input type="hidden" id="isudType" name="isudType" >
			<script type="text/javascript">
			$(function(){
				alert("insertOKform >>>>");
				$("#isudType").val("S");
				alert("$('#isudType').val('S') >>>" + $('#isudType').val());
				$("#istform").attr("action","/mvc2Project/member").submit();
			});
		</script>
<%	
	}
%>
		</form>
	</body>
</html>