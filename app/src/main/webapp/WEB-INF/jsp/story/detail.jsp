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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../../css/common.css">
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
</head>
<body>
<header id="header"></header>
<div class="wrap">
<img src="../../images/20180115_120703.jpg" class="img-fluid width:100%;"
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
<a class="navbar-brand">스토리 상세보기</a>
</nav>

<c:if test="${not empty story}">
<form action='update' method='post'>
<div class="mt-3 mb-3 row">
    <label for="no" class="col-sm-1 col-form-label">번호</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext" id="no" name="no" value='${story.no}'>
    </div>
  </div>
<div class="mb-3 row">
    <label for="title" class="col-sm-1 col-form-label">제목</label>
    <div class="col-sm-7">
      <input type="text" class="form-control" id="title" name="title" value='${story.title}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="url" class="col-sm-1 col-form-label">URL</label>
    <div class="col-sm-7">
      <input type="url" class="form-control" id="url" name="url" value='${story.url}'>
    </div>
  </div>
    <div class="mb-3 row">
    <label for="site" class="col-sm-1 col-form-label">사이트</label>
    <div class="col-sm-7">
      <input type="text" class="form-control" id="site" name="site" value='${story.site}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="registeredDate" class="col-sm-1 col-form-label">등록일</label>
    <div class="col-sm-7">
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
</form>
</c:if>

<c:if test="${empty story}">
<p>해당 번호의 스토리가 없습니다.</p>
<a href='list' class="btn btn-secondary">목록</a>
</c:if>

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
