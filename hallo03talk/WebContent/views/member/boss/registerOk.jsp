<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
    // 팝업창 닫기
    $(document).ready(function() {
      $('#btn_submit').ajaxForm(function() {
        alert("인증되었습니다!");
        self.close();
      });
   });
 </script> 
</body>
</html>