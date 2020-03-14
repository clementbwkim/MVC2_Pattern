 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head> 
		<meta charset="UTF-8">
		<title>Index</title> 
		<style type="text/css">
			.log{ 
				text-align: center; 
			}
		</style>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js" ></script>
		<script> 
			$(function(){
				$("#regbtn").click(function(){
					$("#logform").attr("action", "/mvc2Project/member/signup.jsp").submit(); 
				});
				$("#logbtn").click(function(){
					$("#isudType").val("S");
					$("#logform").attr("action", "/mvc2Project/board").submit();
				});
			});
		</script>
	</head>
	<body>
		<form class="log" name="logform" id="logform" method="POST">
			<table border="1">
				<tr>
					<th colspan="2">Sign in</th>
				</tr>
				<tr>
					<td>ID</td>
					<td><input type="text" name="kid" id="kid"></td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="text" name="kpw" id="kpw"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" id="isudType" name="isudType">
						<input type="button" value="확인" name="logbtn" id="logbtn">
						<input type="reset" value="다시">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="회원가입" name="regbtn" id="regbtn">
					</td>
				</tr>
			</table>
		
		</form>
	</body>
</html>