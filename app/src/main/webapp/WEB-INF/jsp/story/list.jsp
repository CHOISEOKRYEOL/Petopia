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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="/web/css/common.css">
<link rel="stylesheet" type="text/css" href="/web/css/layout.css">
</head>
<body>
<header></header>
<div class="wrap">
<img src="/web/images/story.jpg" class="img-fluid width:100%;"
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
  <c:if test="${loginUser.role == 0}">
    <li class="nav-item">
      <a href='form' class="btn" style="background-color: #FFADAD;">새 글</a>
    </li>
  </c:if>
  </ul>
  <form class="d-flex">
    <input class="form-control me-2" type="search" name="keyword" value='${param.keyword}' placeholder="검색" aria-label="검색">
    <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
  </form>
</nav>

<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>제목</th> <th>사이트</th> <th>등록일</th>
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
  <td><a href='${s.url}' target="_blank">${s.title}</a></td> 
  <td>${s.site}</td> 
  <td>${s.registeredDate}</td> 
</tr>

</c:forEach>
</tbody>
</table>

</div>
<script type="text/javascript">
$(document).ready(function() {
    $("header").load("/web/html/header.jsp");
    $("footer").load("/web/html/footer.html");
  });
  </script>
<footer></footer>
</body>
</html>
 