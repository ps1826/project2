<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna 수정</title>
</head>
<body>
<body>
<div id="contentsArea">  
<section id="titlename">  
<h1> 게시판 수정 </h1>  
<p class="formSign">  <strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.  </p> 
<form action="./qupdate" method="post" id="joinForm" name="modifyform" enctype="multipart/form-data">    
<fieldset>    
<legend> 게시판 수정 </legend>      
<input type="hidden" name="num" value="<c:out value='${olddate.num}'/>"/>      
<p>      <label for="m_id">이름 </label> ${olddate.m_id} </p>
<input type="hidden" name="m_id" value="${olddate.m_id}"/>  
  
 
<p> <label for="subject">제목 </label> 
<input type="text" id="subject" name="subject" value="<c:out value='${olddate.subject}'/>"/>      </p>      
<p>      <label for="content">내용</label> 
<textarea name="content" cols="74" rows="15"> <c:out value="${olddate.content}"/> </textarea>      </p>       
<c:if test="${!empty olddate.attached_file}">       
<p>      <label for="attached_file">파일 첨부</label><br/>  <c:out value="${olddate.attached_file}"/> &nbsp;&nbsp;&nbsp; 
<a href="./down?attached_file=${view.attached_file}"> 파일 다운 </a>
<input type="hidden" name="filename" value="<c:out value='${olddate.attached_file}'/>"/>      </p>        
</c:if>      
<p>      <label for="filename">파일 수정</label>       
<input type="file" id="filename" name="filename">      </p>     
 
 <div class="btnJoinArea">        
 <button type="submit" class="btnOk">수정</button>        
 <button type="reset" class="btnCancel">취소</button> 
<input type="button" onclick="location.href='./qlistAll'"  value = "리스트"/>     
 </div>    
 </fieldset>  
 </form>  
 </section>  
 </div> 
</body>
</html>