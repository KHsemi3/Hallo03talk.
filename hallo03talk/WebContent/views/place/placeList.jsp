<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
          <div class="row px-lg-5">
            <!-- 장소하나 -->
            <div class="col mb-5">
              <div class="card" style="width: 350px">
                <img
                  class="card-img-top"
                  src="/hallo03talk/resources/img/place_2.jpg"
                  alt="Card image"
                  width="350px"
                  height="350px"
                />
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
                <img
                  class="card-img-top"
                  src="/hallo03talk/resources/img/place_3.jpg"
                  alt="Card image"
                  width="350px"
                  height="350px"
                />
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
                <img
                  class="card-img-top"
                  src="/hallo03talk/resources/img/place_1.jpg"
                  alt="Card image"
                  width="350px"
                  height="350px"
                />
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
                <img
                  class="card-img-top"
                  src="/hallo03talk/resources/img/place_2.jpg"
                  alt="Card image"
                  width="350px"
                  height="350px"
                />
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
                <img
                  class="card-img-top"
                  src="/hallo03talk/resources/img/place_3.jpg"
                  alt="Card image"
                  width="350px"
                  height="350px"
                />
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
                <img
                  class="card-img-top"
                  src="/hallo03talk/resources/img/place_1.jpg"
                  alt="Card image"
                  width="350px"
                  height="350px"
                />
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
