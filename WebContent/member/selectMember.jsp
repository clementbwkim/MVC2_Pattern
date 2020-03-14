<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc2.member.dao.MemberDao" %>
<%@ page import="com.mvc2.member.dao.MemberDaoImpl" %>
<%@ page import="com.mvc2.member.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %>   
<%
	MemberDao mdao = new MemberDaoImpl();
	ArrayList<MemberVO> alist = mdao.selectMember();
	Object obj = request.getAttribute("alist");
	
	
	alist = (ArrayList)obj;
	
	if(alist.size() > 0){
%>	    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원목록</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#ibtn").click(function(){
					$("#isudType").val("I");
					$("#mlistform").attr("action","/mvc2Project/member").submit();
				});
				$("#ubtn").click(function(){
					alert('U >>>>>');
					$("#isudType").val("U");
					alert('$("#isudType").val("U")' + $("#isudType").val())
					$("#mlistform").attr("action","/mvc2Project/member").submit();
				});
				$("#dbtn").click(function(){
					$("#isudType").val("D");
					$("#mlistform").attr("action","/mvc2Project/member").submit();
				});
				
				$("#bckbtn").click(function(){
					$("#mlistform").attr("action","/mvc2Project/index.jsp").submit();
				});
				
			});
		
		</script>
	</head>
		<body>
		<form id="mlistform" name="mlistform" enctype="application/x-www-form-urlencoded" method="post">
			<table border="1">
			<tr>
				<th colspan="14">회원정보</th>
			</tr>
			<tr>
				<td><input type="checkbox" name="checkall"></td>
				<td>회원번호</td>
				<td>이름</td>
				<td>ID</td>
				<td>생년월일</td>
				<td>성별</td>
				<td>EMAIL</td>
				<td>연락처</td>
				<td>우편번호</td>
				<td>주소</td>
				<td>삭제여부</td>
				<td>이미지</td>
				<td>등록일</td>
				<td>수정일</td>
			</tr>
	<%
		for(int i = 0; i < alist.size(); i++){
			MemberVO mvo = alist.get(i);
	%>
			<tr>
				<td><input type="checkbox" id="chkInKnum" name="chkInKnum" value="<%=mvo.getKnum()%>"></td>
				<td><%=mvo.getKnum() %></td>
				<td><%=mvo.getKname() %></td>
				<td><%=mvo.getKid() %></td>
				<td><%=mvo.getKbirth() %></td>
				<td><%=mvo.getKgender() %></td>
				<td><%=mvo.getKemail() %></td>
				<td><%=mvo.getKmobile() %></td>
				<td><%=mvo.getKpostnum() %></td>
				<td><%=mvo.getKaddr() %></td>
				<td><%=mvo.getKdeleteyn() %></td>
				<td><%=mvo.getKimg() %></td>
				<td><%=mvo.getKinsertdate() %></td>
				<td><%=mvo.getKupdatedate() %></td>
			</tr>
	<%	
		}
	}
	%>		<tr>
				<td colspan="14">
					<input type="hidden" id="isudType" name="isudType">
					<input type="button" id="ibtn" name="ibtn" value="등록">
					<input type="button" id="ubtn" name="ubtn" value="수정">
					<input type="button" id="dbtn" name="dbtn" value="삭제">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" id="bckbtn" name="bckbtn" value="처음으로">
				</td>
			</tr>
			</table>
		</form>
	</body>
	
</html>