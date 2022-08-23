<%@page import="com.h3.reportUser.vo.ReportUserVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<ReportUserVo> voList = (ArrayList<ReportUserVo>)request.getAttribute("voList");
    %>
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
      width: 1270px;
      height:100%;
      box-sizing: border-box;
      padding:15px;
      margin: auto	;
      
    }

    .board {
     
      height:100%;
    }

    .report-board-table {
     
    }

    .report-board-table th {
      text-align: center!important;
      width: 310px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
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
    margin-top:60px;
    text-align:center;
   
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

-ms-transform: scale(2); /* IE */

-moz-transform: scale(2); /* FF */

-webkit-transform: scale(2); /* Safari and Chrome */

-o-transform: scale(2); /* Opera */

padding: 10px;

}
thead tr:nth:child(2):hover{
opacity:0.5;
}
</style>

</head>

<body>


			<%@ include file="/views/common/header.jsp"%>

			<main>
					<div id="container" class="container-xxl">

					
		<ul>
	<li id="reportImg"><img src="<%=request.getContextPath()%>/resources/img/report.png" alt="" /> 신고 게시글 관리</li>
</ul>			
<hr />
<div class="right-nav">
	
  <div class="board">
    <table class="report-board-table">
      <thead>
      <tr>
       <th width="15">신고번호</th>
        <th width="30">신고유저</th>
        <th width="30">신고제목</th>
        <th width="25">신고날짜</th>
      </tr>
      </thead>
      <tbody>
      <tr>
      
        <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      
       <form action="/multipleDel" method="post" id=multidel>
        <%
		for(int i = 0; i<voList.size(); i++){
		%>
		<tr>
			<th><input class="check"type="checkbox" name="num" value="<%=voList.get(i).getNo()%>"  /><%=voList.get(i).getNo()%></th>
			
			<th><%=voList.get(i).getReportUserId()%></th>
			<th><%=voList.get(i).getGuilty()%></th>
			<th><%=voList.get(i).getContent()%><th>
			
			
		</tr>
	
		<%} %>
      
      <tr>
        <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
       <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
       <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
       <th><input class="check"type="checkbox" name="check"  />데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터1</th>
      </tr>
      </tbody>
    </table>
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
                <span onclick="location.href='/hallo03talk/admin/reportUserDelete?num=1'"> 신고목록 삭제</span>
                <span> 페널티 부여</span>
               </div>
              
     </div>
     </form>
   <br />
    <br />
    <hr />
  </div>
 
    
</div>
					

					</div>
			</main>


	<footer></footer>

</body>
</html>