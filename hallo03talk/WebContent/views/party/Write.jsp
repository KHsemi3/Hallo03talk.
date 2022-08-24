<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 안내</title>
<link rel="stylesheet" href="/hallo03talk/views/party/partyCss/all.css">
</head>

<body>




	<main>
		<div id="container" class="container-xxl">
			<div class="board_wrap">
				<div class="board_title">
					<strong>이벤트 소식</strong>
					<P>제주도에서만 즐길 수 있는 축제 및 가게들의 행사를 안내해드립니다!</P>
				</div>
				<form action="/hallo03talk/party/write" method="post" id="pform">
					<div class="write_wrap">
						<div class="write">
							<div class="catag"></div>
							<dl>
								<dt>말머리</dt>
								<dd></dd>
							</dl>
							<div class="title">
								<dl>
									<dt>제목</dt>
									<dd>
										<input type="text" placeholder="제목 입력">
									</dd>
								</dl>
							</div>

							<div class="cont">
								<textarea placeholder="내용 입력"></textarea>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-dark">등록</button>
				</form>

				<div class="bt_wrap">
					<input type="button" value="취소" onclick="history.go(-1)">
					
				</div>


			</div>



		</div>
	</main>


	<footer></footer>
	<script type="text/javascript">
	alert('asdfasdf')
		function onsubmit() {
			const bform = document.querySelector('#pform');
			alert(bform);
			bform.submit();
		}
	</script>

</body>
</html>