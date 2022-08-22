<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 등록</title>
 <link rel="stylesheet" href="/hallo03talk/views/party/partyCss/all.css">
</head>

<body>


<%@ include file="/views/common/header.jsp"%>

	<main>
		<div id="container" class="container-xxl">
              <div class="registerBox">
        		<h1>Register</h1>
        		<h4>어떤 가게를 운영중이신가요?</h4>
        			<form action="/hallo03talk/bossRegister" method="post">
            			<label>사업자등록번호</label>
            			<input type="text" name="busNum" placeholder="사업자등록번호를 입력해 주세요">
            			<label>업태</label>
            			<input type="text" name="busStatus" placeholder="한글로만 입력하세요">
            			<label>상호명</label>
            			<input type="text" name="busName" placeholder="상호명을 입력해 주세요">
            			<label>대표자명</label>
            			<input type="text" name="busBoss" placeholder="대표자명을 입력해 주세요">
            			<label>생년월일</label>
            			<input type="text" name="busBirth" placeholder="숫자 6자리를 입력해 주세요">
           				<label>주소</label>
            			<input type="text" name="busAddress" placeholder="주소를 검색하세요">
            			<input type="button" value="주소검색"><br>
            			<input type="submit" value="확인">
        			 </form>
    			</div>
			</div>				
		
	</main>


	<footer></footer>


</body>
</html>