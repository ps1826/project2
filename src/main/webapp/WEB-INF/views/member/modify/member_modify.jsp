<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/table.css">
<title>회원 정보 수정</title>
</head>
<body>

<fieldset>

<div style="float: right;">
&nbsp;<button type="button" value="button"onclick="location.href='./logout'">로그아웃</button>button>
	</div>
	<div style="float: right; margin-top: 2px">${m_id}님 환영 합니다.</div>
	<button name="main" onclick="location.href='./plist'" style="float: left; width: 70pt; height: 20pt; margin-right: 10px">상품 페이지</button> 
	<input type="button" value="내 장바구니" style="float: left; width: 70pt; height: 20pt; margin-right: 10px"onclick="location.href='.//basketList'">
	
</fieldset>
			

<form action="./mmodify" method="post">
<div align="center">
<h1> 회    원     정   보     수    정</h1>
	<table  border="1">
			<tr style="margin-top: 10px">
				<td colspan="2">&nbsp;${m_id}님의 회원정보</td>
			</tr>
			<tr>
				<td>&nbsp;PASSWORD</td>
				<td width="400"><input type="password" name="m_password"value="${modify.m_password}"></td>
			</tr>
			
			<tr>
				<td>&nbsp;NAME</td>
				<td width="400"><input type="text" style="width:290pt" name="m_name"  value="${modify.m_name}"></td>
			</tr>
			<tr>
				<td>&nbsp;E-MAIL</td>
				<td><input type="text" style="width:290pt" name="m_email" value="${modify.m_email}"></td>				
			</tr>
			<tr>
				<td>&nbsp;PhoneNumber</td>
				<td><input type="text" style="width:290pt" name="m_phonenumber" value="${modify.m_phonenumber}"></td>
				
			</tr>
			<tr>
				<td>&nbsp;Address</td>
				<td width="50"><input type="text" style="width:290pt" name="m_address" value="${modify.m_address}"></td>
				
			</tr>
	</table>
	<br/>
	</div>
	<div align="center">

	<button type="submit" value="button" style=" width: 70pt; height: 20pt; margin-right: 20px">수정 완료</button>
<!-- 	<button type="button" value="button" onclick="location.href='./mdelete'" style="width: 70pt; height: 20pt; margin-right: 20px">회원 탈퇴</button> -->
	</div>
	</form>
</body>
</html>