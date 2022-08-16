<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>
<%
request.setCharacterEncoding("UTF-8"); //한글깨지면 주석제거
//request.setCharacterEncoding("EUC-KR"); //해당시스템의 인코딩타입이 EUC-KR일경우에 String inputYn =
request.getParameter("inputYn");
String roadFullAddr = request.getParameter("roadFullAddr");
String roadAddrPart1 = request.getParameter("roadAddrPart1");
String roadAddrPart2 = request.getParameter("roadAddrPart2");
String engAddr = request.getParameter("engAddr");
String jibunAddr = request.getParameter("jibunAddr");
String zipNo = request.getParameter("zipNo");
String addrDetail = request.getParameter("addrDetail");
String admCd = request.getParameter("admCd");
String rnMgtSn = request.getParameter("rnMgtSn");
String bdMgtSn = request.getParameter("bdMgtSn");
/** API 서비스 제공항목 확대 (2017.02) **/
String detBdNmList = request.getParameter("detBdNmList");
String bdNm = request.getParameter("bdNm");
String bdKdcd = request.getParameter("bdKdcd");
String siNm = request.getParameter("siNm");
String sggNm = request.getParameter("sggNm");
String emdNm = request.getParameter("emdNm");
String liNm = request.getParameter("liNm");
String rn = request.getParameter("rn");
String udrtYn = request.getParameter("udrtYn");
String buldMnnm = request.getParameter("buldMnnm");
String buldSlno = request.getParameter("buldSlno");
String mtYn = request.getParameter("mtYn");
String lnbrMnnm = request.getParameter("lnbrMnnm");
String lnbrSlno = request.getParameter("lnbrSlno");
String emdNo = request.getParameter("emdNo");
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
		<form id="container" class="container-xxl"
			action="<%=contextPath%>/place/add" method="post"
			enctype="multipart/form-data">
			<!-- 슬라이드 -->
			<div
				class="d-flex w-100 border border-2 justify-content-center align-items-center mt-3"
				style="height: 500px">
				<input type="file" name="slideImgs" multiple class="w-100 h-100" />
			</div>

			<div class="place-info py-3">
				<div class="row border border-3">
					<!-- 장소사진 -->
					<div
						class="d-flex col-3 justify-content-center align-items-center border border-2">
						<input type="file" name="placeImg" />
					</div>
					<div class="col text-center py-5">
						<select name="category_no">
							<option value="1">카페</option>
							<option value="2" selected>숙소</option>
							<option value="3">식당</option>
						</select>
						<!-- 장소명 -->
						<input type="text" placeholder="장소명" class="h2" name="placeName" />
						<!-- 장소설명 -->
						<p class="py-2 px-5">
							<textarea name="placeContent" class="h5" cols="50" rows="7"
								placeholder="장소 설명"></textarea>
						</p>
						<p class="py-2 px-5 row">
							<input type="text" name="placeAddr" class="col text-center"
								readonly placeholder="주소" required />
						</p>
						<button type="button" class="btn btn-primary col"
							onclick="goPopup();">주소 검색</button>
					</div>
					<div
						class="d-flex flex-column col-2 justify-content-center align-items-center">
						<div>사장명</div>
						<div>010-0000-0000</div>
						<div>사업자 정보 사장 정보 등등등</div>
					</div>
				</div>
			</div>

			<div class="text-center">
				<button class="btn btn-warning my-3" id="placeAddBtn">장소 등록</button>
			</div>
		</form>
	</main>

	<footer></footer>

	<div class="modal" id="addJuso">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">주소추가</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="d-flex row justify-content-center">
						<!-- 문의 내용 -->
						<div class="row text-center">
							<div class="col h4">우편번호</div>
						</div>
						<div class="d-flex row justify-content-center">
							<input type="hidden" id="confmKey" name="confmKey" value="" /> <input
								type="text" id="zipNo" name="zipNo" readonly class="col" /> <input
								type="button" value="주소검색" onclick="goPopup();" class="col" />
						</div>
						<div class="row text-center">
							<div class="col h4">주소</div>
						</div>
						<div class="d-flex row justify-content-center">
							<input type="text" id="roadAddrPart1" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<button type="button" class="btn btn-primary my-1 w-100"
								id="addJusoConfirm">확인</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-danger my-1 w-100"
								class="btn-close" data-bs-dismiss="modal">취소</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="/hallo03talk/resources/js/jusoPopUp.js"></script>
</html>
