<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>


</head>
<body>

    <%@ include file="/views/common/header.jsp"%>

    <main>
        <div id="container" class="container-xxl">

            <br><br>
            <div class="text" style=" width: 50%;float: left;">
                <h1 style="margin-left: 60px;"><b>검색</b></h1>
            </div>
            <br><br><br>
            <input type="text" name="keyword" value="" style="width: 90%; height: 50px; border-radius: 10px; border: 1px solid gray; margin-left: 5%;" placeholder="  검색어를 입력하세요.">
            <br><br>
    
    
    
                    <!-- 네비게이션 바 -->
                    <ul class="nav nav-tabs" id="myTab" role="tablist" style="margin-left: 60px; margin-right: 60px;">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="Information-tab" data-bs-toggle="tab" data-bs-target="#Information" type="button" role="tab" aria-controls="Information" aria-selected="true">장소</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="post-tab" data-bs-toggle="tab" data-bs-target="#post" type="button" role="tab" aria-controls="post" aria-selected="false">동행</button>
                    </li>
                </ul>
                
                
                <div class="tab-content" id="myTabContent">
                
                    <!-- -------장소--------------------------------------------------------------------------------------- -->

                    <div class="tab-pane fade show active" id="Information" role="tabpanel" aria-labelledby="report-tab">   
                            <!-- 장소 카테고리들 -->
                            <div id="place-finder" class="fw-bolder text-center mt-5">
                            <div class="row border border-4" style="width: 90%; margin: 0 auto;">
                                <div class="row">
                                <div class="col-2 in-place border-end border-3 " id="hotel" value = "hotel">숙소</div>
                                <div class="col-2 border-end border-3" value ="jeju">제주</div>
                                <!-- 제주시 -->
                                <div class="col in-jeju" value = "sine">시내</div>
                                <div class="col in-jeju" value = "aewol">애월</div>
                                <div class="col in-jeju" value = "hanrim">한림</div>

                                <!-- 서귀포 -->
                                <div class="col in-seogwipo d-none" value = "sine">시내</div>
                                <div class="col in-seogwipo d-none" value = "namwon">남원</div>
                                <div class="col in-seogwipo d-none" value = "andock">안덕</div>
                                </div>
                                <div class="row">
                                <div class="col-2 in-place border-end border-3" id="food" value = "foods">맛집</div>
                                <div class="col-2 border-end border-3" id="seogwipo" value = "seoguipo">서귀포</div>
                                <!-- 제주시 -->
                                <div class="col in-jeju" value = "hangeong">한경</div>
                                <div class="col in-jeju" value = "jocheon">조천</div>
                                <div class="col in-jeju" value = "gujwa">구좌</div>
                                <!-- 서귀포 -->
                                <div class="col in-seogwipo d-none" value = "daejung">대정</div>
                                <div class="col in-seogwipo d-none" value = "pyoseon">표선</div>
                                <div class="col in-seogwipo d-none" value = "sungsan">성산</div>
                                </div>
                                <div class="row">
                                <div class="col-2 border-end border-3" id="cafe" value = "cafe">카페</div>
                                <div class="col-2 border-end border-3"></div>
                                </div>
                            </div>
                            </div>
                        
                        
                        <script>

                            // 선택시 색 변경, 읍면동 변경, 동행/장소 카테고리 변경
                            const place = document.querySelector("#place");
                            const together = document.querySelector("#together");


                            const hotel = document.querySelector("#hotel");
                            const food = document.querySelector("#food");
                            const cafe = document.querySelector("#cafe");


                            const jeju = document.querySelector("#jeju");
                            const seogwipo = document.querySelector("#seogwipo");
                            const injeju = document.querySelectorAll(".in-jeju");
                            const inseogwipo = document.querySelectorAll(".in-seogwipo");



                            //탭 바뀌는것
                            //toggle for form & badge
                            $(".js-switch").click(function() {
                            $(".main-content").toggleClass("as-card");
                            });


                            //code for image preview
                            var reader = new FileReader();
                            reader.onload = function(e) {
                            $("#imager").attr("src", e.target.result);
                            };

                            function readURL(input) {
                            if (input.files && input.files[0]) {
                                $("#imager").css("visibility",'visible');
                                reader.readAsDataURL(input.files[0]);
                            }
                            }

                            $("#image-input").change(function() {
                            readURL(this);
                            });


                            //숙소, 맛집, 카페 선택
                            hotel.addEventListener("click", (e) => {
                                hotel.classList.add("bg-warning");
                                food.classList.remove("bg-warning");
                                cafe.classList.remove("bg-warning");
                            });  

                            food.addEventListener("click", (e) => {
                                food.classList.add("bg-warning");
                                hotel.classList.remove("bg-warning");
                                cafe.classList.remove("bg-warning");
                            });    

                            cafe.addEventListener("click", (e) => {
                                cafe.classList.add("bg-warning");
                                hotel.classList.remove("bg-warning");
                                food.classList.remove("bg-warning");
                            }); 

                            //제주, 서귀포
                            jeju.addEventListener("click", (e) => {
                            console.log('abc');
                            jeju.classList.add("bg-warning");
                            seogwipo.classList.remove("bg-warning");
                            inseogwipo.forEach((item) => {
                                item.classList.add("d-none");
                            });
                            injeju.forEach((item) => {
                                item.classList.remove("d-none");
                            });
                            });

                            seogwipo.addEventListener("click", (e) => {
                            seogwipo.classList.add("bg-warning");
                            jeju.classList.remove("bg-warning");
                            injeju.forEach((item) => {
                                item.classList.add("d-none");
                            });
                            inseogwipo.forEach((item) => {
                                item.classList.remove("d-none");
                            });
                            });
                        
                        </script>

                            
                        </form>
                    
                    </div>

                    <!-- ------동행---------------------------------------------------------------------------------------- -->

                    <div class="tab-pane fade" id="post" role="tabpanel" aria-labelledby="reservation-tab">

                        <!-- 날짜 선택 -->
                        <div style="margin-top: 30px; margin-left: 60px; margin-bottom: 0px;">
                        <h4><b>동행 날짜 선택</b></h4>
                        </div>
                        <div id="setday" class="fw-bolder text-center mt-5" style="float: left; margin-left: 30px; margin-top: 0px;">
                        <div style="float: left; ">
          
                            <div id="going" style=" float:left; margin-left: 30px; font-size: 25;">
                            가는날   
                            </div>
                            <input type="date" name="startDate" id="stratDate" style="color: gray; margin-left: 10px; float:left;">
                            <div style=" float:left; margin-left: 50px; font-size: 25;">
                            ~
                            </div>
                            <div id="comming" style=" float:left; margin-left: 50px; font-size: 25;">
                                오는날   
                            </div>
                                <input type="date" name="endDate" id="endDate" style="color: gray; margin-left: 10px; float:left;">
                            </div>
                            <br><br>
                        </div>

                        <br><br>

                        <div id="place-finder" class="fw-bolder text-center mt-5">

                        <div class="row border border-4" style="width: 90%; margin: 0 auto;">
                            <div class="row">
                            <div class="col-2 border-end border-3" id="jejuu">제주</div>
                            <!-- 제주시 -->
                            <div class="col in-jejuu">시내</div>
                            <div class="col in-jejuu">애월</div>
                            <div class="col in-jejuu">한림</div>

                            <!-- 서귀포 -->
                            <div class="col in-seogwipoo d-none">시내</div>
                            <div class="col in-seogwipoo d-none">남원</div>
                            <div class="col in-seogwipoo d-none">안덕</div>
                            </div>
                            <div class="row">
                            <div class="col-2 border-end border-3" id="seogwipoo">서귀포</div>
                            <!-- 제주시 -->
                            <div class="col in-jejuu">한경</div>
                            <div class="col in-jejuu">조천</div>
                            <div class="col in-jejuu">구좌</div>
                            <!-- 서귀포 -->
                            <div class="col in-seogwipoo d-none">대정</div>
                            <div class="col in-seogwipoo d-none">표선</div>
                            <div class="col in-seogwipoo d-none">성산</div>
                            </div>
                        </div>
                        </div>

                        <script>

                            // 선택시 색 변경, 읍면동 변경, 동행/장소 카테고리 변경

                            const jejuu = document.querySelector("#jejuu");
                            const seogwipoo = document.querySelector("#seogwipoo");
                            const injejuu = document.querySelectorAll(".in-jejuu");
                            const inseogwipoo = document.querySelectorAll(".in-seogwipoo");


                            //탭 바뀌는것
                            //toggle for form & badge
                            $(".js-switch").click(function() {
                            $(".main-content").toggleClass("as-card");
                            });


                            //code for image preview
                            var reader = new FileReader();
                            reader.onload = function(e) {
                            $("#imager").attr("src", e.target.result);
                            };

                            function readURL(input) {
                            if (input.files && input.files[0]) {
                                $("#imager").css("visibility",'visible');
                                reader.readAsDataURL(input.files[0]);
                            }
                            }

                            $("#image-input").change(function() {
                            readURL(this);
                            });

                        //제주, 서귀포 (동행)
                        jejuu.addEventListener("click", (e) => {
                            jejuu.classList.add("bg-warning");
                            seogwipoo.classList.remove("bg-warning");
                            inseogwipoo.forEach((item) => {
                            item.classList.add("d-none");
                            });
                            injejuu.forEach((item) => {
                            item.classList.remove("d-none");
                            });
                        });
                        
                        seogwipoo.addEventListener("click", (e) => {
                            seogwipoo.classList.add("bg-warning");
                            jejuu.classList.remove("bg-warning");
                            injejuu.forEach((item) => {
                            item.classList.add("d-none");
                            });
                            inseogwipoo.forEach((item) => {
                            item.classList.remove("d-none");
                            });
                        });                                

                    </script>

                    </div>
                </div>
    
          <br>
          <button href="/hallo06talk/search/searchDetail.jsp" type="submit" value="검색" class="btn btn-warning" style="float:right; margin-right: 60px;">검색</button>
    
        </body>
    
    

            </div>
    </main>


<footer></footer>

</body>
</html>