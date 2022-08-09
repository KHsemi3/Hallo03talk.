<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a {
	text-decoration: none;
}

#head-img {
	box-sizing: border-box;
	margin-top: 12px;
	width: 100%;
	height: 300px;
	background-size: cover;
}

#content {
	margin-left: auto;
	margin-right: auto;
	width: 800px;
	padding: 1rem;
}

#content-heder-left {
	width: 75%;
	height: 100%;
}

#content-heder-rigth {
	width: 30%;
	height: 100%;
}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>

	<main>
		<div id="container" class="container-xxl">

			<div id="wraper">
				<div id="head-img">
					<img src="/hallo03talk/resources/img/with/with_detail_img2.jpg" width="100%" height="100%">
				</div>
				<div id="content">
					<div id="content-header" class="d-flex">
						<div id="content-heder-left">
							<a href="with_bord.html" style="color: orange;" class="h6">동행</a>
							<h3>제주도 같이 돌아보실분 모집!!</h3>
							<div>
								<img src="/hallo03talk/resources/img/with/with_board_defaultMan.png" width="24px"
									height="24px"> <span style="color: gray;">chan0966</span>
							</div>

						</div>
						<div id="content-header-right"
							class="d-flex flex-column justify-content-end">
							<div class="rounded bg-warning align-self-center"
								style="margin-bottom: 10px;">모집중</div>
							<!-- 마감시 <div class="rounded bg-secondary text-light align-self-center" id="magam">마감됨</div> -->
							<span>
								장소 : <span>어딘가</span> <!--장소 넣기-->
							</span> 
							<span> 
								<img src="/hallo03talk/resources/img/with/with_detail_cal.svg"
								width="16px" height="16px" class="me-1"> 
								<span class="text-muted">22-08-06 ~ 22-08-16</span> <!--날자 집어넣기-->
							</span>
						</div>
					</div>
					<!--content-header-->

					<hr>

					<div class="w-100" style="margin-bottom: 100px;">
						<!--content-content-->
						<pre>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis
                            fugiat dolores molestias veniam et ipsa, vero harum impedit
                            explicabo placeat labore modi totam autem aliquam reiciendis 
                            temporibus! Magni, nisi id.
                        </pre>
					</div>
					<!--content-content-->

					<div class="d-flex align-items-center justify-content-center"
						style="height: 100px; width: 100%;">
						<div class="d-flex align-items-center border">
							<img src="/hallo03talk/resources/img/with/with_board_defaultMan.png" width="100"
								height="100"> <span style="margin-right: 50px;">chan0966</span>
							<a href="https://www.instagram.com/dlwlrma/">
								<!--인스타--> <img src="/hallo03talk/resources/img/with/with_detail_instagram.svg"
								width="60px" height="30px">
							</a> <a href="https://www.facebook.com/thequiett">
								<!--페북--> <img src="/hallo03talk/resources/img/with/with_detail_facebook.svg"
								width="60px" height="30px">
							</a>
						</div>
					</div>

					<div class="text-info" style="margin-top: 20px;">#27남#캠핑#산책#바다구경</div>
					<hr>

					<div class="w-100 d-flex justify-content-between">
						<div class="text-black-50">
							<div>
								작성일 : yy-mm-dd hh:mm
								<!--날짜넣기-->
							</div>
							<div>
								<svg width="24px" height="24px" viewBox="0 0 24 24"
									version="1.1" xmlns="http://www.w3.org/2000/svg"
									class="forum-icon-fill">
                                    <path
										d="M11.5,5 C17.293,5 20.813,11.041 20.918,11.298 L20.918,11.298 L21,11.5 L20.918,11.701 C20.813,11.959 17.293,18 11.5,18 C5.707,18 2.187,11.959 2.082,11.701 L2.082,11.701 L2,11.5 L2.082,11.298 C2.187,11.041 5.707,5 11.5,5 Z M11.5,6.036 C6.92,6.036 3.565,10.488 3.089,11.499 C3.567,12.51 6.932,16.964 11.5,16.964 C16.08,16.964 19.435,12.512 19.911,11.5 C19.433,10.49 16.068,6.036 11.5,6.036 Z M11.5,8.25 C13.2949254,8.25 14.75,9.70507456 14.75,11.5 C14.75,13.2949254 13.2949254,14.75 11.5,14.75 C9.70507456,14.75 8.25,13.2949254 8.25,11.5 C8.25,9.70507456 9.70507456,8.25 11.5,8.25 Z M11.5,9.25 C10.2573593,9.25 9.25,10.2573593 9.25,11.5 C9.25,12.7426407 10.2573593,13.75 11.5,13.75 C12.7426407,13.75 13.75,12.7426407 13.75,11.5 C13.75,10.2573593 12.7426407,9.25 11.5,9.25 Z"
										id="Color">
                                    </path>
                                </svg>
								5
								<!--조회수-->
							</div>

						</div>
						<a href="">신고하기</a>
						<!--신고하기-->
					</div>
				</div>
			</div>

		</div>
	</main>


	<footer></footer>
</body>
</html>