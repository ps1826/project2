<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
function MemberCheck() {
	var check = '${check}';
	if(check == "true"){
	document.getElementById("m_id").value = "";
	}
	
	
	id = document.getElementById("m_id").value;
	if (id == "") {
		alert("아이디 입력부분이 비었거나, 아이디 중복체크를 하지 않았습니다.");
		document.getElementById("m_id").focus();
		return false;
	}
	
	name = document.getElementById("m_name").value;
	if (name == "") {
		alert("이름을 적어주세요.");
		document.getElementById("m_name").focus();
		return false;
	}
	
	password = document.getElementById("m_password").value;
	if (password == "") {
		alert("비밀번호를 적어주세요.");
		document.getElementById("m_password").focus();
		return false;
	}
	
	passwordcheck = document.getElementById("m_passwordcheck").value;
	if (passwordcheck == "") {
		alert("비밀번호 확인을 적어주세요.");
		document.getElementById("m_passwordcheck").focus();
		return false;
	} else if(passwordcheck != password){
		alert("비밀번호가 같지 않습니다.");
		document.getElementById("m_passwordcheck").focus();
		return false;
	}
	
	email = document.getElementById("email").value;
	atpos = email.indexOf("@");
	dotpos = email.indexOf(".");
	if (atpos < 1 || atpos+2 > dotpos || dotpos+2 > email.length) {
		alert("이메일을 작성 부분을 확인해 주세요. aa@aa.aa형식으로 작성되야 합니다.");
		document.getElementById("email").focus();
		return false;
	}
	
	phonenumber= document.getElementById("m_phonenumber").value;
	if (phonenumber == "") {
		alert("전화번호를 적어주세요.");
		document.getElementById("m_phonenumber").focus();
		return false;
	}
	
	address = document.getElementById("m_address").value;
	if (address == "") {
		alert("주소를 적어주세요.");
		document.getElementById("m_address").focus();
		return false;
	}
	mailcheck = document.getElementById("mailcheck").value;
	if (mailcheck  != "true") {
		alert("메일 인증이 필요합니다, 메일인증을 진행해주세요");
		document.getElementById("emailbut").focus();
		return false;
	}
	id = document.getElementById("id").value;
	m_id = document.getElementById("m_id").value;
	if (id != m_id) {
		alert("중복체크한 아이디가 아닙니다. 다시 확인해 주세요");
		document.getElementById("id").focus();
		return false;
	}
	mail = document.getElementById("email").value;
	m_email = document.getElementById("m_email").value;
	if (mail != m_email) {
		alert("인증받은 메일주소가 아닙니다. 다시 확인해 주세요");
		document.getElementById("email").focus();
		return false;
	}
	
	
}

function checkemail() {
	var email = document.userInfo.email.value;
	var url = 'emailchmove?email='+email;
	
	window.name = "memadd"
	window.open(url,"mailcheck","width=500, height=300, resizable=no,scrollbars=no")
/* 	document.getElementById("m_id").value = opener.document.userInfo.id.value */
}

function inputmail(){
	document.userInfo.idDuplication.value="email"
}

function checkId() {
	id = document.getElementById("id").value; 
	console.log(id);
	$.ajax({
		data : {id : id},
		url : 'idCheck',
		type : 'post',
		success : function(data) {
			console.log(data);
			if (data == 1) {
				$("#id_check").text("사용중인 아이디");
			} else if(data == 0){
				$("#id_check").text("사용가능 아이디");
			} 
		},error : function() {
			console.log("실패");
		}
		
	});
};

</script>
</head>
<body>
	
		<h1>회원가입</h1>
		<fieldset>
			<legend>회원가입</legend>
			<div style="color: red;"> * 위에 부터 순서대로 작성해 주세요 </div>
			<%-- <form action="./idcheck" method="post">
				<table>
				<tr>
				<td width="120">1. 아이디</td>
					<td><input type="text" name="id" id="id" value="${checkId}"></td>
					<td><button type="submit">중복체크</button></td>
					<c:choose>
						<c:when test="${check == false}"><td style="color: blue;">사용가능한 아이디입니다</td></c:when>
						<c:when test="${check == true}"><td style="color: red;">동일한 아이디가 존재합니다.</td></c:when>
						<c:when test="${nullid==1}"><td style="color: red;">아이디를 입력해주세요</td></c:when>
					</c:choose>
					</tr>
					</table>
				</form> --%>
				
				
			<form name="userInfo" action="./minsert" method="post">
				<%-- <input type="hidden" name="m_id" id="m_id" value="${checkId}"> --%>
				<table>
				<tr>
					<td>1. 아이디</td>
					<td><input type="text" name="id" id="id" oninput="checkId()">
					<span id="id_check"></span></td>
					<td></td>
				</tr>
				<tr>
					<td>2. 성명</td>
					<td><input type="text" name="m_name" id="m_name"></td>
					<td></td>
				</tr>
				<tr>
					<td>3. 비밀번호</td>
					<td><input type="text" name="m_password" id="m_password"></td>
					<td></td>
				</tr>
				<tr>
					<td>4. 비밀번호 체크</td>
					<td><input type="text" name="m_passwordcheck" id="m_passwordcheck"></td>
					<td></td>
				</tr>
				<tr>
					<td>5. 이메일</td>
					<td><input type="text" name="email" id="email" onkeydown="inputemail()" ></td>
					<td><input type="button" name="emailbut" id="emailbut"onclick="checkemail()" value="메일인증"></td>
					<td style="color: blue;"><output name="mailnoti" id="mailnoti"></output></td>
					<td><input type="hidden" id="mailcheck" name="mailcheck"></td>				
				</tr>
				<tr>
					<td>6. 핸드폰번호</td>
					<td><input type="text" name="m_phonenumber" id="m_phonenumber"></td>
					<td></td>
				</tr>

				<tr>
					<td>7. 주소</td>
					<td><input type="text" name="m_address" id="m_address"></td>
					<td></td>
				</tr>
			</table>
			<!-- <input type="hidden" id="mailcheck" name="mailcheck"> -->
			<input type="hidden" id="m_email" name="m_email">
		
					<input type="submit" value="회원가입" onclick="return MemberCheck()">
					<input type="button" onclick="location.href='./'" value="로그인 페이지">
			
		</form>
		
	</fieldset>
</body>
</html>