<%@page import="com.h3.traveler.vo.TravelerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	TravelerVo idFind = (TravelerVo)session.getAttribute("idFind");

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- traveler 아이디 찾기 -->


<h1>아이디 찾기 화면</h1>

당신의 아이디는 <%= idFind%> 입니다.


</body>
</html>