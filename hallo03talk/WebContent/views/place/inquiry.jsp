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
      <!-- 문의하기 -->
      <div class="row text-center mt-3">
        <div class="col h4">문의하기</div>
      </div>
      <form action="" method="post" class="d-flex row justify-content-center">
      	<div class="col">
	        <input type="text" placeholder="문의하기" required class="my-3 text-center w-100" />
      	</div>
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
</main>
<footer></footer>
</body>
</html>