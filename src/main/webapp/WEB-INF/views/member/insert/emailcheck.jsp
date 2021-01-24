<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

function emailcheck(){
email = document.getElementById("email").value;
atpos = email.indexOf("@");
dotpos = email.indexOf(".");
if (atpos < 1 || atpos+2 > dotpos || dotpos+2 > email.length) {
	alert("이메일을 적어주세요.");
	document.getElementById("email").focus();
	return false;
}
</script>
<body onload="email()">
<h2>이메일 인증</h2>
<form name="mcf" id="mcf" action="./email">
<input type="text" name="email" id="email" value="${mail}">
<input type="submit" value="인증 메일 발송" onclick="return emailcheck()">
</form>
<c:if test="${checknum != null}">
 <h2>인증메일 발송이 완료 되었습니다. </h2>
<form action="./email" method="post">
<input type="text" name="inputcheck" id="inputcheck">
<input type="hidden" name="email" id="email" value="${mail}">
<input type="hidden" name="checknum" id="checknum" value="${checknum}">

<input type="submit" value="메일인증 확인">
</form>
   </c:if>   
   
 <c:if test = "${mailcheck == true}" >
        <script>alert('인증이 완료 되었습니다.'); 
      var mail = document.getElementById("email").value;

      	opener.document.userInfo.mailcheck.value = true;
      	opener.document.userInfo.m_email.value = document.getElementById("email").value;
      	
      	opener.document.userInfo.mailnoti.value = "메일인증 완료!";

      	self.close();
      	</script>       
</c:if>
   	
<c:if test = "${mailcheck == false}" >
     <script>alert('인증번호가 틀립니다.'); 
      history.back();
      </script> 	
</c:if>        
	

</body>
</html>