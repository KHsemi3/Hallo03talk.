<%@page import="com.h3.with.vo.PageVo"%>
<%@page import="com.h3.with.vo.WithVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<WithVo> wvoList = (ArrayList<WithVo>) request.getAttribute("wvoList");

System.out.println(wvoList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

</style>

</head>
<body>

	<%@ include file="/views/common/header.jsp"%>

	<main>
		<div id="container" class="container-xxl">

			<div id="container-header">
				<h1 class="chi" style = "margin-left: 5%; margin-top : 30px">동행</h1>
				<h6 class="chi"style = "margin-left: 5%;">쉽고 빠르게 같이 동행할 여행친구 찾기</h6>
				    <br>
                    <input type="text" name="placeKeyword" class="placeSearch" value="" style="width: 90%; height: 50px; border-radius: 10px; border: 1px solid gray; margin-left: 5%;" placeholder="  검색어를 입력하세요.">
                    <br>
			</div>
			<hr style = "width: 90%; margin-left: 5%;">
			
			<div id="accordion" style="width: 90%; margin-left: 5%;">
			<%for(int i = 0 ; i < wvoList.size(); i++){%>
			  <div class="card">
			    <div class="card-header">
			      <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
			        <b><%= wvoList.get(i).getTitle() %></b> <h5><%= wvoList.get(i).getStart_date()%> ~ <%= wvoList.get(i).getEnd_date()%></h5>
			      </a>
			    </div>
			    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
			      <div class="card-body">
			        <%= wvoList.get(i).getContent() %>
			      </div>
			    </div>
			  </div>
			  <%} %>
			
			  <div class="card">
			    <div class="card-header">
			      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo">
			        제목이랑 날짜
			      </a>
			    </div>
			    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
			      <div class="card-body">
			        내용 텍스트만
			      </div>
			    </div>
			  </div>
			
			  <div class="card">
			    <div class="card-header">
			      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree">
			        제목이랑 날짜
			      </a>
			    </div>
			    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
			      <div class="card-body">
			        내용 텍스트만
			      </div>
			    </div>
			  </div>
			
			</div>

	</main>


	<footer></footer>

</body>
</html>