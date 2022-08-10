<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>

  <style>
    .right-nav {
      width:75%;
      height:100%;
      box-sizing: border-box;
      padding:15px;
      float:left;
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

  </style>

</head>


<div class="right-nav">
  <div class="board">
    <table class="report-board-table">
      <thead>
      <tr>
        <th width="15">컬럼1</th>
        <th width="30">컬럼2</th>
        <th width="30">컬럼3</th>
        <th width="25">컬럼4</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <th>데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th>데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th>데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th>데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      <tr>
        <th>데이터1</th>
        <th>데이터2</th>
        <th>데이터3</th>
        <th>데이터4</th>
      </tr>
      </tbody>
    </table>
  </div>
</div>

</html>