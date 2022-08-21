<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 String idFind = (String)session.getAttribute("idFind");

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


		<!-- traveler, boss 아이디 찾기 -->
		
		
		<h1>아이디 찾기 화면 -- 프론트는 나중에 할 예정</h1>



      <%if (idFind == null){%>
			일치하는 아이디가 없습니다. 
	 <%}else{%>
			<!-- 아이디 찾기 성공 -->
			당신의 아이디는 <%= idFind%> 입니다.
	 <%}%>


</body>
</html>