<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>

<!-- summernote -->
<script src="summernote/summernote-lite.js"></script>
<script src="summernote/summernote-ko-KR.min.js"></script>
<link rel="stylesheet" href="summernote/summernote-lite.css">

<!-- tagify -->
<script src="https://unpkg.com/@yaireo/tagify"></script>
<!-- <script src="https://unpkg.com/@yaireo/tagify/dist/tagify.polyfills.min.js"></script> -->
<link href="https://unpkg.com/@yaireo/tagify/dist/tagify.css" rel="stylesheet" type="text/css" />

<style>
	a {
		text-decoration: none;
	}
	
	/* 컨텐트 영역 */
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
	
	#jeju div:hover, #souguipo div:hover {
		background-color: antiquewhite;
		transition: 0.5s;
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
          <div class="d-flex align-items-end">
            <h1>글쓰기</h1>
            <span class="text-muted" style="margin-left: 10px ;"> - 글을 잘 써 보아요</span>
          </div>
          <hr>

          <form action="" style="padding: 20px;" class="d-flex flex-column">
            <!-- 글쓰기 요청 폼 -->

            <label for="exampleFormControlInput1" class="form-label mt-3"><h4>제목</h4></label>
            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="제목을 입력하세요" name="title">


            <label for="exampleFormControlTextarea1" class="form-label mt-3"><h4>내용</h4></label>
			<!-- summernote -->
           	<textarea class="summernote" name="content" id="exampleFormControlTextarea1"></textarea>
           	
           	<!-- 태그 -->
            <input type="text" class="form-control mt-1" id="tag" placeholder="태그 입력" name="tag">
            

            <label for="formDatepicker" class="mt-3"><h4>날짜</h4></label>
            <div id="formDatepicker" class="d-flex">
              <input type="date" id="date1" class="flex-grow-1 border" name="startDate"> ~ <input type="date" id="date1" class="flex-grow-1 border" name="endDate">
            </div>

            <label for="formPlace" class="mt-3"><h4>장소</h4></label>

            <div id="formPlace">
              <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link active" id="jeju-tab" data-bs-toggle="tab" data-bs-target="#jeju" type="button" role="tab" aria-controls="home" aria-selected="true">제주</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="souguipo-tab" data-bs-toggle="tab" data-bs-target="#souguipo" type="button" role="tab" aria-controls="profile" aria-selected="false">서귀포</button>
                </li>
              </ul>

              <div class="tab-content" id="myTabContent" style="margin-bottom: 50px; position: relative;">

                <div class="tab-pane fade show border border-top-0 rounded-bottom active d-flex" id="jeju" role="tabpanel" aria-labelledby="home-tab" 
                  style="position: absolute; width: 100%; z-index: 1;">
                  <div class="flex-grow-1 text-center p-2">제주시</div>
                  <div class="flex-grow-1 text-center p-2">한경면</div>
                  <div class="flex-grow-1 text-center p-2">한림읍</div>
                  <div class="flex-grow-1 text-center p-2">애월읍</div>
                  <div class="flex-grow-1 text-center p-2">조천읍</div>
                  <div class="flex-grow-1 text-center p-2">구좌읍</div>
                  <div class="flex-grow-1 text-center p-2">우도면</div>
                </div>

                <div class="tab-pane fade border border-top-0 rounded-bottom d-flex " id="souguipo" role="tabpanel" aria-labelledby="profile-tab" 
                  style="position: absolute; width: 100%; z-index: 0;">
                  <div class="flex-grow-1 text-center p-2">서귀포시</div>
                  <div class="flex-grow-1 text-center p-2">대정읍</div>
                  <div class="flex-grow-1 text-center p-2">안덕면</div>
                  <div class="flex-grow-1 text-center p-2">남원읍</div>
                  <div class="flex-grow-1 text-center p-2">표선면</div>
                  <div class="flex-grow-1 text-center p-2">성산읍</div>
                </div>

              </div>

            </div>
            <input type="text" id="input-place" name="place" class="mt-1 border" readonly placeholder="장소">

            <button type="submit" class="btn btn-outline-warning" style="margin-top: 10px;">글쓰기</button>
          </form>

        </div>

      </div>
		
		</div>
	</main>


	<footer></footer>

</body>
</html>

<script>
  $(function(){
    $('#jeju-tab').click(function(){
      $('#jeju').css('z-index','1');
      $('#souguipo').css('z-index','0');
    });

    $('#souguipo-tab').click(function(){
      $('#jeju').css('z-index','0');
      $('#souguipo').css('z-index','1');
    });

    $('#jeju div').each(function(i){
      $(this).click(function(){
        $('#input-place').val($(this).text());
      });
    });

    $('#souguipo div').each(function(i){
      $(this).click(function(){
        $('#input-place').val($(this).text());
      });
    });
  })
</script>

<script>
    $('.summernote').summernote({
        height: 450,
        lang: "ko-KR"
    });
</script>

<!-- tagify -->
<script>
var input = document.querySelector('#tag')
var tagify = new Tagify(input);
  
// 태그가 추가되면 이벤트 발생
tagify.on('add', function() {
  console.log(tagify.value); // 입력된 태그 정보 객체
})
</script>