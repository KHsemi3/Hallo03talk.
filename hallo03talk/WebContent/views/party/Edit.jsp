<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 안내</title>
 <link rel="stylesheet" href="partyCss/all.css">
</head>

<body>


			<%@ include file="/views/common/header.jsp"%>

			<main>
					<div id="container" class="container-xxl">
					<div class="board_wrap">
            <div class="board_title">
                <strong>이벤트 소식</strong>
                <P>제주도에서만 즐길 수 있는 축제 및 가게들의 행사를 안내해드립니다!</P>
            </div>
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
                            	<dd><input type="text" placeholder="제목 입력"></dd>
                        	</dl>
                    	</div>
                        	
                    <div class="cont">
                        <textarea placeholder="내용 입력"></textarea>
                    </div>
                </div>
            </div>    
             
                <div class="bt_wrap">
                    <input type="submit", class="on">등록</a>
                    <a href="#">취소</a>
                </div>
     
            
        </div>

					

					</div>
			</main>


	<footer></footer>


</body>
</html>