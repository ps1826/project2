<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/table.css">
<title>마이페이지</title>
</head>
<body>

<fieldset>

<div style="float: right;">
	&nbsp;<button type="button" value="button"onclick="location.href='./logout'">로그아웃</button>
	</div>
	<div style="float: right; margin-top: 2px">${m_id}님 환영 합니다.</div>
	<button name="main" onclick="location.href='./plist'" style="float: left; width: 70pt; height: 20pt; margin-right: 10px">상품 페이지</button> 
	<input type="button" value="내 장바구니" style="float: left; width: 70pt; height: 20pt; margin-right: 10px" onclick="location.href='./basketList'">
</fieldset>
			
<div align="center">
<h1> 회    원     정    보 </h1>
	<table  border="1">

			<tr style="margin-top: 10px">
				<td colspan="2">&nbsp;${m_id}님의 회원정보</td>
			</tr>
			<tr>
				<td>&nbsp;NAME</td>
				<td width="400"><c:out value="${mypage.m_name}"></c:out></td>
			</tr>
			<tr>
				<td>&nbsp;E-MAIL</td>
				<td><c:out value="${mypage.m_email}"></c:out></td>
			</tr>
			<tr>
				<td>&nbsp;PhoneNumber</td>
				<td><c:out value="${mypage.m_phonenumber}"></c:out></td>
			</tr>
			<tr>
				<td>&nbsp;Address</td>
				<td width="50"><c:out value="${mypage.m_address}"></c:out></td>
			</tr>
	</table>
	<br/>
	</div>
	<div align="center">
	<button type="button" value="button" onclick="location.href='./mmodify'"  style=" width: 70pt; height: 20pt; margin-right: 20px">정보 수정</button>
	<button type="button" value="button" onclick="location.href='./mdelete'" style="width: 70pt; height: 20pt; margin-right: 20px">회원 탈퇴</button>

	</div>
</body>
</html>