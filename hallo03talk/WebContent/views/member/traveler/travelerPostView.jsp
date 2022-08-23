<%@page import="com.h3.traveler.vo.MpgPostVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     
 <%
      ArrayList<MpgPostVo> voList = (ArrayList<MpgPostVo>)request.getAttribute("voList");
 %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
      /*할로영삼talk 폰트*/
      @font-face {
            font-family: 'Somi';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/Somi.woff') format('woff');
            font-weight: normal;
            font-style: normal;     
      }
      #MyPageText{
        font-family: 'Somi';
        font-size: 50px;
        margin-top:-20px;
      }
      .content{
        padding: 150px;
      }
     
/* --------네비게이션 바------------------------------------------------------------------- */
  
.navbar{
  margin-top: 60px;  
}
/* ----삭제버튼------------------------ */
.deleteCheck{
    margin-top: 60px;
}
.deleteButton{
  border: 1px solid gray;
  border-radius: 2px;
}
/* ------내가 쓴 글----------------------------------------------------------------------------- */
#writeTable{
    margin-top: 30px;
}
    </style>

</head>
<body>

	<%@ include file="/views/common/header.jsp"%>
	
	 <main>
        <!--하얀색-->
      <div id="container" class="container-xxl">

          <!-- 내가 작성 한 부분 -->     
          
          <div class="content">
              <div align="center" id="MyPageText">My Page</div> 

              <!-- 네비게이션 바 -->
              <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">      
                      <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <ul class="navbar-nav">
                              <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/traveler/myPage">내 정보</a>
                              </li>
                              <li class="nav-item" style="background-color: rgba(0, 0, 0, 0.2); border-radius: 5px;">
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/travelerMpgPost/list">내가 쓴 글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/travelerMpgReply/list">내가 쓴 댓글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/travelerMpgRsv/list">예약 내역</a>
                              </li>
                              
                              <li class="nav-item">
                                <a class="nav-link" href="/hallo03talk/travelerMpgZzim/list">찜 목록</a>
                              </li>
                            
                              <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                  신고
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                  <li><a class="dropdown-item" href="/hallo03talk/traveler/getReport">신고 받은 내역</a></li>
                                </ul>
                              </li>
                            </ul>
                      </div>
                </div>
              </nav>

            <!-- -------삭제 버튼-------------- -->
     
            <div class="deleteCheck">
              <button class="deleteButtonAll">전체 선택</button>
              <button class="deleteButton" style="margin-left: 10px">삭제</button> 
            </div>

            <!-- ------내가 쓴 글-------------------------------------------------------- -->
              
          <table class="table table-hover" id="writeTable">
              <thead>
             
                <tr>
                  <th scope="col" style="width: 5%;"></th>
                  <th scope="col" style="width: 5%;">#</th>
                    <th scope="col" style="width: 20%;">게시판</th>
                  <th scope="col"  style="width: 50%;">제목</th>
                  <th scope="col" class="text-center" style="width: 20%;">작성일</th>
                </tr>
              </thead>

              <tbody>
               <%for(int i=0; i < voList.size(); i++){ %> 
	                <tr>
		                  <th scope="row">
		                  <!-- 인풋 엘리먼트의 밸류 프로퍼티에 어떤 게시물인지 밸류 값 주기 -->
		                  <!-- 모든 게시물이 한 곳에 표시되므로 게시물 번호뿐만 아니라 게시판 이름 그리고 ', ' 문자와 함께 조합하여 줌 -->
		                    <input type="checkbox" name="ckNo" value="<%= voList.get(i).getBoard().concat(",").concat(voList.get(i).getNo()) %>">
		                  </th>
		                 	<th scope="row"><%=voList.get(i).getNo() %></th>                   
		                  	<td ><%=voList.get(i).getBoard() %></td>  	
		                  	<td ><%=voList.get(i).getTitle() %></td>  						
		                  	<td class="text-center"><%=voList.get(i).getEnrollDate() %></td>	
	                </tr>
               <%}%>
              </tbody>
<!-- -------------------------------------------------------------- -->
            </table>

    

<!-- -------------------------------------------------------- -->
        </div>
    </main>
    
       <!-- --------행 클릭하면 해당 내용 보이기------------------------------ -->
   
<script>
/* 		$(function(){
			$('#writeTable>tbody>tr').click(function(){
				//행 클릭 되었을 때, 동작할 내용
				//글 번호 가져오기
				const num = $(this).children().eq(1).text();
				
				//해당 번호 이용해서 요청 보내기
				//alert(num);				
				location.href='/hallo03talk/traveler/travelerPostDetail?num=' + num;
				
				//location.href='/hallo03talk/with/detail?no=1';

				
			});
		}) */
	</script>
	
	
	<!-- ------------------------------------------------------------------ -->
	 
<footer></footer> 

<!-- -------------------------------------------------------- -->

<script>

	// 전체 삭제 체크박스
	$(".deleteButtonAll").click(function(e) {
		// 인풋 체크박스 name이 chNo인 엘리먼트 각각 꺼내오기
		$('input:checkbox[name="ckNo"]').each(function() {
			// 엘리먼트의 checked 프로퍼티값 할당
			// ex) checked가 true라면 !true 즉 false값 할당됨
			this.checked = !this.checked;
		});	
	}) 
	
	// 삭제 체크 박스 
	$(".deleteButton").click(function(e) {
		// 다중 선택할수도 있으므로 array 생성
		var arr = []
		
		// 인풋 체크박스 name이 chNo인 엘리먼트 각각 꺼내오기
		$('input:checkbox[name=ckNo]').each(function (index) {
			// 체크된 엘리먼트 
			if($(this).is(":checked")==true){
		    	console.log($(this).val());
		    	
		    	// query에 엘리먼트의 밸류 할당("게시판이름, 게시판번호")
		    	var query = $(this).val()
		    	// data array에 게시판이름, 게시판 번호를 할당
		    	var data = query.split(",") 
		    	
		    	// data에 key:value 형식으로 게시물 정보 할당
		    	data = {
		    		"board" : data[0],
		    		"no" : data[1]
		    	} 
		    	
		    	// array에 담기
		   		arr.push(data)
		    	
			}
		    	console.log(arr)
		 })
		 
		 // 만약 선택한 게시물이 있다면 + 컨펌창을 한번만 띄우기 위해 for문 밖에서 함
		 if(arr.length> 0){
			 var ans = confirm("선택하신 글을 삭제하시겠습니까?");
		        
			 	if(ans){
			 		// 삭제 완료 alert창을 한번만 띄우기 위한 flag 
		        	var flag = false;
					
			 		// 선택한 게시물s 만큼 loop
			 		for(i=0; i< arr.length; i++){ 
						 var value = arr[i] // 게시물 정보 하나
						 console.log(value)
						 
						 var url = "${pageContext.request.contextPath}/travelerMpgPost/delete"
						 
					     $.ajax({
					       url  : url,
					       type : "post",
					       data : value ,
					       success : function(data) {
					    	 	// flag 값을 성공실패 여부에 따라 값을 할당해주려고 했으나 할당 안됨
					        	// flag = true;
					            alert("글이 삭제 되었습니다.");
					            location.reload();
					       }, error : function(data) {
					       		// flag = false;
					          	alert("글이 삭제되지 않았습니다.");
					       }
					        });  
						}
						
			 		// 성공 실패 여부에 따라 분기처리하려했으나 에이젝스 내부에서 값 할당이 안되므로 주석처리
						/* if(flag){
						  alert("글이 삭제 되었습니다.");
			              location.reload();
						}else{
							alert("글이 삭제되지 않았습니다.");
						} */
		        	
		        }else {
		        	return false;
		        } 
		 }
			 
			 
		
		    
		
	        
	      
		    	
		    		
		   
		
				
		
	})
/* }); */
</script>

</body>
</html>