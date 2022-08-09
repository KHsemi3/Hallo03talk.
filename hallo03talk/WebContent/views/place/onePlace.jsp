<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/common/header.jsp"%>
	<main>
	   <div id="container" class="container-xxl">
      <!-- 슬라이드 -->
      <div id="onePlacePhotos" class="carousel slide" data-bs-ride="true">
        <div class="carousel-indicators">
          <button
            type="button"
            data-bs-target="#onePlacePhotos"
            data-bs-slide-to="0"
            class="active"
            aria-current="true"
            aria-label="Slide 1"
          ></button>
          <button
            type="button"
            data-bs-target="#onePlacePhotos"
            data-bs-slide-to="1"
            aria-label="Slide 2"
          ></button>
          <button
            type="button"
            data-bs-target="#onePlacePhotos"
            data-bs-slide-to="2"
            aria-label="Slide 3"
          ></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img
              src="/hallo03talk/WebContent/resources/img/place_1.jpg"
              class="d-block w-100"
              alt="..."
              height="500px"
            />
          </div>
          <div class="carousel-item">
            <img
              src="/hallo03talk/WebContent/resources/img/place_1.jpg"
              class="d-block w-100"
              alt="..."
              height="500px"
            />
          </div>
          <div class="carousel-item">
            <img
              src="/hallo03talk/WebContent/resources/img/place_2.jpg"
              class="d-block w-100"
              alt="..."
              height="500px"
            />
          </div>
        </div>
        <button
          class="carousel-control-prev"
          type="button"
          data-bs-target="#onePlacePhotos"
          data-bs-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button
          class="carousel-control-next"
          type="button"
          data-bs-target="#onePlacePhotos"
          data-bs-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>

      <!-- 사장님만 보임 -->
      <div class="text-end">
        <button class="btn btn-warning mt-3 mb-0">장소 수정</button>
      </div>

      <div class="place-info py-3">
        <div class="row border border-3">
          <!-- 장소사진 -->
          <img src="/hallo03talk/WebContent/resources/img/place_1.jpg" alt="" class="col-3" />
          <div class="col text-center py-5">
            <!-- 장소명 -->
            <label for="place-title" class="h1">장소명</label>
            <!-- 장소설명 -->
            <p class="h4 py-2 px-5">
              장소설명 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절
              구구절절 구구절절 구구절절 구구절절
            </p>
            <button class="btn btn-primary">예약하기</button>
            <button class="btn btn-danger">문의하기</button>
          </div>
        </div>
        <!-- =============================================================================== -->
        <div class="text-end">
          <button class="btn btn-warning my-3" id="reviewFormBtn">후기 등록</button>
        </div>
        <!-- 후기 등록 -->
        <form action="" method="post" class="hideForm" id="reviewForm">
          <div class="row border border-2">
            <div class="d-flex col-2 justify-content-center align-items-center">
              <input type="file" class="form-control" name="reviewImg" />
            </div>
            <div class="d-flex col-2 justify-content-center align-items-center">
              <input type="text" name="reviewTitle" class="form-control" placeholder="후기 제목" />
            </div>
            <div class="d-flex col-6 justify-content-center align-items-center">
              <textarea
                name="reviewContent"
                cols="30"
                rows="10"
                class="form-control"
                style="resize: none"
                placeholder="후기 내용"
              ></textarea>
            </div>
            <div class="d-flex col-2 justify-content-end align-items-center">
              <button class="btn btn-primary">작성</button>
              <button type="button" class="btn btn-danger">취소</button>
            </div>
          </div>
        </form>
        <!-- 후기 목록 -->
        <div class="row py-1 my-1 border border-2">
          <div class="col-2">
            <img
              src="/hallo03talk/WebContent/resources/img/place_2.jpg"
              alt=""
              width="200px"
              height="200px"
            />
          </div>
          <div class="d-flex col-2 justify-content-center align-items-center">
            <label for="review" class="h2">후기</label>
          </div>
          <div class="d-flex col-6 justify-content-center align-items-center">
            <p>후기후기 후기후기 후기후기 후기후기</p>
          </div>
          <!-- 사장님만 보임 -->
          <div class="d-flex col-2 justify-content-end align-items-center">
            <button class="btn btn-primary">답글 등록</button>
            <button class="btn btn-danger" id="delReview">답글 삭제</button>
          </div>
        </div>
      </div>
    </div>
	</main>
	<footer></footer>
</body>
  <script src="onePhoto.js"></script>
  <script src="reviewForm.js"></script>
  <script src="delReview.js"></script>
</html>