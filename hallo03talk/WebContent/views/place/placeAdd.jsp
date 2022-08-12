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
      <form id="container" class="container-xxl">
        <!-- 슬라이드 -->
        <div class="d-flex w-100 border border-2 justify-content-center align-items-center mt-3" style="height: 500px">
          <input type="file" name="slideImgs" multiple class="w-100 h-100" />
        </div>

        <div class="place-info py-3">
          <div class="row border border-3">
            <!-- 장소사진 -->
            <div class="d-flex col-3 justify-content-center align-items-center border border-2">
              <input type="file" name="placeImg" />
            </div>
            <div class="col text-center py-5">
              <!-- 장소명 -->
              <input type="text" placeholder="장소명" class="h1" name="placeAddTitle" />
              <!-- 장소설명 -->
              <p class="h4 py-2 px-5">
                <textarea name="placeAddContent" cols="50" rows="10">
  장소설명 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절 구구절절</textarea
                >
              </p>
            </div>
            <div class="d-flex flex-column col-2 justify-content-center align-items-center">
              <div>사장명</div>
              <div>010-0000-0000</div>
              <div>사업자 정보 사장 정보 등등등</div>
            </div>
          </div>
        </div>
        <div class="text-center">
          <button type="button" class="btn btn-warning my-3" id="placeAddBtn">장소 등록</button>
        </div>
      </form>
    </main>

    <footer></footer>
  </body>
</html>
