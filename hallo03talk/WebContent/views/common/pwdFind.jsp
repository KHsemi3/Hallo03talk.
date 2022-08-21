<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%
 	String pwdFind = (String)session.getAttribute("pwdFind");
 %>
 
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- traveler, boss 비밀번호 찾기 -->
		
		
		<h1>비밀번호 찾기 화면 -- 프론트는 나중에 할 예정</h1>



	      <%if (pwdFind == null){%>
				일치하는 비밀번호가 없습니다. 
		 <%}else{%>
				<!-- 아이디 찾기 성공 -->
				당신의 비밀번호는 <%= pwdFind%> 입니다.
		 <%}%>
	 
</body>
</html>