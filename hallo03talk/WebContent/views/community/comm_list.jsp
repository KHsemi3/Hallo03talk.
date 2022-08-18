<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#container-header {
	display: flex;
	align-items: baseline;
	justify-content: space-between;
}

.chi:nth-child(1) {
	flex-grow: 1;
}

.chi:nth-child(2) {
	flex-grow: 50;
}

.chi:nth-child(3) {
	flex-grow: 0;
}

#container {
	padding: 3rem;
}


</style>
</head>

<body>


	<main>
		<div id="container" class="container-xxl d-flex flex-column">
			<div id="container-header">
				<h1 class="chi">커뮤니티</h1>
				<h6 class="chi">맛집 추천글, 장소 추천등 여행자들의 소통</h6>
				<button class="btn btn-outline-warning chi" onclick="location.href='#'">글쓰기</button>
			</div>
			<hr>
			<div class="d-flex flex-grow-1">
				<div class="h-100" style="width: 20%; margin-right: 3rem;">
					<ul class="list-group list-group-flush">
						<li class="list-group-item list-group-item-warning list-group-item-action" onclick="location.href='#'">전체보기</li>
						<li class="list-group-item list-group-item-light list-group-item-action" onclick="location.href='#'">질문답변</li>
						<li class="list-group-item list-group-item-warning list-group-item-action" onclick="location.href='#'">자유게시판</li>
						<li class="list-group-item list-group-item-light list-group-item-action" onclick="location.href='#'">공지사항</li>
					</ul>
				</div>
				<div class="border rounded h-100 d-flex flex-column" style="width: 80%; padding: 1rem;">
				
					<div class="d-flex"> <!-- 소제목 -->
						<h5 class="flex-grow-1">전체보기</h5>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-sm" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">최신순</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="#">최신순</a></li>
								<li><a class="dropdown-item" href="#">조회순</a></li>
							</ul>
						</div>
					</div>
					<hr>
					
					<div class="flex-grow-1"> <!-- 내용 테이블-->
						<table class="table table-striped table-hover" style="table-layout: fixed">
							<thead>
								<tr>
									<th scope="col" style="width: 24px">#</th>
									<th scope="col" style="width: 500px">제목</th>
									<th scope="col">작성자</th>
									<th scope="col" style="width: 65px">조회수</th>
									<th scope="col">작성일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach  var="vo" items="${voList}">
									<tr onclick="location.href='#'" style="cursor:pointer;" ><!-- 요청 추가 -->
										<th scope="row" class="align-middle">${vo.no} </th>
										<td class="overflow-hidden text-truncate align-middle">${vo.title}</td>
										<td class="align-middle">${vo.writer}</td>
										<td class="align-middle">${vo.cnt}</td>
										<td style = "font-size:small;" class="align-middle">${vo.enroll_date}</td>
									</tr>
								</c:forEach>
								
								
							</tbody>
						</table>
					</div>
					
					<hr>
					
					<div><!-- 페이지네이션  -->
						<nav aria-label="Page navigation" >
							<ul class="pagination d-flex justify-content-center">
								<li class="page-item">
									<a class="page-link" href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<li class="page-item"> <a class="page-link" href="#">1</a> </li>
								<li class="page-item"> <a class="page-link" href="#">2</a> </li>
								<li class="page-item"> <a class="page-link" href="#">3</a> </li>
								<li class="page-item"> 
									<a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</main>


	<footer></footer>

</body>
</html>