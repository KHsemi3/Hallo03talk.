<%@page import="java.util.ArrayList"%>
<%@page import="com.h3.placePhoto.vo.PlacePhotoVo"%>
<%@page import="com.h3.place.vo.PlaceVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<PlaceVo> placeList = (ArrayList<PlaceVo>)request.getAttribute("placeList");
ArrayList<PlacePhotoVo> photoList = (ArrayList<PlacePhotoVo>)request.getAttribute("photoList");
int x = placeList.size()/3+1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<main>
		<div id="container" class="container-xxl">
			<h1 class="text-center py-lg-5" style="font-family: 'Somi'">장소</h1>
			<!-- 장소 카테고리들 -->
			<div id="place-finder" class="fw-bolder text-center mt-5 mx-5">
				<div class="row border border-4">
					<div class="row">
						<div class="col-2 border-end border-3">숙소</div>
						<div class="col-2 bg-warning border-end border-3" id="jeju">제주</div>
						<!-- 제주시 -->
						<div class="col in-jeju">시내</div>
						<div class="col in-jeju">애월</div>
						<div class="col in-jeju">한림</div>

						<!-- 서귀포 -->
						<div class="col in-seogwipo d-none">시내</div>
						<div class="col in-seogwipo d-none">남원</div>
						<div class="col in-seogwipo d-none">안덕</div>
					</div>
					<div class="row">
						<div class="col-2 border-end border-3">맛집</div>
						<div class="col-2 border-end border-3" id="seogwipo">서귀포</div>
						<!-- 제주시 -->
						<div class="col in-jeju">한경</div>
						<div class="col in-jeju">조천</div>
						<div class="col in-jeju">구좌</div>
						<!-- 서귀포 -->
						<div class="col in-seogwipo d-none">대정</div>
						<div class="col in-seogwipo d-none">표선</div>
						<div class="col in-seogwipo d-none">성산</div>
					</div>
					<div class="row">
						<div class="col-2 border-end border-3">카페</div>
						<div class="col-2 border-end border-3"></div>
						<div class="col"></div>
					</div>
				</div>
			</div>

			<div id="place-show" class="mt-lg-5 w-100">
			<%for(int i=0; i<x; i++) { %>
				<div class="row px-lg-5">
				<%for(int j=0; j<placeList.size(); j++) { %>
					<!-- 장소하나 -->
					<div class="col mb-5">
						<div class="card" style="width: 350px">
							<img class="card-img-top"
								src="/hallo03talk/resources/upload/place/<%=photoList.get(j).getName() %>" alt="Card image"
								width="350px" height="350px" />
							<div class="card-body">
								<h4 class="card-title"><%= placeList.get(j).getName() %></h4>
								<p class="card-text"><%= placeList.get(j).getAddress()%></p>

								<div class="row">
									<a href="#" class="btn btn-primary col-5 ms-3">더보기</a>
									<div class="col"></div>
									<div class="d-flex col align-items-center">
										<svg width="24px" height="24px" viewBox="0 0 24 24"
											version="1.1" xmlns="http://www.w3.org/2000/svg"
											class="forum-icon-fill">
                        <path
												d="M11.5,5 C17.293,5 20.813,11.041 20.918,11.298 L20.918,11.298 L21,11.5 L20.918,11.701 C20.813,11.959 17.293,18 11.5,18 C5.707,18 2.187,11.959 2.082,11.701 L2.082,11.701 L2,11.5 L2.082,11.298 C2.187,11.041 5.707,5 11.5,5 Z M11.5,6.036 C6.92,6.036 3.565,10.488 3.089,11.499 C3.567,12.51 6.932,16.964 11.5,16.964 C16.08,16.964 19.435,12.512 19.911,11.5 C19.433,10.49 16.068,6.036 11.5,6.036 Z M11.5,8.25 C13.2949254,8.25 14.75,9.70507456 14.75,11.5 C14.75,13.2949254 13.2949254,14.75 11.5,14.75 C9.70507456,14.75 8.25,13.2949254 8.25,11.5 C8.25,9.70507456 9.70507456,8.25 11.5,8.25 Z M11.5,9.25 C10.2573593,9.25 9.25,10.2573593 9.25,11.5 C9.25,12.7426407 10.2573593,13.75 11.5,13.75 C12.7426407,13.75 13.75,12.7426407 13.75,11.5 C13.75,10.2573593 12.7426407,9.25 11.5,9.25 Z"
												id="Color"></path>
                      </svg>
										<%=placeList.get(j).getCnt() %>
									</div>
									<div class="d-flex col align-items-center">
										<svg style="color: rgb(253, 195, 86)"
											xmlns="http://www.w3.org/2000/svg" width="32" height="34"
											fill="currentColor" class="bi bi-heart-fill"
											viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
												d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"
												fill="#fdc356"></path>
                      </svg>
										<svg style="color: #f3da35" xmlns="http://www.w3.org/2000/svg"
											width="32" height="32" fill="currentColor"
											class="bi bi-heart" viewBox="0 0 16 16">
                        <path
												d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
												fill="#f3da35"></path>
                      </svg>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%}} %>
					<!-- 장소둘 -->
					<div class="col mb-5">
						<div class="card" style="width: 350px">
							<img class="card-img-top"
								src="/hallo03talk/resources/img/place_3.jpg" alt="Card image"
								width="350px" height="350px" />
							<div class="card-body">
								<h4 class="card-title">장소명</h4>
								<p class="card-text">장소위치</p>
								<a href="#" class="btn btn-primary">더보기</a>
							</div>
						</div>
					</div>
					<!-- 장소셋 -->
					<div class="col mb-5">
						<div class="card" style="width: 350px">
							<img class="card-img-top"
								src="/hallo03talk/resources/img/place_1.jpg" alt="Card image"
								width="350px" height="350px" />
							<div class="card-body">
								<h4 class="card-title">장소명</h4>
								<p class="card-text">장소위치</p>
								<a href="#" class="btn btn-primary">더보기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row px-lg-5">
					<!-- 장소하나 -->
					<div class="col mb-5">
						<div class="card" style="width: 350px">
							<img class="card-img-top"
								src="/hallo03talk/resources/img/place_2.jpg" alt="Card image"
								width="350px" height="350px" />
							<div class="card-body">
								<h4 class="card-title">장소명</h4>
								<p class="card-text">장소위치</p>
								<a href="#" class="btn btn-primary">더보기</a>
							</div>
						</div>
					</div>
					<!-- 장소둘 -->
					<div class="col mb-5">
						<div class="card" style="width: 350px">
							<img class="card-img-top"
								src="/hallo03talk/resources/img/place_3.jpg" alt="Card image"
								width="350px" height="350px" />
							<div class="card-body">
								<h4 class="card-title">장소명</h4>
								<p class="card-text">장소위치</p>
								<a href="#" class="btn btn-primary">더보기</a>
							</div>
						</div>
					</div>
					<!-- 장소셋 -->
					<div class="col mb-5">
						<div class="card" style="width: 350px">
							<img class="card-img-top"
								src="/hallo03talk/resources/img/place_1.jpg" alt="Card image"
								width="350px" height="350px" />
							<div class="card-body">
								<h4 class="card-title">장소명</h4>
								<p class="card-text">장소위치</p>
								<a href="#" class="btn btn-primary">더보기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<footer></footer>
</body>
<script src="/hallo03talk/resources/js/placeList.js"></script>
</html>
