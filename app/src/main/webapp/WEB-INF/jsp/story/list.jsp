<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>스토리</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body>
<header id="header"></header>
<div class="wrap">
<img src="../images/20180115_120703.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">우리 아이들의 이야기</p>
    <p>동물에 관련된 정보만 빠르게<br>
    한눈에 볼 수 있도록 전달해 드립니다</p> 
  </div>
</div>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand">스토리</a>
  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
    <li class="nav-item">
      <a href='form' class="btn" style="background-color: #FFADAD;">새 글</a>
    </li>
  </ul>
  <form class="d-flex">
    <input class="form-control me-2" type="search" name="keyword" value='${param.keyword}' placeholder="검색" aria-label="검색">
    <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
  </form>
</nav>

<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>제목</th> <th>사이트</th> <th>등록일</th> <th>스크랩</th>
</tr>
</thead>

<tbody>

<c:forEach items="${storys}" var="s">
<tr> 
  <td>
  <c:if test="${loginUser.id eq 'admin'}">
  <a href='detail?no=${s.no}'>${s.no}</a>
  </c:if>
  <c:if test="${loginUser.id ne 'admin'}">
  ${s.no}
  </c:if>
  </td> 
  <td><a href='${s.url}'>${s.title}</a></td> 
  <td>${s.site}</td> 
  <td>${s.registeredDate}</td> 
  <td>
	  <input type="hidden" id="news-no" value="${s.no}">
	  <button type="button" class="scrap" data-no="${s.no}">스크랩</button>
	  <button class="scrap-cancel" type="button" data-no="${s.no}">스크랩 취소</button>
  </td>
</tr>

</c:forEach>
</tbody>
</table>

</div>
  <script>
   var scrapList = document.querySelectorAll(".scrap");
   var scrapcancelList = document.querySelectorAll(".scrapcancel");
  /*  $.ajax({"scrapcheck",
	   dataType : "String",
	   success(scrap){
		   scrap.forEach(if 
		    )
	   }
   }); */
   (function() {
	   for (var scrap of scrapList) {
		   console.log(scrap);
		   var xhr = new XMLHttpRequest();
		   console.log(xhr.responseText);
		   
		   
		   xhr.onreadystatechange = () => {
	       if (xhr.readyState == 4) {
	         if (xhr.status == 200) {
	        	 console.log(xhr.responseText);
	        	/*  console.log("------------");
			       if (xhr.responseText == "0") {
			         console.log("0");
			         $(".scrap").hide();
			       } else if (xhr.responseText == "1") {
			    	   console.log("1");
			    	   $(".scrap-cancel").hide();
			       }  */
			      
		       } else {
		          alert("실행 오류 입니다!");
		       }
		     }
		   };
		   xhr.open("GET", "scrapcheck?no=" + scrap.getAttribute("data-no"), true);
		   xhr.send();
		   console.log(xhr.responseText);
		   console.log("send() 리턴함.");
	   };
   })(); 
   
   for(var scrap of scrapList) {
    scrap.onclick = function() {
      var newsNo = this.getAttribute("data-no");
      console.log(newsNo);
      var xhr = new XMLHttpRequest();
      
      xhr.onreadystatechange = () => {
    	  if (xhr.readyState == 4) {
    		  if (xhr.status == 200) {
    			  
    			  if (xhr.responseText == "fail") {
    			        
 			        console.log("여기 fail");
 			        swal("이미 스크랩한 게시물입니다!", "감사합니다", "warning");
 			        //alert("이미 추천한 게시물입니다.");
 			/*         <div id="scrap-cancel" style="display:none;"/>
 			 */        
 			      } else {
 			        
 			        console.log("여기 success");
 			        swal("뉴스를 스크랩하였습니다!", "감사합니다.", "success");
 			        //alert("게시물을 추천하였습니다.") 
 			        
 			      }
    			  
    		  } else {
    			  alert("실행 오류 입니다!");
    		  }
    	  }
    	  
      };
      console.log(newsNo);
      xhr.open("GET", "scrapadd?newsNo=" + newsNo, true);
      xhr.send();
      console.log("send() 리턴함.");
    };
   
};
  </script>
<footer id="footer"></footer>
</body>
</html>
    