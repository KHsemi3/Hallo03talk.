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
                                <a class="nav-link active" aria-current="page" href="/hallo03talk/traveler/myPage">내 정보</a>
                              </li>
                              <li class="nav-item">
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
                                <a class="nav-link dropdown-toggle" style="background-color: rgba(0, 0, 0, 0.2); border-radius: 5px;" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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

<!-- ---------------------------------------------------------------------------------------- -->
                <tbody>
                    <tr data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <th scope="row">
                          <input type="checkbox">
                        </th>
                        <th scope="row">1</th>
                        <td >욕설</td>
                        <td class="text-center">22.05.05</td>
                    </tr>
                </tbody>
<!-- -------------------------------------------------------------- -->
              </table>
          

        </div>
        
        
    </main>
    
    <!-- --------행 클릭하면 해당 내용 보이기------------------------------ -->
   
    
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
		
	
	<!-- ------------------------------------------------------------------ -->
	
	
    <footer></footer> 
	


</body>
</html>