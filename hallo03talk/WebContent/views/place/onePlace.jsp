<%@page import="com.h3.place.vo.PlaceVo"%> <%@page import="com.h3.placePhoto.vo.PlacePhotoVo"%> <%@page
import="java.util.ArrayList"%> <%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link href="/hallo03talk/resources/css/onePhoto.css" rel="stylesheet" type="text/css" />
    <link href="/hallo03talk/resources/css/reviewForm.css" rel="stylesheet" type="text/css" />
    <link href="/hallo03talk/resources/css/star.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <%@ include file="/views/common/header.jsp"%>
    <main>
      <div id="container" class="container-xxl">
        <!-- 슬라이드 -->
        <div id="onePlacePhotos" class="carousel slide mt-3" data-bs-ride="true">
          <div class="carousel-inner">
            <c:forEach begin="0" end="${ fn:length(photoList)-1 }" step="1" varStatus="st">
              <c:if test="${ st.index == 0 }">
                <div class="carousel-item active">
                  <img
                    src="/hallo03talk/resources/upload/place/${ photoList.get(st.index).name }"
                    class="d-block w-100"
                    alt="..."
                    height="500px"
                  />
                </div>
              </c:if>
              <c:if test="!${st.index == 0 }">
                <div class="carousel-item">
                  <img
                    src="/hallo03talk/resources/upload/place/${ photoList.get(st.index).name }"
                    class="d-block w-100"
                    alt="..."
                    height="500px"
                  />
                </div>
              </c:if>
            </c:forEach>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#onePlacePhotos" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#onePlacePhotos" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
        <!-- 신고버튼 -->
        <!-- 사장님이 아닐때 -->

        <div class="row">
          <c:if test="${ BossLoginMember == null }">
            <div class="col text-start">
              <button class="btn btn-danger mt-3 mb-0" data-bs-toggle="modal" data-bs-target="#reportMain">장소 신고</button>
            </div>

            <div class="col text-center mt-3 mb-0">
              <svg
                style="color: rgb(253, 195, 86)"
                xmlns="http://www.w3.org/2000/svg"
                width="32"
                height="34"
                fill="currentColor"
                class="bi bi-heart-fill"
                viewBox="0 0 16 16"
              >
                <path
                  fill-rule="evenodd"
                  d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"
                  fill="#fdc356"
                ></path>
              </svg>
              <svg
                style="color: #f3da35"
                xmlns="http://www.w3.org/2000/svg"
                width="32"
                height="32"
                fill="currentColor"
                class="bi bi-heart"
                viewBox="0 0 16 16"
              >
                <path
                  d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
                  fill="#f3da35"
                ></path>
              </svg>
              <label for="zzim">${ placeVo.cnt }</label>
            </div>
          </c:if>
          <!-- 사장님만 보임 -->
          <c:if test="${ BossLoginMember != null }">
            <div class="col text-end">
              <button class="btn btn-warning mt-3 mb-0">장소 수정</button>
            </div>
          </c:if>
        </div>

        <div class="place-info py-3">
          <div class="row border border-3">
            <!-- 장소사진 -->
            <c:set var="s" value="${ fn:length(photoList)-1 }"></c:set>
            <img src="/hallo03talk/resources/upload/place/${ photoList.get(s).name }" alt="" class="col-3" />
            <div class="col text-center py-5">
              <!-- 장소명 -->
              <label for="place-title" class="h1">${ placeVo.name }</label>
              <!-- 장소설명 -->
              <p class="h4 py-2 px-5">${ placeVo.content }</p>
              <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#reservation">예약하기</button>
              <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#inquiry">문의하기</button>
            </div>
            <div class="d-flex flex-column col-2 justify-content-center align-items-center">
              <div>${ bossVoForShow.id }</div>
              <div>${ bossVoForShow.phone }</div>
              <div>${ bossVoForShow.email }</div>
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
              <div class="d-flex col-4 justify-content-center align-items-center">
                <textarea
                  name="reviewContent"
                  cols="30"
                  rows="10"
                  class="form-control"
                  style="resize: none"
                  placeholder="후기 내용"
                ></textarea>
              </div>
              <div class="d-flex col-2 justify-content-center align-items-center">
                <span class="star"> ★★★★★ <span style="width: 50%">★★★★★</span> </span>
              </div>
              <div class="d-flex col justify-content-end align-items-center">
                <button class="btn btn-primary">작성</button>
                <button type="button" class="btn btn-danger">취소</button>
              </div>
            </div>
          </form>
          <!-- 후기 목록 -->
          <div class="row py-1 my-1 border border-2">
            <div class="col-2">
              <img src="/hallo03talk/resources/img/place_2.jpg" alt="" width="200px" height="200px" />
            </div>
            <div class="d-flex col-2 justify-content-center align-items-center">
              <label for="review" class="h2">후기</label>
            </div>
            <div class="d-flex col-4 justify-content-center align-items-center">
              <p>후기후기 후기후기 후기후기 후기후기</p>
            </div>
            <div class="d-flex col-2 justify-content-center align-items-center">
              <span class="star">
                ★★★★★ <span>★★★★★</span>
                <input type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10" name="star" />
              </span>
            </div>
            <!-- 사장님만 보임 -->
            <c:if test="${ BossLoginMember != null }">
              <div class="d-flex col justify-content-end align-items-center">
                <button class="btn btn-primary px-1" id="writeReview">답글 등록</button>
              </div>
            </c:if>
            <!-- 답글 등록 폼 -->
            <form action="" method="post" class="hideForm" id="commentForm">
              <div class="row border border-2">
                <div class="d-flex col-2 justify-content-center align-items-center"></div>
                <div class="d-flex col-2 justify-content-center align-items-center">
                  <input type="text" name="reviewTitle" class="form-control" placeholder="답글 제목" />
                </div>
                <div class="d-flex col-6 justify-content-center align-items-center">
                  <textarea
                    name="reviewContent"
                    cols="30"
                    rows="1"
                    class="form-control"
                    style="resize: none"
                    placeholder="답글 내용"
                  ></textarea>
                </div>
                <div class="d-flex col-2 justify-content-end align-items-center">
                  <button class="btn btn-primary">작성</button>
                  <button type="button" class="btn btn-danger">취소</button>
                </div>
              </div>
            </form>
            <div class="col-2 text-center">
              <h1>┗</h1>
            </div>
            <div class="d-flex col-2 justify-content-center align-items-center">
              <label for="review" class="h2">답글</label>
            </div>
            <div class="d-flex col-6 justify-content-center align-items-center">
              <p>답글답글</p>
            </div>
            <div class="d-flex col justify-content-end align-items-center">
              <button class="btn btn-danger px-1" id="delReview">답글 삭제</button>
            </div>
          </div>
        </div>
      </div>
    </main>
    <footer></footer>
    <!-- 모달 -->
    <!-- 예약하기 모달 -->
    <div class="modal" id="reservation">
      <div class="modal-dialog">
        <div class="modal-content">
          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">예약하기</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>

          <!-- Modal body -->
          <div class="modal-body">
            <form action="" method="" class="row">
              <div class="row">
                <div class="col text-center">날짜선택</div>
              </div>
              <div class="row">
                <div class="col text-center">
                  <input type="date" class="col" /> <label for="" class="col">~</label>
                  <input type="date" class="col" />
                </div>
              </div>
              <div class="row my-1">
                <div class="col text-center">이름</div>
              </div>
              <div class="row my-1">
                <input type="text" class="col text-center ms-4" />
              </div>
              <div class="row my-1">
                <div class="col text-center">전화번호</div>
              </div>
              <div class="row my-1">
                <input type="text" class="col text-center ms-4" />
              </div>
              <div class="row my-1">
                <div class="col text-center">추가사항</div>
              </div>
              <div class="row my-1">
                <textarea class="col text-center ms-4" rows="15"></textarea>
              </div>
              <div class="row my-1">
                <button class="col btn btn-primary ms-4">확인</button>
                <button class="col btn btn-danger ms-4">취소</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- 문의하기 모달 -->
    <div class="modal" id="inquiry">
      <div class="modal-dialog">
        <div class="modal-content">
          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">문의하기</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>

          <!-- Modal body -->
          <div class="modal-body">
            <form action="" method="post" class="d-flex row justify-content-center">
              <!-- 문의 내용 -->
              <div class="row text-center">
                <div class="col h4">문의내용</div>
              </div>
              <div class="d-flex row justify-content-center">
                <textarea placeholder="문의내용" rows="20" required class="col my-3 text-center"></textarea>
              </div>
              <div class="row">
                <div class="col">
                  <button type="button" class="btn btn-primary my-1 w-100">입력</button>
                </div>
                <div class="col">
                  <button type="button" class="btn btn-danger my-1 w-100">취소</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- 신고하기 모달 -->
    <div class="modal" id="reportMain">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <!-- Modal Header -->
          <div class="modal-header">
            <h3 class="modal-title">신고하기</h3>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>

          <!-- Modal body -->
          <div class="modal-body">
            <h5>1.신고하려고 하는 항목을 선택해주세요.</h5>
            <input type="checkbox" value="" id="page" onclick="example_1();" />
            <label for="page">게시물</label> <br />
            <input type="checkbox" value="" id="user" onclick="example_2();" /> <label for="user">사용자</label> <br />
            <input type="checkbox" value="" id="comment" onclick="example_3();" /> <label for="comment">댓글</label> <br />
            <br />
            <h5>2.신고하려는 항목에 대한 이유를 선택해주세요.</h5>
            <h6>항목은 한가지만 선택할 수 있습니다.</h6>
            <input type="checkbox" value="" id="name" onclick="example_4();" />
            <label for="name"><b>부적절한 이름, 제목</b></label> <br />
            불쾌감을 주거나, 부적절한 이름 또는 제목 사용 <br />
            <input type="checkbox" value="" id="curse" onclick="example_5();" /> <label for="curse"><b>욕설</b></label> <br />
            상대방에게 공격적인 언어 사용 <br />
            <input type="checkbox" value="" id="disgust" onclick="example_6();" /> <label for="disgust"><b>혐오 발언</b> </label>
            <br />
            각종 비하 또는 차별 발언 <br />
            <input type="checkbox" value="" id="ad" onclick="example_7();" /> <label for="ad"><b>광고성 계정, 게시물</b> </label>
            <br />
            과도한 광고성 게시물, 댓글 작성. 또는 그 계정 <br />
            <br />
            <h5>3.신고하려는 자세한 이유를 적어주세요.</h5>
            <textarea name="" id="" cols="100" rows="5" placeholder="내용을 입력해 주세요."></textarea>
          </div>

          <!-- Modal footer -->
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal" style="margin: 0 auto">신고하기</button>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script src="/hallo03talk/resources/js/report.js"></script>
  <script src="/hallo03talk/resources/js/onePhoto.js"></script>
  <script src="/hallo03talk/resources/js/reviewForm.js"></script>
  <script src="/hallo03talk/resources/js/updateReview.js"></script>
  <script src="/hallo03talk/resources/js/star.js"></script>
</html>
