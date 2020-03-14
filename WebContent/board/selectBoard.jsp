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
	if(alist.size() > 0){
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글목록</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
		<script type="text/javascript">
		$(function(){
			$("#ibtn").click(function(){
				$("#slctform").attr("action","/mvc2Project/board/insertBoard.jsp").submit();
			});
			$("#ubtn").click(function(){
				$("#isudType").val("U");
				$("#slctform").attr("action","/mvc2Project/board").submit();
			});
			$("#dbtn").click(function(){
				$("#isudType").val("D");
				$("#slctform").attr("action","/mvc2Project/board").submit();
			});
		});
		
		</script>
	</head>
	<body>
		<form id="slctform" name="slctform" method="post" enctype="application/x-www-form-urlencoded">
			<table border="1">
				<thead>
					<tr>
						<td><input type="checkbox" name="checkall" ></td>
						<td>글번호</td>
						<td>제목</td>
						<td>이름</td>
						<td>비밀번호</td>
						<td>내용</td>
						<td>첨부파일</td>
						<td>등록일</td>
						<td>수정일</td>
					</tr>
				</thead>
				
				<tbody>
					<tr>
<%
				for(int i = 0; i < alist.size(); i++){
					bvo = alist.get(i);
%>
						<td><input type="checkbox" id="chkInKno" name="chkInKno" value="<%=bvo.getKno()%>"></td>
						<td><%=bvo.getKno() %></td>
						<td><%=bvo.getKtitle() %></td>
						<td><%=bvo.getKname() %></td>
						<td><%=bvo.getKpw() %></td>
						<td><%=bvo.getKcontent() %></td>
						<td><%=bvo.getKimg() %></td>
						<td><%=bvo.getKinsertdate() %></td>
						<td><%=bvo.getKupdatedate() %></td>
					</tr>
<%					
				}
		}
%>
					<tr>
						<td colspan="9">
							<input type="hidden" name="isudType" id="isudType">
							<input type="button" value="글쓰기" id="ibtn" name="ibtn">
							<input type="button" value="글수정" id="ubtn" name="ubtn">
							<input type="button" value="글삭제" id="dbtn" name="dbtn">
						</td>
					</tr>
				</tbody>
			</table>
		
		</form>
	</body>
</html>