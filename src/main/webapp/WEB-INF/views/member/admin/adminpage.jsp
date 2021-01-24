<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>

<div style="float: right;">
	&nbsp;<button type="button" value="button"onclick="location.href='./logout'">로그아웃</button>
	</div>
	<div style="float: right; margin-top: 2px">${m_id} 페이지 입니다.</div>

	
	<input type="button" value="MY PAGE" style="float: left; width: 70pt; height: 20pt; margin-right: 10px"  onclick="location.href='./mypage'"> 
	<input type="button" value="내 장바구니" style="float: left; width: 70pt; height: 20pt; margin-right: 10px" onclick="location.href='./basketList'">
	<input type="button" value="QnA 게시판" style="float: left; width: 70pt; height: 20pt; " onclick="location.href='./qlistAll'"> &nbsp;
	
</fieldset>
<br/>
<div align="center">
	<table border="1" style="text-align: center;">
	<tr>
<th width="150"> ID </th> <th>고객 성함</th> <th width="200">고객 메일 주소</th> <th>고객 핸드폰 번호</th> <th>고객 주소</th> <th>고객 관리</th> 
</tr>
		<c:forEach var="member" items="${memberlist}">
		<c:if test="${member.m_id != 'admin'}">
		<tr>
		<td>
		<c:out value="${member.m_id}"></c:out>
		</td>
		<td>
		<c:out value="${member.m_name}"></c:out>
		</td>

		<td>
		<c:out value="${member.m_email}"></c:out>
		</td>
		<td>
		<c:out value="${member.m_phonenumber}"></c:out>
		</td>
		<td>
		<c:out value="${member.m_address}"></c:out>
		</td>
		<td>
		<a href="./adminDelete?m_id=<c:out value="${member.m_id}"/>"> <button type="button"> 회원 삭제 </button> </a>
		</td>
		</tr>
		</c:if>
			</c:forEach>
			
	</table>
	</div>
</body>
</html>