<%@page import="com.h3.with.vo.PageVo"%>
<%@page import="com.h3.with.vo.WithVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<WithVo> wvoList = (ArrayList<WithVo>) request.getAttribute("wvoList");

PageVo pv = (PageVo)request.getAttribute("pageVo");

int currentPage = pv.getCurrentPage();
int startPage = pv.getStartPage();
int endPage = pv.getEndPage();
int maxPage = pv.getMaxPage();
System.out.println(wvoList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#container {
	padding: 3rem;
}

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

#align-dropdown {
	display: flex;
	justify-content: flex-end;
}

/* 여기서부터 아이템들 */
#content-items {
	margin: 1rem;
	width: 100%;
	height: 120px;
}

#content-items:hover {
	background-color: bisque;
	cursor: pointer;;
}

#content-items * {
	margin: 10px;
}

#content-items-title {
	width: 40%;
}
</style>

</head>
<body>

	<%@ include file="/views/common/header.jsp"%>

	<main>
		<div id="container" class="container-xxl">

			<div id="container-header">
				<h1 class="chi">동행</h1>
				<h6 class="chi">쉽고 빠르게 같이 동행할 여행친구 찾기</h6>
			</div>
			<hr>

	</main>


	<footer></footer>

</body>
</html>