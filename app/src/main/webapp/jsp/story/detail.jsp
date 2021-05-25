<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>스토리 상세</title>
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

<div class="container" style="border: 1px solid lightgray; width: 900px;">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand" style="font-size: 30px;">스토리 상세보기</a>
</nav>
<c:if test="${not empty story}">
<form action='update' method='post'>
<div class="mb-3 row">
    <label for="no" class="col-sm-1 col-form-label">번호</label>
    <div class="col-sm-10">
      <input type="text" class="form-control-plaintext" id="no" name="no" value='${story.no}'>
    </div>
  </div>
<div class="mb-3 row">
    <label for="title" class="col-sm-1 col-form-label">제목</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="title" name="title" value='${story.title}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="url" class="col-sm-1 col-form-label">URL</label>
    <div class="col-sm-10">
      <input type="url" class="form-control" id="url" name="url" value='${story.url}'>
    </div>
  </div>
    <div class="mb-3 row">
    <label for="site" class="col-sm-1 col-form-label">사이트</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="site" name="site" value='${story.site}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="registeredDate" class="col-sm-1 col-form-label">등록일</label>
    <div class="col-sm-10">
      <input type="text" class="form-control-plaintext" id="registeredDate" value='${story.registeredDate2}'>
    </div>
  </div>
  
<!-- <div class="d-flex justify-content-between"> -->
  <div class="modal-footer justify-content-between">
    <div>
      <a href='list' class="btn btn-secondary">목록</a>
      <a href='delete?no=${story.no}' class="btn btn-danger">삭제</a>
    </div>
      <input class="btn" style="background-color: #FFADAD;" type='submit' value='변경'>
  </div>
</div>
</form>
</c:if>

<c:if test="${empty story}">
<p>해당 번호의 스토리가 없습니다.</p>
<a href='list' class="btn btn-secondary">목록</a>
</c:if>

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
