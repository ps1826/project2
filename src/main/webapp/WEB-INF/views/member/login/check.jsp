<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% request.setCharacterEncoding("utf-8"); %>
	<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if(id.equals("admin") && pass.equals("1234")){
		session.setAttribute("id",id);
		response.sendRedirect("index.jsp");
	}else if(id.equals("admin")){
		out.println("<script>alert('비밀번호가 틀렸습니다.'); history.back();</script>");
	}else if(pass.equals("1234")){
		out.println("<script>alert('아이디가 틀렸습니다.'); history.back();</script>");
	}else{
		out.println("<script>alert('아이디와 비밀번호가 틀렸습니다.'); history.back();</script>");
	}
		%> --%>
  <c:if test ="${VO.logincheck==1}" >
	  
	     <script>
	     alert('없는 아이디 입니다.'); 
	     history.back();
	     </script>
              
             </c:if> 
<c:if test = "${VO.logincheck==2}" >
          <script>alert('비밀번호가 틀렸습니다.'); 
          history.back();
          </script> 	
              
   </c:if>   		
   <c:if test = "${VO.logincheck==3}" >
  			<c:if test="${VO.m_id eq 'admin'}">
          				<script>
          				alert('관리자님 환영합니다.'); 
          				location.href='./plist'
          				</script>
			</c:if>
          				<script>
          				alert('환영합니다.'); 
          				location.href='./plist'
        	  			</script>
   </c:if>   	
	   <c:if test = "${delcheck==1}" >
          <script>alert('회원 탈퇴 완료'); 
          location.href='./'
          </script> 	
              
   </c:if>   	
   	   <c:if test = "${logout != null}" >
          <script>alert('로그아웃 하셨습니다.'); 
          location.href='./'
          </script> 	
              
   </c:if>   	
   <c:if test = "${join==1}" >
          <script>
          alert('회원가입을 축하합니다! \n확인을 누르시면 로그인 페이지로 이동합니다.'); 
          location.href='./'
          </script> 	
              
   </c:if>   
	

   
   
   
   
		
</body>
</html>