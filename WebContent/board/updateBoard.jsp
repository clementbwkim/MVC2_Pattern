<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc2.board.dao.BoardDao" %>
<%@ page import="com.mvc2.board.dao.BoardDaoImpl" %>
<%@ page import="com.mvc2.board.vo.BoardVO" %>
<%@ page import="java.util.ArrayList" %> 
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<BoardVO> alist = new ArrayList<>();
	BoardVO bvo = new BoardVO();
	
	Object obj = request.getAttribute("alist");
	
	alist = (ArrayList)obj;
	int cnt = alist.size();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글수정</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
		<script type="text/javascript">
		$(function(){
			$("#udtn").click(function(){
				if($("#ktitle").val() == "") {
					alert("제목을 입력하세요");
					$('#ktitle').focus();
					return false;
				}
				if($("#kname").val() == "") {
					alert("이름을 입력하세요");
					$('#kname').focus();
					return false;
				}
				if($("#kpw").val() == "") {
					alert("비밀번호을 입력하세요");
					$('#kpw').focus();
					return false;
				}
				if($("#kcontent").val() == "") {
					alert("내용을 입력하세요");
					$('#kcontent').focus();
					return false;
				}
				
				$("#isudType").val("UOK");
				console.log($("#isudType").val());
				alert($("#isudType").val()); 
				$("#udtbrdform").attr("action","/mvc2Project/board").submit();
			});
			$("#cbtn").click(function(){
				$("#isudType").val("S");
				$("#udtbrdform").attr("action","/mvc2Project/board").submit();
			});
		});
	</script>
	<style type="text/css">
	.brdform{
			font-family: monospace;
	}
	.btns{
		text-align: center;
	}
	</style>
	</head>
	<body>
		<form class="brdform" name="udtbrdform" id="udtbrdform" method="post" enctype="multipart/form-data">
			<table border="1">
<%
			for(int i =0; i < cnt; i++){
				bvo = alist.get(i);	
%>
				<tr>
					<th colspan="2">글쓰기</th>
				</tr>
				<tr>
					<td>글번호</td>
					<td><input type="text" name="kno" id="kno" size="20" value="<%=bvo.getKno() %>" readonly></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="ktitle" id="ktitle" value="<%=bvo.getKtitle() %>" size="20" ></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="kname" id="kname" value="<%=bvo.getKname() %>" size="20" ></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="kpw" id="kpw" value="<%=bvo.getKpw() %>" size="20" ></td>
				</tr>
				<tr>
					<td>파일첨부</td>
					<td><input type="file" id="kimg" name="kimg" value="<%=bvo.getKimg() %>" size="20"></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><input type="text" name="kinsertdate" id="kinsertdate" size="20" value="<%=bvo.getKinsertdate() %>" disabled="disabled"></td>
				</tr>
				<tr>
					<td>수정일</td>
					<td><input type="text" name="kupdatedate" id="kupdatedate" value="<%=bvo.getKupdatedate() %>" size="20" disabled="disabled"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea type="text" name="kcontent" id="kcontent" value="<%=bvo.getKcontent() %>" rows="10" cols="40" ></textarea></td>
				</tr>
<%
			}
%>
				<tr>
					<td class="btns" colspan="2" align="center">
						<input type="hidden" name="isudType" id="isudType">
						<input type="button" id="udtn" name="udtn" value="수정">
						<input type="button" id="cbtn" name="cbtn" value="취소">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시">
					</td>
				</tr>
				
			</table>
				
		</form>
	</body>
</html>