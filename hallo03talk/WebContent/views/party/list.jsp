<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.h3.party.vo.PartyVo"%>
<%@page import="java.util.ArrayList"%>

    
<%
	ArrayList<PartyVo> voList = (ArrayList<PartyVo>)request.getAttribute("PartyList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 안내</title>
 <link rel="stylesheet" href="/hallo03talk/views/party/partyCss/all.css">
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
            <div class="list_wrap">
                <div class="board_list">
                    <table id="top">
                   <thead>
                <tr>
                    <td>글번호</td>
                    <td>글제목</td>
                    <td>작성자</td>
                    <td>조회수</td>
                    <td>작성일</td>
                </tr>
            </thead>     
            <tbody>
                <%for(int i = 0 ; i < voList.size(); i++){%>
                    <tr>
                        <td><%= voList.get(i).getNo() %></td>
                        <td><%= voList.get(i).getTitle() %></td>
                        <td><%= voList.get(i).getBossId() %></td>
                        <td><%= voList.get(i).getCnt() %></td>
                        <td><%= voList.get(i).getEnrollDate() %></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
	</div>
         </div>  
              
            </div>
                
                <div class="bt_wrap">
                    <a href="/hallo03talk/party/write" class="on">등록</a>
                </div>
                
            </div>
        </div>
	<script>
		$(function(){
			$('#table-main>tbody>tr').click(function(){
				//행 클릭 되었을 때, 동작할 내용
				
				//글 번호 가져오기
				const num = $(this).children().eq(0).text();
				//해당 번호 이용해서 요청 보내기
				location.href='/semi/notice/detail?num=' + num;
			});
		})
	</script>
					</div>
			</main>


	<footer></footer>


</body>
</html>




    

    



	
    
		

    	
   



	
	

</body>
</html>
