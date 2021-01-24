<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>

<script type="text/javascript">
function add(){
	alert("장바구니에 추가되었습니다.");
}
</script>
</head>
<body>
<hr width="100%">
	<table>
		<tr>
			<td align="center">
				<a href="./plist"> 
					<img src="./resources/img/images.jpeg" width="250px" height="100px">
				</a>
			</td>
			</tr>
	</table>
	<hr width="100%">
	<table>
		<tr>
			<td><img src="./resources/img/${detail.image}" width="500px" height="500px"></td>
			<td>
			<table>
			<tr><td height="50px">상품명 : ${detail.goods_name}</td></tr>
			<tr><td height="50px">가격 : ${detail.price}원</td></tr>
			<tr><td height="50px">분류 : ${detail.category}</td></tr>
			<tr><td height="50px">에너지 등급 : ${detail.energy_efcnc}등급</td></tr>
			<tr><td height="50px">용량 : ${detail.liter}L</td></tr>
			</table>
			<div>
			
			<c:if test="${m_id eq 'admin'}">
			<button onclick="location.href='./pupdate?goods_num=${detail.goods_num}'">상품 수정</button>
			<button onclick="location.href='./pdelete?goods_num=${detail.goods_num}'">상품 삭제</button>
			</c:if>
			
			<form action="./basketAdd" method="post">
			<input type="hidden" name="goods_num" value="${detail.goods_num}">
			<input type="hidden" name="goods_name" value="${detail.goods_name}">
			<input type="hidden" name="price" value="${detail.price}">
			<input type="hidden" name="image" value="${detail.image}">
			<input type="hidden" name="m_id" value="${m_id}">
<%-- 	<input type="hidden" name="price_sum" value="${productListDetail.price_sum}"> --%>
			<select name="amount">
			<c:forEach begin="1" end="10" var="i">
			<option value="${i}"> ${i} </option>
			</c:forEach>
			</select>&nbsp;개
			<input type="submit" onclick="add()" value="장바구니 담기">
			</form>
	
			<button onclick="location.href='./plist'">메인화면</button>
			</div>
			</td>
		</tr>
	</table>
</body>
</html>