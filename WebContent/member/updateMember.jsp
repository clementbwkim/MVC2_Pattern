<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc2.member.dao.MemberDao" %>
<%@ page import="com.mvc2.member.dao.MemberDaoImpl" %>
<%@ page import="com.mvc2.member.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %>   
<%
	request.setCharacterEncoding("UTF-8");

	ArrayList<MemberVO> alist = new ArrayList<>();
	MemberVO mvo = new MemberVO();
	Object obj = request.getAttribute("alist");
	alist = (ArrayList)obj;
	int cnt = alist.size();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script type="text/javascript">
			function sample6_execDaumPostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
		                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var addr = ''; // 주소 변수
		                var extraAddr = ''; // 참고항목 변수
	
		                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
		                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
		                    addr = data.roadAddress;
		                } else { // 사용자가 지번 주소를 선택했을 경우(J)
		                    addr = data.jibunAddress;
		                }
	
		                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
		                if(data.userSelectedType === 'R'){
		                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
		                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
		                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                        extraAddr += data.bname;
		                    }
		                    // 건물명이 있고, 공동주택일 경우 추가한다.
		                    if(data.buildingName !== '' && data.apartment === 'Y'){
		                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                    }
		                } else {
		                    document.getElementById("kaddr1").value = '';
		                }
	
		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('kpostnum').value = data.zonecode;
		                document.getElementById("kaddr").value = addr;
		                // 커서를 상세주소 필드로 이동한다.
		                document.getElementById("kaddr1").focus();
		            }
		        }).open();
		    }
				
			$(function(){
			
				$("#kpwbtn").click(function(){
					var kpw = $("#kpw").val();
					var rkpw = $("#kpwchk").val();
					if(!kpw){
						alert("비밀번호를 입력하세요.");
						$("#kpw").focus();
						return false;
					}
					
					if(kpw == rkpw){
						alert("비밀번호가 일치합니다.");
						$("#kbirth").focus();
						kpwFlag = true;
					}else{
						alert("비밀번호가 일치하지 않습니다, 다시 입력하세요.");
						$("#kpw").focus('');
					}
				});
				
				$("#ubtn").click(function(){

					var kidFlag = false;
					var kpwFlag = false;
					
					if(kid == ""){
						alert("아이디를 입력해주세요..");
						$("#kid").focus();
						return;
					}
						
					if(kidFlag && kpwFlag){
						alert("(kidFlag && kpwFlag) >>> ");
					}	

					$("#isudType").val("UOK");
					alert($("#isudType").val());
					$("#udtform").attr("action", "/mvc2Project/member").submit();
				
				});
				
				$("#cbtn").click(function(){
					$("#isudType").val("S");
					$("#udtform").attr("action", "/mvc2Project/member").submit();
				});
			});
		</script>
	</head>
	<body>
		<form class="reg" name="udtform" id="udtform" method="post" enctype="multipart/form-data">
			 <table border="1">
<%
			for(int i =0; i < cnt; i++){
				mvo = alist.get(i);	
%>
			 	<tr>
			 		<th colspan="2" align="center">회원정보</th>
			 	</tr>
			 	<tr>
			 		<td width="100">회원번호</td>
			 		<td width="250">
			 			&nbsp;<input type="text" name="knum" id="knum" readonly="readonly" value="<%=mvo.getKnum()%>"><br>
			 			<font size="2">*수정/삭제/조회 시 회원번호 사용</font>
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>이름</td>
			 		<td>&nbsp;<input type="text" name="kname" id="kname" placeholder="이름을 입력해주세요." value="<%=mvo.getKname()%>"></td>
			 	</tr>
			 	<tr>
			 		<td>ID</td>
			 		<td>&nbsp;<input type="text" name="kid" id="kid" placeholder="특수문자는 포함되지 않습니다." readonly="readonly" value="<%=mvo.getKid() %>">
		 					  <input type="button" name="kidchk" id="kidchk" value="ID중복체크">
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>PASSWORD</td>
			 		<td>&nbsp;<input type="password" name="kpw" id="kpw" placeholder="8자리 이상 입력해주세요." <%=mvo.getKpw()%>></td>
			 	</tr>
			 	<tr>
			 		<td>PASSWORD CHECK</td>
			 		<td>
			 			<input type="password" name="kpwchk" id="kpwchk" placeholder="비밀번호를 한번더 입력하세요.">
			 			<input type="button" name="kpwbtn" id="kpwbtn" value="비밀번호확인">
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>생년월일</td>
			 		<td>&nbsp;<input type="text" name="kbirth" id="kbirth" placeholder="숫자만 입력해주세요." value="<%=mvo.getKbirth()%>"></td>
			 	</tr>
			 	<tr>
			 		<td>성별</td>
			 		<td>&nbsp;<input type="text" name="kgender" id="kgender" placeholder="M/F로 입력해주세요." value="<%=mvo.getKgender()%>"></td>
			 	</tr>
			 	<tr>
			 		<td>EMAIL</td>
			 		<td>&nbsp;<input type="text" name="kemail" id="kemail" placeholder="이메일주소를 입력해주세요." value="<%=mvo.getKemail()%>">@
			 				  <select name="eaddr" id="eaddr">
			 				  		<option>naver.com</option>
			 				  		<option>daum.net</option>
			 				  		<option>hotmail.com</option>
			 				  		<option>gmail.com</option>
			 				  		<option>직접입력</option>
			 				  </select>
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>연락처</td>
			 		<td>&nbsp;<input type="text" name="kmobile" id="kmobile" placeholder="-없이 입력해주세요." value="<%=mvo.getKmobile()%>"></td>
			 	</tr>
			 	<tr>
			 		<td>우편번호</td>
			 		<td>&nbsp;<input type="text" name="kpostnum" id="kpostnum" placeholder="우편 번호 5자리를 입력하세요." value="<%=mvo.getKpostnum()%>">
			 				  <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>주소</td>
			 		<td>&nbsp;<input type="text" name="kaddr" id="kaddr" placeholder="도로명 주소로 입력해주세요." value="<%=mvo.getKaddr()%>">
			 				  <input type="text" name="kaddr1" id="kaddr1" placeholder="상세주소" value="<%=mvo.getKaddr1()%>">
			 		</td>
			 	</tr>
			 	<tr>
			 		<td>사진</td>
			 		<td>&nbsp;<input type="file" name="kimg" id="kimg" size="20" value="<%=mvo.getKimg()%>"></td>
			 	</tr>
			 	<tr>
			 		<td>삭제여부</td>
			 		<td>&nbsp;<input type="text" name="kdeleteyn" id="kdeleteyn" disabled="disabled" value="<%=mvo.getKdeleteyn()%>"></td>
			 	</tr>
			 	<tr>
			 		<td>등록일</td>
			 		<td>&nbsp;<input type="text" name="kinsertdate" id="kinsertdate" disabled="disabled" value="<%=mvo.getKinsertdate()%>"></td>
			 	</tr>
			 	<tr>
			 		<td>수정일</td>
			 		<td>&nbsp;<input type="text" name="kupdatedate" id="kupdatedate" disabled="disabled" value="<%=mvo.getKupdatedate()%>"></td>
			 	</tr>
<%
			}
%>
			 	<tr>
			 		<td colspan="2">
			 		<input type="hidden" name="isudType" id="isudType">
			 		<input type="button" value="수정" name="ubtn" id="ubtn">
			 		<input type="button" value="취소" name="cbtn" id="cbtn">
			 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 		<input type="reset" value="다시">
			 		</td>
			 	</tr>
			 </table>
		</form>
	</body>
</html>