<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>할로영삼talk</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <!--head 태그 내 추가-->
    <link rel="icon" href="resources/img/favi.png">
<style>
    @font-face {
    font-family: 'Somi';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/Somi.woff') format('woff');
    font-weight: normal;
    font-style: normal;

}
@font-face {
    font-family: 'KyoboHandwriting2020A';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2112@1.0/KyoboHandwriting2020A.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}


    *{
        margin:0; padding: 0;}
        html, body{height: 100%;}
    #img{
        position:absolute;
        background-size: cover;
        width: 100%;
        height: 100%;
        z-index: -10;
        filter: brightness(30%); 
        
    }
    a{
        text-decoration: none;
        color: #fff;
    }
    body{
                
                color: white;
                margin: 0;
                padding: 0;
                font-size: 1.2em;
                font-family: 'Hack';
            }
            header{
               
               
                padding: 20px;
            }
            section {
               
                padding: 20px;
                color: black;
                display: flex;
                flex-direction: row-reverse;
            }
           

            section > div {
              
                margin: auto;
                width: 150px;
                height: 70px;
                padding: 10px;
            }
            ul{
                margin: 0;
                padding: 0;
                list-style-type: none;
                float: right;
            }
            li{
                display: inline;
                margin: 0 20px 0 0 ;
               
            }

          
            #canvas_section{
                display: block;
            }

            #canvas {
                margin: 10px;
                padding: 10px;
              
                border: thin inset #aaaaaa;
            }

            #logo h1 {
                font-family: 'Somi';
                font-weight: normal;
                margin-left: 20px;
            }
            .menu1 li a:hover{
                opacity: 0.5;
            }
            #middle{
                font-family: 'Somi';
                color:#fff;
                font-size: 70px;
                width: 400px;
                margin-top: 70px;
                
            }
            #middle2{
                
                width: 100%;
                padding-top: 40px;
                justify-content: center;
                margin: auto;
                text-align: center;
                font-family: 'KyoboHandwriting2020A';
                letter-spacing: 10px;
                text-shadow: 10px 10px 10px gray;
            }
            .search-box{
                padding: 10px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                height: 30px;
                background-color: #fff;
                margin-top: 100px;
                opacity: 0.5;
                border-radius: 30px;
                transition: 0.4s;
                width: 682px;
}




.search-btn{
  text-decoration: none;
  float: right;
  width: 30px;
  height: 30px;
  background-color: #fff;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #51e3d4;
}

.search-txt{
  display: flex;
  padding: 0;
  width: 0px;
  border:none;
  background: none;
  outline: none;
  float: left;
  font-size: 1rem;
  line-height: 30px;
  transition: .4s;
}
.search-box > .search-txt{
  width: 640px;
  padding: 0 6px;
}
#footer{
    font-family: 'KyoboHandwriting2020A';
    width: 68%;
    margin-top: 200px;
    font-size: 26px;
}
#footer ul li{
    margin-left: 60px;
    margin-right: 60px;
}
#footer ul li:hover{
    opacity: 0.5;
}
            

</style>

</head>
<body>
    <img id="img" src="resources/img/jeju.jpg" alt="">
    <header>
        <nav>
            <ul class="menu1">
                <li><a href="">공지사항</a></li>
                <li><a href="">로그인</a></li>
                <li><a href="">회원가입</a></li>
            </ul>
        </nav>
        <div id="logo"><h1><a href="">할로영삼talk</a></h1></div>
     
    </header>
    <section id="tripple">
        
        <div id="middle">할로영삼 talk</div>
        
        
    </section>
        <div id="middle2">제주 여행을 위한 여행자들의 커뮤니티 공간
                <br>직접 여행자가 되어서 함께 해주세요!

        </div>
        <div class="search-box">
            <input type="text" class="search-txt" name="focus"placeholder="Type to search">
            <a class="search-btn" href="#">
              <i class="fas fa-search"></i>
            </a>
          </div>
          
       
        <div id="footer">
            <ul>
             |<li><a href="">동행</a></li>| 

              <li><a href="">장소</a></li>| 
              <li><a href="">이벤트</a></li>|
            </ul>
           
            </div>
   
   
</body>
</html>