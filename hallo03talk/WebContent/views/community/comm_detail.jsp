<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "<%=request.getContextPath() %>"></c:set>

<%
String alertMsg = (String)session.getAttribute("alertMsg");
session.removeAttribute("alertMsg");
%>
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
		<div id="container" class="container-xxl">
			<div id="container-header">
				<h1 class="chi">커뮤니티</h1>
				<h6 class="chi">맛집 추천글, 장소 추천등 여행자들의 소통</h6>
			</div>
			<hr>
			<div class="d-flex flex-grow-1">
			
				<div class="h-100" style="width: 20%; margin-right: 3rem;">
					<ul class="list-group list-group-flush">
						<li class="list-group-item list-group-item-warning list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=all&p=&s='">전체보기</li>
						<li class="list-group-item list-group-item-light list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=qna&p=&s='">질문답변</li>
						<li class="list-group-item list-group-item-warning list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=free&p=&s='">자유게시판</li>
						<li class="list-group-item list-group-item-light list-group-item-action" onclick="location.href='${contextPath}/comm/list?view=notice&p=&s='">공지사항</li>
					</ul>
				</div>
				<div class="border rounded h-100 d-flex flex-column" style="width: 80%; padding: 1rem;">
<!-- 카테고리 추가 -->
					<div class="d-flex"> <!-- 소제목 -->
						<div class="flex-grow-1">
							<h5>
								<c:choose>
									<c:when test="${vo.category == 'notice' }">공지사항</c:when>
									<c:when test="${vo.category == 'qna' }">질문답변</c:when>
									<c:when test="${vo.category == 'free' }">자유게시판</c:when>
								</c:choose>
							</h5>
<!-- 제목 추가 -->
							<h3>${vo.title}</h1>
						</div>	
							
						<div class="align-self-baseline text-muted">
							<a href="/hallo03talk/comm/list" class="btn btn-outline-warning btn-sm"	style="margin-left: 150px">목록으로</a>
							<div>조회수 : ${vo.cnt}</div>
							<div>등록일 : ${vo.enroll_date}</div>
							<div>작성자 : ${vo.writer}</div>
						</div>
					</div>
					<hr>
<!-- 내용 추가 -->
					<div>${vo.content}</div>
					<hr style="margin-top: 6rem">
<!-- 뎃글 폼태그 -->
					<form action="" method="post">
						<div class="d-flex">
							<div class="form-floating flex-grow-1">
	<!-- 댓글 내용 -->
								<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px; resize: none;"></textarea>
								<label for="floatingTextarea2">Comments</label>
							</div>
							<input class="ms-2 btn btn-outline-warning" type="submit" value="등록" >
						</div>
					</form>
<!-- 등록된 댓글 뿌리기 -->
					<c:forEach var="rvo" items="${replyList}">
						<div class="border mt-2 p-2 d-flex" >
							<div class="me-3 p-auto w-25" >${rvo.travelerNo }</div>
	
							<div>
		<!-- 등록된 댓글 내용 -->
								${rvo.content}
		<!-- 등록된 뎃글 날자 -->
								<span style="font-size: 0.8rem"> - ${rvo.enrollDate}</span>
		<!-- 등록된 뎃글 삭제 버튼 -->
								<c:if test="${travelerLoginMember.nick eq rvo.travelerNo}">
									<a href="/hallo03talk/comm/reply/delete?comm=${vo.no}&reply=${rvo.no}" style="font-size: 0.8rem; text-decoration: none;">[삭제]</a>
								</c:if>
							</div>
						</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</main>
	<script type="text/javascript">
		<%if (alertMsg != null) {%>
			alert('<%=alertMsg%>');
	<%}%>
		
	</script>

	<footer></footer>

</body>
</html>