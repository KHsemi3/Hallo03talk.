<%@page import="com.h3.traveler.vo.MpgReservationVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%

  	MpgReservationVo rvo = (MpgReservationVo)session.getAttribute("rvo");

  %>
     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>예약내역 상세조회 - 프론트는 나중에 작업 할 예정</h1>

예약 번호 : <%=rvo.getNo() %>
<br>
예약 날짜 : <%=rvo.getStartDate() %>
<br>
예약 만료 : <%=rvo.getEndDate() %>
<br>
장소명 : <%=rvo.getName() %>
<br>
주소 : <%=rvo.getAddress() %>
<br>
인원수 : <%=rvo.getHuman() %>

</body>
</html>