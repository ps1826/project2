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
  <c:if test ="${delete == 1}" >
	     <script>
	     alert('장바구니 삭제 완료'); 
	     location.href='./basketList'
	     </script> 
             </c:if>
             
         <c:if test ="${goods_num != null}" >
	     <script>
	     alert('장바구니 추가 완료'); 
	     location.href="./pdetail?goods_num="+${goods_num};
	     </script> -
         </c:if>
</body>
</html>