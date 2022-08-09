<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
        .form-wrap {
            /* width: 380px; */
            width: 500px;
            height: 780px;
            position: relative;
            margin: auto;
            margin-top: 120px;
            margin-bottom: 120px;
            border-radius: 25px;
            padding: 5px;
            overflow: hidden;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        
        .button-wrap {
            width: 230px;
            margin: 35px auto;
            position: relative;
            box-shadow: 0 0 600px 9px #fcae8f;
            border-radius: 30px;
            top: 60px;
        }
        .togglebtn {
            padding: 5px;
            width: 100px;
            cursor: pointer;
            background: transparent;
            border: 0;
            outline: none;
            position: relative;
        }
        .togglebtn:hover{
          color: white;
        }
        #btn {
            top: 0;
            left: 0;
            position: absolute;
            width: 110px;
            height: 100%;
            background-color: rgb(233, 187, 100);
            border-radius: 6px;
            transition: .5s;
        }
        
    
        .input-group {
            top: 80px;
            /* position: absolute; */
            height: 0px;
            transition: .5s;
            margin-left: 50px;
            /* background-color: pink; */
        }
        
        .input-field {
            width: 100%;
            padding: 10px 0;
            margin: 5px 0;
            border: none;
            border-bottom: 1px solid #999;
            outline: none;
            background: transparent;
        }
        
        /* 회원가입 버튼 */
        .join {
            width: 100%;
            padding: 10px 30px;
            cursor: pointer;
            display: block;
            margin: auto;
            background-color: rgb(233, 187, 100);
            color: white;
            border: 0;
            outline: none;
            border-radius: 6px;
            margin-top: 30px;
        }
        
        #gender_table{
            margin-top: 13px;
        }
        
        #login {
            left: 50px;
        }
        
        #register {
            left: 450px;
        } 
        #doubleCheck{
            border: 0;
            border-radius: 6px;
            width: 80px;
            background-color: rgb(233, 187, 100);
            color: white;
        }
        #doubleCheck:hover, .join:hover{
          background-color: skyblue;
        }
        
     .ggg{
        /* border: 2px solid red; */
        width: 300px;
     }
     </style>


</head>
<body>


			<%@ include file="/views/common/header.jsp"%>
			
			
			 <main>
			      <div id="container" class="container-xxl">
			      
			
			        <!-- 내가 작성 한 부분 -->  
			        <div class="wrap">
			            
			            <div class="form-wrap">
			                <!-- <div class="logo">할로영삼talk</div> -->
			                
			                <div class="button-wrap">
			                    <div id="btn"></div>
			                    <button type="button" class="togglebtn" onclick="login()">일반회원</button>
			                    <button type="button" class="togglebtn" onclick="register()">사장님</button>
			                </div>
			                
			                <!-- --------------- 일반회원 ---------------------- -->
			                  <form action="/semiPracticeSiyeong/traveler/join" method="post">   
			              
			                    <div id="login" action="" class="input-group">
			                        <div class="ggg">
			                            <table>
			                                <tr>
			                                    <td><input type="text" name="travelerJoinId" class="input-field" placeholder="아이디" required></td>
			                                    <td style="padding-left: 30px;"><button id="doubleCheck">중복확인</button></td>
			                                </tr>
			                            </table>
			                          
			                            <input type="password" name="travelerJoinPwd" class="input-field" placeholder="비밀번호" required>
			                            <input type="password" name="travelerJoinPwd2" class="input-field" placeholder="비밀번호 확인" required>
			                            <input type="text" name="travelerJoinName" class="input-field" placeholder="이름" required>
			        
			                            <table>
			                                <tr>
			                                    <td><input type="text" name="travelerJoinNick" class="input-field" placeholder="닉네임"></td>
			                                    <td style="padding-left: 30px;"><button id="doubleCheck">중복확인</button></td>
			                                </tr>
			                            </table>
			                           
			                            <table id="gender_table">
			                                <tr> 
			                                    <td style="padding-right: 30px; color: gray;">성별</td>
			                                    
			                                    <td style="padding-right: 10px;">
			                                    	<input type="radio" name="travelerJoinGender" value="man" required>남
			                                    </td>
			                                    <td>
			                                    	<input type="radio" name="travelerJoinGender" value="woman" required>여
			                                    </td>
			                                    
			                                </tr>
			                            </table>
			        
			                            <input type="tel" name="travelerJoinPhone" class="input-field" placeholder="전화번호" required>
			                            <input type="email" name="travelerJoinEmail" class="input-field" placeholder="이메일" required>
			                            <button type="submit" class="join">회원가입</button>
			                        </div>
			        
			                    </div>
							</form>
			
			                     <!-- ---------------사장님 ---------------------- -->
			             <form action="/semiPracticeSiyeong/boss/join" method="post">   
			                     
			                <div id="register" action="" class="input-group">
			                    <div class="ggg">
			                        <table>
			                            <tr>
			                                <td><input type="text" name="bossJoinId" class="input-field" placeholder="아이디" required></td>
			                                <td style="padding-left: 30px;"><button id="doubleCheck">중복확인</button></td>
			                            </tr>
			                        </table>
			                      
			                        <input type="password" name="bossJoinPwd" class="input-field" placeholder="비밀번호" required>
			                        <input type="password" name="bossJoinPwd2" class="input-field" placeholder="비밀번호 확인" required>
			    
			                        <table>
			                            <tr>
			                                <td><input type="text" name="bossJoinNick" class="input-field" placeholder="닉네임" required></td>
			                                <td style="padding-left: 30px;"><button id="doubleCheck">중복확인</button></td>
			                            </tr>
			                        </table>
			                       
			                        <table id="gender_table">
			                            <tr> 
			                                <td style="padding-right: 30px; color: gray;">성별</td>
			                                <td style="padding-right: 10px;"><input type="radio" name="bossJoinGender" value="man" required>남</td>
			                                <td><input type="radio" name="bossJoinGender" value="woman" required>여</td>
			                            </tr>
			                        </table>
			    
			                        <input type="text" name="bossJoinStore" class="input-field" placeholder="가게 이름" required>
			                        <input type="tel" name="bossJoinPhone" class="input-field" placeholder="가게 전화번호" required>
			                        <input type="email" name="bossJoinEmail" class="input-field" placeholder="이메일" required>
			                        <button type="submit" class="join">회원가입</button>
			                    </div>
			                </div>
			             </form>  
			
			               
			            </div>
			        </div>
			
			        <script>
			            var x = document.getElementById("login");
			            var y = document.getElementById("register");
			            var z = document.getElementById("btn");
			            
			            
			            function login(){
			                x.style.left = "50px";
			                y.style.left = "450px";
			                z.style.left = "0";
			            }
			    
			            function register(){
			                x.style.left = "-400px";
			                y.style.left = "50px";
			                z.style.left = "110px";
			            }
			        </script>
			
					<!-- </form> -->
			
			      </div>
			      
		      
		    </main>
					
			
			
			
			<footer></footer>
			
	

</body>
</html>