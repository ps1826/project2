<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna 리스트</title>
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
<br/>
<div id="infoArea" style="display: inline;">
<section class="search"> 
<form name="search" action="./qsearch" method="post"> 
<!-- <fieldset>  -->
<!-- <legend> 검색 </legend>  -->
<label for="keyword"></label> 
<select name="keyfield" class="b_search">
<option value="all" selected="selected">전체 검색</option> 
<option value="subject"<c:if test="${'subject' == keyfield}">selected="selected"</c:if>> 제목 </option> 
<option value="m_id"<c:if test="${'m_id' == keyfield}">selected="selected"</c:if>> 글쓴이 </option> 
<option value="content"<c:if test="${'content' == keyfield}">selected="selected"</c:if>> 내용 </option> 
</select> 
<input type="search" id="keyword" name="keyword" required="required" placeholder= "검색어 입력"> 
<button type="submit" style="margin-right: 10px;"> 검색 </button> 

<!-- </fieldset>  -->
</form> 
</section> 
</div>
<p class="allPost" > 전체 글: &nbsp; <strong><c:out value="${listcount}"/></strong>개 </p>
	<table style="text-align:center">
		<caption style="font-size: 1.5em; font-weight: bold; ">부서 전체 조회 화면</caption>
		<tr>
			<th scope="col" class="bbsNumber" width="150">글번호</th>
			<th scope="col" class="bbsTitle" width="150">작성자</th>
			<th scope="col" class="bbsAuthor" width="500">제목</th>
			<th scope="col" class="bbsAuthor" width="150">조회수</th>
			<th scope="col" class="bbsAuthor" width="150">첨부파일</th>
			<th scope="col" class="bbsAuthor" width="150">작성일</th>
		</tr>
		<c:forEach var="qna" items="${list}">
			<tbody>
				<tr>
					<td><c:out value="${qna.num}" /></td>
					<td><c:out value="${qna.m_id}" /></td>
					<td align=left>
					
					<c:if test="${!empty qna.answer_lev}">
					<c:forEach var="j" begin="0" end="${qna.answer_lev*2}" step="1">&nbsp;
					</c:forEach> </c:if>
					<a href="./qselect?num=<c:out value="${qna.num}" />">
							<c:out value="${qna.subject}" />
					</a></td>
					<td><c:out value="${qna.read_count}" /></td>
					<c:choose>
					<c:when test="${!empty qna.attached_file}"><td>O</td></c:when>
					<c:otherwise><td> </td></c:otherwise>
					</c:choose>
					<td><c:out value="${qna.write_date}" /></td>

				</tr>

			</tbody>
		</c:forEach>

	</table>
	
	<c:choose> 
	<c:when test="${page <= 1}"> [이전]&nbsp; </c:when> 
	<c:otherwise> <a href="./qlistAll?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;</c:otherwise> 
	</c:choose>
	 
	<c:forEach var="start" begin="${startpage}" end="${endpage}" step="1"> 
	<c:choose> 
	<c:when test="${start eq page}"> [<c:out value="${start}"/>] </c:when> 
	<c:otherwise> <a href="./qlistAll?page=<c:out value="${start}" />">[<c:out value= "${start}" />]</a>&nbsp;</c:otherwise> 
	</c:choose> 
	</c:forEach>
	 
	<c:choose> <c:when test="${page >= maxpage}">[다음] </c:when> 
	<c:otherwise> <a href="./qlistAll?page=<c:out value="${page+1}" />">[다음]</a> </c:otherwise> 
	</c:choose>
	<br/>
	<input type="button" onclick="location.href='./qinsert'" value="문의 글 작성" />

</body>
</html>