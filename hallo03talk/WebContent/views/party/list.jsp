<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 안내</title>
 <link rel="stylesheet" href="/hallo03talk/views/party/partyCss/all.css">
</head>

<body>


			<%@ include file="/views/common/header.jsp"%>

			<main>
					<div id="container" class="container-xxl">
					<div class="board_wrap">
            <div class="board_title">
                <strong>이벤트 소식</strong>
                <P>제주도에서만 즐길 수 있는 축제 및 가게들의 행사를 안내해드립니다!</P>
            </div> 
            <div class="list_wrap">
                <div class="board_list">
                    <div class="top">
                        <div class="num" name=num>번호</div>
                        <div class="title" name=title>제목</div>
                        <div class="writer" name=writer>작성자</div>
                        <div class="date" name=date>작성일</div>
                        <div class="count" name=count>조회</div>
                    </div>  
                    <div>
                        <div class="num">5</div>
                        <div class="title"><a href="content.jsp">글 제목을 입력하세요.</a></div>
                        <div class="writer">박찬규</div>
                        <div class="date">2022.8.25</div>
                        <div class="count">17</div>
                    </div>
                    <div>
                        <div class="num">4</div>
                        <div class="title"><a href="content.jsp">글 제목을 입력하세요.</a></div>
                        <div class="writer">민동언</div>
                        <div class="date">2022.8.13</div>
                        <div class="count">17</div>
                    </div>
                    <div>
                        <div class="num">3</div>
                        <div class="title"><a href="content.jsp">글 제목을 입력하세요.</a></div>
                        <div class="writer">박서영</div>
                        <div class="date">2022.7.28</div>
                        <div class="count">17</div>
                    </div>
                    <div>
                        <div class="num">2</div>
                        <div class="title"><a href="content.jsp">글 제목을 입력하세요.</a></div>
                        <div class="writer">유시영</div>
                        <div class="date">2022.7.19</div>
                        <div class="count">17</div>
                    </div>
                    <div>
                        <div class="num">1</div>
                        <div class="title"><a href="content.jsp">글 제목을 입력하세요.</a></div>
                        <div class="writer">오준혁</div>
                        <div class="date">2022.7.17</div>
                        <div class="count">17</div>
                    </div>
                </div>
                <div class="board_page">
                    <a href="#" class="bt first"><<</a>
                    <a href="#" class="bt prev"><</a>
                    <a href="#" class="num on">1</a>
                    <a href="#" class="num">2</a>
                    <a href="#" class="num">3</a>
                    <a href="#" class="num">4</a>
                    <a href="#" class="num">5</a>
                    <a href="#" class="bt next">></a>
                    <a href="#" class="bt last">>></a>
                </div>
                <div class="bt_wrap">
                    <a href="write.jsp" class="on">등록</a>
                </div>
            </div>
        </div>

					

					</div>
			</main>


	<footer></footer>


</body>
</html>