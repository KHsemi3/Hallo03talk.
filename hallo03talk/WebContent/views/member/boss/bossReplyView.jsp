<%@page import="com.h3.placeReview.vo.PlaceReviewVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
<%
        ArrayList<PlaceReviewVo> voList = (ArrayList<PlaceReviewVo>)request.getAttribute("voList");
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
#reviewTable{
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
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/boss/myPage">내 정보</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/bossMpgPost/list">내가 쓴 글</a>
                              </li>
                              <li class="nav-item" style="background-color: rgba(0, 0, 0, 0.2); border-radius: 5px;">
                                <a class="nav-link" href="/hallo03talk/bossMpgReply/list">내가 쓴 답글</a>
                              </li>
                            </ul>
                      </div>
                </div>
              </nav>

               <!-- -------삭제 버튼-------------- -->
     
               <div class="deleteCheck">
                <button class="deleteButton">전체 선택</button>
                <button class="deleteButton" style="margin-left: 10px;">삭제</button> 
              </div>

              <!-- ------내가 쓴 답글-------------------------------------------------------- -->
                
            <table class="table table-hover" id="reviewTable">
                <thead>
                  <tr>
                    <th scope="col" style="width: 5%;"></th>        
                    <th scope="col" style="width: 5%;">#</th>
                    <th scope="col" class="text-center" style="width: 70%;">답글</th>
                    <th scope="col" class="text-center" style="width: 20%;">작성일</th>
                  </tr>
                </thead>

<!-- -------------------------------------------------------------- -->

                <tbody>
              		<%for(int i=0; i < voList.size(); i++){ %>  
                  <tr>
                    <th scope="row">
                      <input type="checkbox">
                    </th>
                    <th scope="row"><%=voList.get(i).getNo() %></th>
                    <td><%=voList.get(i).getContent() %></td>
                    <td class="text-center"><%=voList.get(i).getEnrollDate() %></td>
                  </tr>     
                   <%}%>
                </tbody>
<!-- -------------------------------------------------------------- -->
              </table>

    

<!-- -------------------------------------------------------- -->
        </div>
    </main>
	
    <footer></footer>


</body>
</html>