<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test ="${updateidchelck==false}" >
	  
	     <script>
	     alert('작성자가 아니여 수정할 수 없습니다.'); 
	     history.back();
	     </script>
	         </c:if> 
<c:if test ="${deleteidchelck==false}" >
	  
	     <script>
	     alert('작성자가 아니여 삭제 불가능합니다.'); 
	     history.back();
	     </script>
	         </c:if> 
</body>
</html>