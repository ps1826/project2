<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna 등록</title>
</head>
<body>
<form action="./qinsert" method="post" enctype="multipart/form-data">
<div>
<input type="hidden" id="m_id" name="m_id" value="${m_id}">
</div>
<div>
<input type="text" id="subject" name="subject" required placeholder="제목">
</div>
<div>
<textarea id="content" name="content" cols="74" rows="15" required placeholder="내용">
</textarea>
</div>
<div>
</div>
<input type="file" name="filename" id="filename">
<br/>
<input type="submit" value="글등록"> 
<input type="button" onclick="location.href='./qlistAll'"  value = "리스트"/> 
</form>

</body>
</html>