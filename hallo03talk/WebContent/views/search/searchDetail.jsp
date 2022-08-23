<%@page import="com.h3.placeReview.vo.PlaceReviewVo"%>
<%@page import="com.h3.community.vo.CommVo"%>
<%@page import="com.h3.with.vo.WithVo"%>
<%@page import="com.h3.place.vo.PlaceVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ArrayList<PlaceVo> pvoList = (ArrayList<PlaceVo>)request.getAttribute("pvoList");
	ArrayList<CommVo> cvoList = (ArrayList<CommVo>)request.getAttribute("cvoList");
	ArrayList<PlaceReviewVo> rvoList = (ArrayList<PlaceReviewVo>)request.getAttribute("rvoList");
	System.out.println(pvoList);
	System.out.println(cvoList);
	System.out.println(rvoList);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
rel="stylesheet"
/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/hallo03talk/resources/js/searchDetail.js"></script>

</head>
<body>

    <%@ include file="/views/common/header.jsp"%>

    <main>
            <div id="container" class="container-xxl">

            <div class="inner">

            <br><br><br><br><br>
            <div class="text" style=" width: 50%; float: left;">
                <h1 style="margin-left: 60px;"><b>검색</b></h1>
            </div>
            <div style=" width: 45%; float: right; margin-top: 20px; margin-right: 60px;">
            </div>

            <br><br><br>

            <input type="searchbox" value="" style="width: 90%; height: 50px; border-radius: 10px; border: 1px solid gray; margin-left: 5%;">
            <br><br>
            <button type="button" class="btn btn-warning" style="float:right; margin-right: 65px; ">검색</button>
            <button type="button" class="btn btn-primary" style="float:left; margin-left: 65px; ">이전</button>
            <br><br><br><br><br>

            <h1 style="margin-left: 60px;  font-family: somi; font-size: 60px; font-weight: lighter;"><b>장소</b></h1>
            <br>
            <%for(int i = 0 ; i < pvoList.size(); i++){%>
            <div class="row">
                <div class="col-md-4 ">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title"><%= pvoList.get(i).getName() %></h5>
                          <h6 class="card-subtitle mb-2 text-muted"><%= pvoList.get(i).getAddress() %></h6>
                          <p class="card-text"><%= pvoList.get(i).getContent() %></p>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
            
            
            <br>
            
            <div style="text-align: right; margin-right: 60px;">
                <a href="" onclick="" id="load" style="text-decoration: none; color: gray;">더보기...</a>
            </div>
            
            <br>
            <hr style="width: 90%; margin: 0 auto;">
            <br><br>

            <h1 style="margin-left: 60px; font-family: somi; font-size: 60px; font-weight: lighter;"><b>후기</b></h1>
            <br>
            <%for(int i = 0 ; i < rvoList.size(); i++){%>
            <div class="row">
                <div class="col-md-4">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title"><%= rvoList.get(i).getTitle() %></h5>
                          <h6 class="card-subtitle mb-2 text-muted"><%= rvoList.get(i).getNo() %></h6>
                          <p class="card-text"><%= rvoList.get(i).getContent() %></p>
                        </div>
                    </div>
                </div>
                <%} %>
                
            </div>
            <br>
            <div style="text-align: right; margin-right: 60px; ">
                <a href="" onclick="" id="load" style="text-decoration: none; color: gray;">더보기...</a>
            </div>
            <br>
            <hr style="width: 90%; margin: 0 auto;">
            <br><br>

            <h1 style="margin-left: 60px; font-family: somi; font-size: 60px; font-weight: lighter;"><b>커뮤니티</b></h1>
            <br>
            <%for(int i = 0 ; i < cvoList.size(); i++){%>
            <div class="row">
                <div class="col-md-4">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title"><%= cvoList.get(i).getTitle() %></h5>
                          <h6 class="card-subtitle mb-2 text-muted"><%= cvoList.get(i).getWriter() %></h6>
                          <p class="card-text"><%= cvoList.get(i).getContent() %></p>
                        </div>
                    </div>
                </div>
                <%} %>
               
            </div>
            <br>
            <div style="text-align: right; margin-right: 60px;">
                <a href="" onclick="" id="load" style="text-decoration: none; color: gray;">더보기...</a>
            </div>
            <br>
            <hr style="width: 90%; margin: 0 auto;">
            <br><br><br>
        </div>


            

            </div>
    </main>


<footer></footer>
    



</body>
</html>