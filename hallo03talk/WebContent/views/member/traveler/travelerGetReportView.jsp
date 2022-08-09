<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
/* ------신고 테이블----------------------------------------------------------------------------- */
#getTable{
    margin-top: 30px;
}
/* ----------------------------------------------------------- */
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
                                <a class="nav-link active" aria-current="page" href="세미실전_일반회원_마이페이지(메뉴바,내정보).html">내 정보</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="세미실전_일반회원_마이페이지(내가 쓴 글).html">내가 쓴 글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="세미실전_일반회원_마이페이지(내가쓴댓글).html">내가 쓴 댓글</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="#">예약 내역</a>
                              </li>
                              
                              <li class="nav-item">
                                <a class="nav-link" href="#">찜 목록</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" href="#">좋아요 목록</a>
                              </li>
                              <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                  신고
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                  <li><a class="dropdown-item" href="세미실전_일반회원_마이페이지(신고한내역).html">신고 한 내역</a></li>
                                  <li><a class="dropdown-item" href="세미실전_일반회원_마이페이지(신고받은내역).html">신고 받은 내역</a></li>
                                </ul>
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

              <!-- ------신고 받은 내역-------------------------------------------------------- -->
                
            <table class="table table-hover" id="getTable">
                <thead>
                  <tr>
                    <th scope="col" style="width: 5%;"></th>
                    <th scope="col" style="width: 5%;">#</th>
                    <th scope="col" style="width: 80%;">신고 항목</th>
                    <th scope="col" class="text-center" style="width: 10%;">날짜</th>
                  </tr>
                </thead>

<!-- ---------------여기서부터는 noticeList처럼 백엔드 코드로 작성해야 함----------------------------------------------- -->
                <tbody>
                    <tr>
                        <th scope="row">
                          <input type="checkbox">
                        </th>
                        <th scope="row">1</th>
                        <td >욕설</td>
                        <td class="text-center">22.05.05</td>
                    </tr>

                    <tr>
                      <th scope="row">
                        <input type="checkbox">
                      </th>
                      <th scope="row">2</th>
                      <td >광고성 게시글</td>
                      <td class="text-center">22.07.25</td>
                  </tr>
                   
                </tbody>
<!-- -------------------------------------------------------------- -->
              </table>
          

    

<!-- -------------------------------------------------------- -->
        </div>
    </main>
    
    <footer></footer> 
	


</body>
</html>