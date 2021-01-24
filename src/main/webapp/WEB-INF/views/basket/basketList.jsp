<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
</head>
<body>

<%-- <h1>장바구니 목록</h1>

<c:choose>

<c:when test="${empty basketList}">

<h1>장바구니에 상품이 없습니다.</h1>

</c:when>

<c:otherwise>

<table border="1">

<tr>
<th>상품 번호</th> <th>상품명</th> <th>수량</th> <th>사진</th> <th>가격</th> <th>합계</th>
</tr>

<c:forEach var="basketList" items="${basketList}">

<tr>

<td> ${basketList.goods_num} </td>

<td> <a href="./pdetail?goods_num=${basketList.goods_num}">
<c:out value="${basketList.goods_name}"/> </a> </td>

<td> ${basketList.amount} </td>
<td><img src="./resources/img/${basketList.image}" width="100px" height="100px"></td>
<td> ${basketList.price} </td>
<td> ${basketList.price_sum} </td>

<td>

<a href="./basketDelete?basketID=<c:out value="${basketList.basketID}"/>">          
	<button type="button"> 삭제 </button> </a>
</td> 

</tr>

</c:forEach>

<tr>


<td colspan="7" align="right">
금액 합계 : ${basketSumMoney}&nbsp;원

</td>

</tr>

</table>

<form action="./basketSumMoney" method="post">
금액 합계 : ${basketSumMoney}&nbsp;원
</form>

</c:otherwise>

</c:choose>

<br>

<table>
<tr>
<td colspan="6">
<c:choose>
<c:when test="${page <= 1}"> [이전]&nbsp; </c:when>
<c:otherwise>
<a href="./basketList?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;
</c:otherwise>
</c:choose>
<c:forEach var="start" begin="${startpage}" end="${endpage}" step="1">
<c:choose>
<c:when test="${start eq page}"> [<c:out value="${start}"/>]
</c:when>
<c:otherwise>
<a href="./basketList?page=<c:out value="${start}" />">[<c:out value="${start}" />]</a>&nbsp;
</c:otherwise>
</c:choose>
</c:forEach>
<c:choose>
<c:when test="${page >= maxpage}">[다음] </c:when>
<c:otherwise>
<a href="./basketList?page=<c:out value="${page+1}" />">[다음]</a>
</c:otherwise>
</c:choose>
</td>
</tr>
</table>

<br>

<input type="button" value="상품 목록" style="float: left; width: 70pt; height: 20pt; margin-right: 10px"  onclick="location.href='./plist'"> 
<input type="button" value="MY PAGE" style="float: left; width: 70pt; height: 20pt; margin-right: 10px"  onclick="location.href='./mypage'"> 


 --%>

<h1>장바구니 목록</h1>

<c:choose>

<c:when test="${empty basketList}">

<h1>장바구니에 상품이 없습니다.</h1>

</c:when>

<c:otherwise>

<table border="1">

<tr>
<th>상품 번호</th> <th>상품명</th> <th>수량</th> <th>사진</th> <th>가격</th> <th>합계</th>
</tr>
<c:set var="sum" value="0"/><!-- 넣은거 -->

<c:forEach var="basketList" items="${basketList}">

<tr>

<td> ${basketList.goods_num} </td>

<td> <a href="./pdetail?goods_num=${basketList.goods_num}">
<c:out value="${basketList.goods_name}"/> </a> </td>

<td> ${basketList.amount} </td>
<td><img src="./resources/img/${basketList.image}" width="100px" height="100px"></td>
<td> <fmt:formatNumber pattern="###,###,###" value="${basketList.price}" /> </td><!-- 넣은거 -->
<td> <fmt:formatNumber pattern="###,###,###" value="${basketList.price_sum}" /> </td><!-- 넣은거 -->




<td>

<a href="./basketDelete?basketID=<c:out value="${basketList.basketID}"/>">          
	<button type="button"> 삭제 </button> </a>
</td> 

</tr>
<c:set var="sum" value="${sum + (basketList.price * basketList.amount)}"/><!-- 넣은거 -->
</c:forEach>

<tr>


<td colspan="7" align="right">
금액 합계 : <fmt:formatNumber pattern="###,###,###" value="${sum}"/>&nbsp;원<!-- 넣은거 -->

</td>

</tr>

</table>

<%-- <form action="./basketSumMoney" method="post">
금액 합계 : ${basketSumMoney}&nbsp;원
</form> --%>

</c:otherwise>

</c:choose>

<br>

<table>
<tr>
<td colspan="6">
<c:choose>
<c:when test="${page <= 1}"> [이전]&nbsp; </c:when>
<c:otherwise>
<a href="./basketList?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;
</c:otherwise>
</c:choose>
<c:forEach var="start" begin="${startpage}" end="${endpage}" step="1">
<c:choose>
<c:when test="${start eq page}"> [<c:out value="${start}"/>]
</c:when>
<c:otherwise>
<a href="./basketList?page=<c:out value="${start}" />">[<c:out value="${start}" />]</a>&nbsp;
</c:otherwise>
</c:choose>
</c:forEach>
<c:choose>
<c:when test="${page >= maxpage}">[다음] </c:when>
<c:otherwise>
<a href="./basketList?page=<c:out value="${page+1}" />">[다음]</a>
</c:otherwise>
</c:choose>
</td>
</tr>
</table>

<br>

<input type="button" value="상품 목록" style="float: left; width: 70pt; height: 20pt; margin-right: 10px"  onclick="location.href='./plist'"> 
<input type="button" value="MY PAGE" style="float: left; width: 70pt; height: 20pt; margin-right: 10px"  onclick="location.href='./mypage'"> 

</body>
</html>