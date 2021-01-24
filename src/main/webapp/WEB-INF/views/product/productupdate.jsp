<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>
	<h2>상품 수정</h2>
	<fieldset>
			<legend>상품 수정</legend>
	<form method="post" enctype="multipart/form-data">
		<input type="hidden" name="image" value="${update.image}">
		<table>
		<tr>
			<td>상품 이름</td> 
			<td><input type="text" name="goods_name" value="${update.goods_name}"></td>
		</tr>
		<tr>
			<td>가격</td> 
			<td><input type="text" name="price" value="${update.price}"></td>
		</tr>
		<tr>
			<td>이미지</td> 
			<td><input type="file" name="imagefile"></td>
		</tr>
		<tr>
			<td>분류</td> 
			<td><select name="category">
			<option value="${update.category}">${update.category}</option>
			<option value="일반형">일반형</option>
			<option value="양문형">양문형</option>
			<option value="4도어">4도어</option>
			<option value="정수기">정수기</option>
			<option value="김치">김치</option>
			<option value="기타">기타</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>에너지 등급</td>
			<td><input type="text" name="energy_efcnc" value="${update.energy_efcnc}"></td>
		</tr>
		<tr>
			<td>용량</td> 
			<td><input type="text" name="liter" value="${update.liter}"></td>
		</tr>
		</table>
		<div>
			<input type="submit" value="상품 수정"> 
			<input type="reset" value="취소">
		</div>
	</form>
	</fieldset>
</body>
</html>