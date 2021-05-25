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
<link rel="stylesheet"  type="text/css" href="../css/common2.css">
</head>
<body>
<header>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #FFADAD;">
  <div class="container-fluid">
    <a class="navbar-brand" href="../main">Petopia</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../hospital/list">병원찾기</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../sharingmarketboard/list">나눔장터</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../story/list">스토리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../mytown/main">우리동네</a>
        </li>
        </ul>
        <c:if test="${empty loginUser}">
        <div class="d-flex justify-content-between">
         <ul class="navbar-nav me-auto mb-2 mb-lg-0">
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../login">로그인</a>
         </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../member/add">회원가입</a>
         </li>
         </ul>
        </div>
        </c:if>
        <c:if test="${not empty loginUser}">
        <div class="d-flex justify-content-between">
         <ul class="navbar-nav me-auto mb-2 mb-lg-0">
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../logout">로그아웃</a>
         </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="../mypage/main">마이페이지</a>
         </li>
         </ul>
        </div>
        </c:if>
  </div>
</nav>
</header>

<div class="wrap">
<img src="../images/20180115_115933.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
<div class="text-group">
<p style="font-size: 50px;">펫토피아</p>
<p style="font-size: 30px;">우리 아이들의 이야기</p>
<p>동네 커뮤니티로 정보를 나누고, 수다 떨며,<br>
같이 산책할 내 반려동물의 친구를 사귀어 보세요.</p> 
</div>
</div>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand" style="font-size: 30px;">스토리</a>
  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
  <li class="nav-item">
    <a href='add' class="btn" style="background-color: #FFADAD;">새 글</a>
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
  <c:set var="count" value="0"/>
  <c:set var="scrapLength" value="${fn:length(scrapList)}"/>
  <c:if test="${not empty loginUser}">
  <c:if test="${empty scrapList}">
  <form action='scrapadd' method='get'>
      <input type='hidden' name='newsNo' value ='${s.no}'>
      <input type='submit' value ='스크랩'>
    </form>
  </c:if>
  <c:if test="${not empty scrapList}">
  <form action='scrapdelete' method='get'>
    <c:forEach items="${scrapList}" var="scrap">
        <c:if test="${scrap.story.no eq s.no}">
          <c:if test="${scrap.isScrap eq 1}">
            <input type='hidden' name='scrapNo' value ='${s.no}'>
            <input type='submit' value ='스크랩취소'>
          </c:if>
        </c:if>
    </c:forEach>
   </form>
   <form action='scrapadd' method='get'>
     <c:set var="count" value="0"/>
     <c:forEach items="${scrapList}" var="scrap">
        <c:if test="${scrap.story.no ne s.no}">
            <c:set var="count" value="${count+1}"/>
            <c:if test="${fn:length(scrapList) eq count}">
            <input type='hidden' name='newsNo' value ='${s.no}'>
            <input type='submit' value ='스크랩'>
            </c:if>
        </c:if>
     </c:forEach> 
   </form>
   </c:if>
   </c:if>
  </td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<footer>
<div id="footer">
  Petopia
  <address>서울시 서초구 서초동 비트아카데미빌딩 3층</address>
  (주)비트컴퓨터 서초지점
  <p>Copyright by BITCamp</p>
</div>
</footer>
</body>
</html>
    