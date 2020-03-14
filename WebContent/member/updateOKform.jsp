<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc2.member.dao.MemberDao" %>
<%@ page import="com.mvc2.member.dao.MemberDaoImpl" %>
<%@ page import="com.mvc2.member.vo.MemberVO" %>
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
		<form id="udtform" name="udtform" method="post" enctype="application/x-www-form-urlencoded">
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
				$("#udtform").attr("action","/mvc2Project/member").submit();
			});
		</script>
<%	
	}
%>
		</form>
	</body>
</html>