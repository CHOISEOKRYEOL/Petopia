<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫토피아</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/web/css/main.css">
<link rel="stylesheet" type="text/css" href="/web/css/layout.css">
</head>
<body>
<header></header>
<div class="wrap">
<img src="/web/images/1433886.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">우리 아이들의 이야기</p>
    <p>동네 커뮤니티로 정보를 나누고, 수다 떨며<br>
    같이 산책할 내 반려동물의 친구를 사귀어 보세요</p> 
  </div>
</div>

<div class="container">
    <div class="box1">
    <div class="boxtext1">
    <p><img src="/web/images/pawprint.png"> 펫토피아에 오신 것을 환영합니다 <img src="/web/images/pawprint.png"></p>
  <%-- 
    <div class="pagination">
        <div class="pagination_item01">
           시/도
        </div>
        <div class="pagination_item02">
           <select class="gno" name='gno'>
           <option value=''>서울특별시</option>
           </select>
        </div>
        <div class="pagination_item03">
           시/군/구
        </div>
        <div class="pagination_item04">
           <select class="cno" name='cno'>
           <option value=''>강남구</option>
           </select>
        </div>
        <div class="pagination_item05">
           <input type="button" class="img-search-btn">
        </div>
    </div>
    --%>
    </div>
    </div>
        <%--  
    <div class="box2">
      <nav class="navbar navbar-expand-lg navbar-light">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/pet/list">
          <img src="/web/images/pawprintfull.png"> 마이펫</a>
        </li>
      </ul>
      </nav>
    </div>
    
    <c:if test="${not empty loginUser}">
    <div class="box3">
      <div class="container_left01">
        <div class="img-mypet">
          <img class="mypetpic" src="/web/images/20180111_205149.jpg">
        </div>
      <div class="container_right01">
        <p>name: eeee<br>age: eeee<br>eeeeeddddd</p>
      </div>
      
      <div class="timeline">
        <div class="timeline_line"></div>
        <ul class="timeline_items">
            <li class="timeline_item">
                <div class="timeline_top">
                    <div class="timeline_circle"></div>
                    <div class="timeline_title">
                    ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
                    </div>
                </div>
                <div class="timeline_desc">
                2020.02.22
                </div>
            </li>
            <li class="timeline_item">
                <div class="timeline_top">
                    <div class="timeline_circle"></div>
                    <div class="timeline_title">
                    ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ
                    </div>
                </div>
                <div class="timeline_desc">
                2021.02.22
                </div>
            </li>
            <li class="timeline_item">
                <div class="timeline_top">
                    <div class="timeline_circle"></div>
                    <div class="timeline_title">
                    ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ
                    </div>
                </div>
                <div class="timeline_desc">
                2020.12.22
                </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
    </c:if>
    --%>
    
    <c:if test="${empty loginUser}">
    <div class="box3" style="align-items: center; display: flex; justify-content: center;">
	    <div class="box3-blur" style="width: 850px; height:250px; background-color: #FAF0E6; filter: blur(10px); position: relative;">
	    </div> 
	    <div class="box3-text" style="position: absolute;">회원가입 후 이용 가능합니다.</div>
    </div>
    </c:if>
    
    <div class="box4">
    <nav class="navbar navbar-expand-lg navbar-light">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/sharingmarketboard/list">
          <img src="/web/images/pawprintfull.png"> 나눔장터</a>
        </li>
      </ul>
    </nav>
    </div>
    
    <c:if test="${not empty loginUser}">
    <div class="box5">
      <div class="row justify-content-evenly">
        <div class="col-3">
          <a href="http://localhost:8080/web/app/mytown/detail?stateNo=1&cityNo=16&no=2">
          <img src="/web/images/20180111_205149.jpg" style="width: 200px; height: 250px;"></a>
          <p class="market_contents">
          <a href="http://localhost:8080/web/app/mytown/detail?stateNo=1&cityNo=16&no=2" class="link-dark" style="text-decoration:none;">
          dkdkdksssssssssssssssssssssssssssssssssss</a></p>
        </div>
        <div class="col-3">
          <a href="https://www.daum.net/">
          <img src="/web/images/20180111_205149.jpg" style="width: 200px; height: 250px;"></a>
          <p class="market_contents">
          <a href="https://www.daum.net/" class="link-dark" style="text-decoration:none;">
          dkdkdkssssssssssssssssssss</a></p>
        </div>
        <div class="col-3">
          <a href="https://twitter.com/">
          <img src="/web/images/20180111_205149.jpg" style="width: 200px; height: 250px;"></a>
          <p class="market_contents">
          <a href="https://twitter.com/" class="link-dark" style="text-decoration:none;">
          dkdkdkssssssssssssssssssssssssss</a></p>
        </div>
        <div class="col-3">
          <a href="https://www.netflix.com/">
          <img src="/web/images/20180111_205149.jpg" style="width: 200px; height: 250px;"></a>
          <p class="market_contents">
          <a href="https://www.netflix.com/" class="link-dark" style="text-decoration:none;">
          dkdkdksssssssssssssss</a></p>
        </div>
      </div>
     </div>
     </c:if>
     
     <c:if test="${empty loginUser}">
     <div class="box5">
      <div class="row justify-content-evenly">
        <div class="col-3">
          <img src="/web/images/20180111_205149.jpg" style="width: 200px; height: 250px;">
          <p class="market_contents">
          dkdkdksssssssssssssssssssssssssssssssssss</p>
        </div>
        <div class="col-3">
          <img src="/web/images/20180111_205149.jpg" style="width: 200px; height: 250px;">
          <p class="market_contents">
          dkdkdkssssssssssssssssssss</p>
        </div>
        <div class="col-3">
          <img src="/web/images/20180111_205149.jpg" style="width: 200px; height: 250px;">
          <p class="market_contents">
          dkdkdkssssssssssssssssssssssssss</p>
        </div>
        <div class="col-3">
          <img src="/web/images/20180111_205149.jpg" style="width: 200px; height: 250px;">
          <p class="market_contents">
          dkdkdksssssssssssssss</p>
        </div>
      </div>
     </div>
     </c:if>
    
    <div class="box6">
      <div class="container_navleft02">
      <nav class="navbar navbar-expand-lg navbar-light">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/story/list">
          <img src="/web/images/pawprintfull.png"> 스토리</a>
        </li>
      </ul>
      </nav>
      </div>
      <div class="container_navright02">
      <nav class="navbar navbar-expand-lg navbar-light">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/mytown/list">
          <img src="/web/images/pawprintfull.png"> 우리동네</a>
        </li>
      </ul>
      </nav>    
      </div>
    </div>
    
    <div class="box7">
      <div class="container_left02">
      스토리
      </div>
      
      <div class="container_right02">
       <table class="table table-hover">
			  <thead>
			    <tr>
			      <th> 동네 </th>
			      <th> 제목 </th>
			      <th> 등록일 </th>
			      <th> 추천수 </th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${myTownList}" var="t">
			      <tr>
			        <td>${t.bigAddress.name} &nbsp; ${t.smallAddress.name} </td>
			        <td><a href='../mytown/detail?stateNo=${t.bigAddress.no}&cityNo=${t.smallAddress.no}&no=${t.no}'>${t.title}</a></td>
			        <td>${t.createdDate}</td>
			        <td>&nbsp;&nbsp;&nbsp;${t.recommentCount}</td>
			      </tr>
			    </c:forEach>
			  </tbody>
			 </table>
      </div>
    </div>
</div>

<footer></footer>
<script>
$(document).ready(function() {
    $("header").load("/web/html/header.jsp");
    $("footer").load("/web/html/footer.html");
  });
</script>
</body>
</html>