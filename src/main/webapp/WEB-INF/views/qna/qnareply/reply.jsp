<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변 등록</title>
</head>
<body>
<div id="contentsArea">  
<section id="titlename">  
<h1> 답변 글 등록</h1>  
<p class="formSign">    
<strong class="require">필수</strong> 는 반드시 입력하여야 하는 항목입니다.  </p> 

<form action="./qreply" method="post" id="joinForm" name="qnaform" enctype="multipart/form-data">    
<fieldset>
<input type="hidden" name="num" value="<c:out value='${reply.num}'/>"/> 
<input type="hidden" name="answer_num" value="<c:out value='${reply.answer_num}'/>"/> 
<input type="hidden" name="answer_lev" value="<c:out value='${reply.answer_lev}'/>"/> 
<input type="hidden" name="answer_seq" value="<c:out value='${reply.answer_seq}'/>"/>      
<legend>답변 글 </legend>      
<p>        
<label for="name">글쓴이 <strong class="require">필수</strong></label>        
<input type="hidden" id="m_id" name="m_id" value="${m_id}">      
</p>      
<p>        
<label for="subject">제목</label> 
<input type="text" id="subject" name="subject" value="[답변]<c:out value= "${reply.subject}"/>">      
</p>      
<p>        
<label for="content">내용</label>        
<textarea name="content" cols="74" rows="15" >
[문의 내용] 
<c:out value="${reply.content}"/>
-----------------------------------------
     
     답변 드립니다.

</textarea>      
</p>
      <p>        
      <label for="filename">파일 수정</label>         
      <input type="file" id="filename" name="filename" />      
      </p>      

      <div class="btnJoinArea">        
      <button type="submit" class="btnOk">글 등록</button>        
      <button type="reset" class="btnCancel">취소</button> 
      <button type="button" value="button" onclick="location.href='./listAll'" class="btnOk">          목록        </button>      
      </div>    
      </fieldset>  
      </form>  
      </section>  
      </div> 
</body>
</html>