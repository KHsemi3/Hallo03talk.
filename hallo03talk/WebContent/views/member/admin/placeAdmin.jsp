<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 @font-face {
        font-family: "Somi";
        src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/Somi.woff")
          format("woff");
        font-weight: normal;
        font-style: normal;
      }
    .right-nav {
      width: 80%;
      height:100%;
      box-sizing: border-box;
      padding:15px;
      margin: auto	;
      
    }

    .board {
      width:100%;
      height:100%;
    }

    .report-board-table {
      width:100%;
    }

    .report-board-table th {
      text-align: center!important;
    }

    thead {
      background:white;
    }

    thead > tr {
      height:55px;
    }

    tbody > tr {
      background:sandybrown;
      border-bottom: 3px solid white;
      height:35px;
      color:white;
    }
    li{
    list-style:none;
    }
    #reportImg img{
    	width: 40px;
    	height: 40px;
    }
     #reportImg {
    	 font-family: "Somi";
    	 margin-left:500px;
    	 font-size:40px;
    }
    #page a{
    display:inline-block;
    width: 27px;
    border-radius:5px;
    border:1px solid orange;
    text-decoration:none;
    text-align:center;
     color:orange;
    }
    #page{
    margin-top: -180px;
    text-align: center;
   
    }
    .btn-area{
    float:right;}
    .btn-area span{
    border:1px solid orange;
    border-radius:5px;
    display:inline-block;
    height:30px;
    cursor:pointer;
    color:#fff;
    background-color: #ff9f40;
    }
    .check{
    margin-right:20px;
    width: 20px;
    }
   input[type=checkbox] {
margin:0;
padding:0;
-ms-transform: scale(2); /* IE */

-moz-transform: scale(2); /* FF */

-webkit-transform: scale(2); /* Safari and Chrome */
margin-left:10px;
margin-top:10px;





}
thead tr:nth:child(2):hover{
opacity:0.5;
}
.right-nav {
      width:80%;
      height:100%;
      box-sizing: border-box;
      padding:15px;
      margin:auto;
     
    }

    .board {
      width:100%;
      height:100%;
    }

    .acc-board-table {
      width:100%;
    }

    .acc-data {
      width:170px;
      height:280px;
      border:1px solid darkgray;
      float:left;
      margin-right:15px;
    }

    .acc-image-area {
      width:170px;
      height:170px;
    }

    .acc-img {
      width:100%;
      height:100%;
    }

    .acc-info {
      width:100%;
      height:80px;
      margin-top:30px;
    }

    .acc-title,.acc-sub-data  {
      width:100%;
      height:50%;
    }

    .acc-col{
      width:50%;
      height:50%;
      float:left;
    }
	.acc-col img{
	margin-left: 5px;
	margin-right: 5px;
	margin-bottom:5px;
	width: 20px;
	height: 20px;
	}
</style>

</head>

<body>


			<%@ include file="/views/common/header.jsp"%>

			<main>
					<div id="container" class="container-xxl">

					
		<ul>
	<li id="reportImg"><img src="../../../resources/img/house.png" alt="" />숙소관리</li>
</ul>			
<hr />
<div class="right-nav">
  <div class="board">
    <div class="acc-board-table">
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
          <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">애월하미</div>
          <div class="acc-sub-data">
            <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />4</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">222</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
         <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">플레이스 인 제주</div>
          <div class="acc-sub-data">
            <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />3</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">44</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
         <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
        
          <div class="acc-title">함덕 해수욕장</div>
          <div class="acc-sub-data">
           <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />5</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">300</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
         <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">딱새우김밥</div>
          <div class="acc-sub-data">
           <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />5</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">400</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
          <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">훈남횟집</div>
          <div class="acc-sub-data">
           <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />3</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">4433</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
         <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">톳라면 분식</div>
          <div class="acc-sub-data">
           <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />5</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">332</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
          <img class="acc-img" src="../../../resources/img/coffee.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">섭지코지 카페</div>
          <div class="acc-sub-data">
            <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />333</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">22</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
         <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">카카오 본사</div>
          <div class="acc-sub-data">
           <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />22</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">333</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
         <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">kh 정보교육원</div>
          <div class="acc-sub-data">
           <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />-5</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">-332</div>
          </div>
        </div>
      </div>
      <div class="acc-data">
        <div class="acc-image-area">
        <input type="checkbox" />
         <img class="acc-img" src="../../../resources/img/house_2.png"/>
        </div>
        <div class="acc-info">
          <div class="acc-title">우도 돈까스</div>
          <div class="acc-sub-data">
           <div class="acc-col"><img src="../../../resources/img/star.png" alt="" />5</div>
            <div class="acc-col"><img src="../../../resources/img/good.png">122</div>
          </div>
        </div>
      </div>
    </div>
    
  </div>
</div>
 <div id="page">
     <a href=""> &lt;</a>
     <a href="">1</a>
      <a href="">2</a>
       <a href="">3</a>
        <a href="">4</a>
         <a href="">5</a>
          <a href="">6</a>
           <a href="">7</a>
            <a href="">8</a>
             <a href="">9</a>
              <a href="">10</a>
               <a href="">&gt;</a>
               <div class="btn-area">
                <span> 숙소 삭제</span>
                
               </div>
              
     </div>
					

					</div>
			</main>


	<footer></footer>

</body>
</html>