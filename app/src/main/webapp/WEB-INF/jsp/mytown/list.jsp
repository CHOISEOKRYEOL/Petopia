<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>우리동네 게시글 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
</head>
<body>
<header id="header"></header>
<div class="wrap">
<img src="../../images/20180515_203804.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">우리동네 친구찾기</p>
    <p>동네 커뮤니티로 정보를 나누고 수다 떨며<br>
    같이 산책할 내 반려동물의 친구 사귀어 보세요.</p>
  </div>
</div>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<img src="../../images/IMG_7390.PNG" width=10%; style=margin-right:70%;>
<a class="navbar-brand" style=margin-right:50%>${smallAddress.bigAddress.name}&nbsp;${smallAddress.name}</a>
</nav>
	<a href = "main" type="button"> 우리동네찾으러가기</a>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
  <li class="nav-item">
		<a href='form?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}' class="btn" style="background-color: #FFADAD;">새 글</a>
  </li>
  </ul>
		<form class="d-flex" action='list'>
		  <input type='hidden' name='stateNo' value='${smallAddress.bigAddress.no}'>
      <input type='hidden' name='cityNo' value='${smallAddress.no}'>
      <input type='hidden' name='r' value='r'> 
      <button class="btn" style="background-color: #FFFFFF;" type="submit">추천수</button>
    </form>
    <form action='list' method='get' class="d-flex">
	    <input type='hidden' name='stateNo' value='${smallAddress.bigAddress.no}'>
	    <input type='hidden' name='cityNo' value='${smallAddress.no}'><br>
	    <input class="form-control me-2" type='search' name='keyword' value='${param.keyword}' placeholder="검색" aria-label="검색"> 
    <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
  </form>
	</div>
  </nav>
	<table border='1' class="table table-hover" style=margin-bottom:20% >
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="t">
				<tr>
					<td>${t.no}</td>
					<td><a
						href='detail?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}&no=${t.no}'>${t.title}</a></td>
					<c:if test="${t.writer.state == 1}">
          <td>탈퇴 회원</td>					
					</c:if>
					<c:if test="${t.writer.state == 0}">
					<td>${t.writer.nick}</td>
					</c:if>
					<td>${t.createdDate}</td>
					<td>${t.viewCount}</td>
					<td>${t.recommentCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<footer id="footer"></footer>
<script>
$(document).ready(function() {
    $("header").load("../../html/header.jsp");
    $("footer").load("../../html/footer.html");
  });
</script>
</body>
</html>



