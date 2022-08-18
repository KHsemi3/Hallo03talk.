<%@page import="com.h3.traveler.vo.MyPageVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     
 <%
  	ArrayList<MyPageVo> voList = (ArrayList<MyPageVo>)request.getAttribute("voList");
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
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/views/member/traveler/travelerInformationForm.jsp">내 정보</a>
                              </li>
                              <li class="nav-item" style="background-color: rgba(0, 0, 0, 0.2); border-radius: 5px;">
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/views/member/traveler/travelerDoRePortView.jsp">내가 쓴 글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="">내가 쓴 댓글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="#">예약 내역</a>
                              </li>
                              
                              <li class="nav-item">
                                <a class="nav-link" href="#">찜 목록</a>
                              </li>
                            
                              <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                  신고
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                  <li><a class="dropdown-item" href="">신고 한 내역</a></li>
                                  <li><a class="dropdown-item" href="">신고 받은 내역</a></li>
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
                    <th scope="col" class="text-center" style="width: 20%;">게시판</th>
                  <th scope="col" class="text-center" style="width: 50%;">제목</th>
                  <th scope="col" class="text-center" style="width: 20%;">작성일</th>
                </tr>
              </thead>

              <tbody>
               <%for(int i=0; i < voList.size(); i++){ %> 
	                <tr>
		                  <th scope="row">
		                    <input type="checkbox" name="ckNo" value="<%= voList.get(i).getBoard().concat(",").concat(voList.get(i).getNo()) %>">
		                  </th>
		                 	<th scope="row"><%=voList.get(i).getNo() %></th>                    <!-- 번호 - 글 순서 -->
		                  	<td ><%=voList.get(i).getBoard() %></td>  	
		                  	<td ><%=voList.get(i).getTitle() %></td>  							<!-- 글 제목 -->
		                  	<td class="text-center"><%=voList.get(i).getEnrollDate() %></td>	<!-- 글 작성일-->
	                </tr>
               <%}%>
              </tbody>
<!-- -------------------------------------------------------------- -->
            </table>

    

<!-- -------------------------------------------------------- -->
        </div>
    </main>
    
    
<footer></footer> 

<script>
$(document).ready(function() {
	// crating new click event for save button
	
	$(".deleteButtonAll").click(function(e) {
		$('input:checkbox[name="ckNo"]').each(function() {

			this.checked = true;

			});
	})
	
	$(".deleteButton").click(function(e) {
	//	var dataList = new Array()
		$('input:checkbox[name=ckNo]').each(function (index) {

			if($(this).is(":checked")==true){
		    	console.log($(this).val());
		    	var query = $(this).val()
		    	var data = query.split(",")
		    	
		    	data = {
		    		"board" : data[0],
		    		"no" : data[1]
		    	} 
		    	
		    	console.log(data)
		    	
		    	var ans = confirm("선택하신 글을 삭제하시겠습니까?");
	        if(!ans) return false;
	        
	        var url = "${pageContext.request.contextPath}/travelerMpgPost/delete"
	        
	         $.ajax({
	            url  : url,
	            type : "post",
	            data : data ,
	            success : function(data) {
	                  alert("댓글이 삭제 되었습니다.");
	                  location.reload();
	            },
	            error : function(data) {
	                alert("댓글이 삭제되지 않았습니다.");
	            }
	        }); 
		    	
		    //	dataList.push(data)
		    		
		    }
		
		})
		
		//var paramList = {
		//	"paramList" : JSON.stringify(dataList)
		//}	
		
	})
});
</script>

</body>
</html>