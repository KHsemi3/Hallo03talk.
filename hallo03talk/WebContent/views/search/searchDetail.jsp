<%@page import="com.h3.with.vo.WithVo"%>
<%@page import="com.h3.place.vo.PlaceVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	ArrayList<PlaceVo> pvoList = (ArrayList<PlaceVo>)request.getAttribute("pvoList");

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
                <h5 style="text-align: right; margin-right: 5px;">총 <b style="color: orange;">n</b>개의 검색 결과</h5>
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
            
           	<script>
				$(function(){
					$('.card').click(function(){
						//div class = card 클릭 되었을 때, 동작할 내용
						
						//글 번호 가져오기
						const num = $(this).children().eq(0).text();
						//해당 번호 이용해서 요청 보내기
						location.href='/hallo03talk/place/detail?num=' + num;
					});
				})
			</script>
            
            <br>
            
            <div style="text-align: right; margin-right: 60px;">
                <a href="" onclick="" style="text-decoration: none; color: gray;">더보기...</a>
            </div>
            
            <br>
            <hr style="width: 90%; margin: 0 auto;">
            <br><br>

            <h1 style="margin-left: 60px; font-family: somi; font-size: 60px; font-weight: lighter;"><b>후기</b></h1>
            <br>
            <div class="row">
                <div class="col-md-4">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title">글제목</h5>
                          <h6 class="card-subtitle mb-2 text-muted">작성자</h6>
                          <p class="card-text">어쩌구저쩌구 대충 내용이 들어간다는 소리......더보기...</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title">글제목</h5>
                          <h6 class="card-subtitle mb-2 text-muted">작성자</h6>
                          <p class="card-text">어쩌구저쩌구 대충 내용이 들어간다는 소리......더보기...</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title">글제목</h5>
                          <h6 class="card-subtitle mb-2 text-muted">작성자</h6>
                          <p class="card-text">어쩌구저쩌구 대충 내용이 들어간다는 소리......더보기...</p>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div style="text-align: right; margin-right: 60px; ">
                <a href="" onclick="" style="text-decoration: none; color: gray;">더보기...</a>
            </div>
            <br>
            <hr style="width: 90%; margin: 0 auto;">
            <br><br>

            <h1 style="margin-left: 60px; font-family: somi; font-size: 60px; font-weight: lighter;"><b>커뮤니티</b></h1>
            <br>
            <div class="row">
                <div class="col-md-4">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title">글제목</h5>
                          <h6 class="card-subtitle mb-2 text-muted">작성자</h6>
                          <p class="card-text">어쩌구저쩌구 대충 내용이 들어간다는 소리......더보기...</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title">글제목</h5>
                          <h6 class="card-subtitle mb-2 text-muted">작성자</h6>
                          <p class="card-text">어쩌구저쩌구 대충 내용이 들어간다는 소리......더보기...</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" onclick="" style="width: 18rem; float: none; margin:0 auto;">
                        <img src="/hallo03talk/resources/img/search_1.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                          <h5 class="card-title">글제목</h5>
                          <h6 class="card-subtitle mb-2 text-muted">작성자</h6>
                          <p class="card-text">어쩌구저쩌구 대충 내용이 들어간다는 소리......더보기...</p>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div style="text-align: right; margin-right: 60px;">
                <a href="" onclick="" style="text-decoration: none; color: gray;">더보기...</a>
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