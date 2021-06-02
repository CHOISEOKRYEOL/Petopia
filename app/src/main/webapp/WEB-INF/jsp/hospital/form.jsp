<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원 찾기</title>
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
<img src="../../images/Screenshot_2017-01-05-23-08-49.png" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">집에서 가까운 병원 찾기</p>
    <p>직접 동네 병원을 검색할 필요 없이<br>
    내 집에서 가장 가까운 병원을, 상세 리뷰와 함께 보여드립니다</p> 
  </div>
</div>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand">병원 등록</a>
</nav>

<div class="addform">
<form action="add" method="post" enctype="multipart/form-data">
  <div class="mt-3 mb-3 row">
    <label for="name" class="col-sm-2 col-form-label">병원이름</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="tel" class="col-sm-2 col-form-label">전화번호</label>
    <div class="col-sm-10">
      <input type="tel" class="form-control" id="tel" name="tel">
    </div>
  </div>
  
  <div class="form-row mb-3">
  <label for="gno" class="col-sm-2 col-form-label">기본주소</label>
      <select id="gno" class="col-md-4" name='gno'>
          <option value=''>시/도</option>
          <option value='1'>서울특별시</option>
         </select>
       <select id="cno" class="col-md-4" name='cno'>
          <option value=''>시/군/구</option>
          <option value='1'>강남구</option>
         </select>
  </div>
  
  <div class="mb-3 row">
    <label for="address" class="col-sm-2 col-form-label">상세주소</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="address" name="address">
    </div>
  </div>
  
  <div class="form-row mb-3">
    <label for="startTime" class="col-sm-2 col-form-label">진료시간</label>
    <input type="number" name="startTime" min="0" max="24" value="0">시 ~ 
    <input type="number" name="endTime" min="0" max="24" value="0">시
  </div>
  
  <div class="form-row mb-3">
    <label for="parking" class="col-sm-2 col-form-label">주차여부</label>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="radio" name="parking" id="parking" value="1">Yes
    </div>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="radio" name="parking" id="parking" value="0">No
    </div>
  </div>
  
  <div class="form-row mb-3">
    <label for="vet" class="col-sm-2 col-form-label">수의사</label>
    <input type="number" name="vet" min="1" max="50" value="1">명
  </div>
  
  <div class="form-row mb-3">
    <label for="photo" class="col-sm-2 col-form-label">병원사진</label>
    <input type="file" name="photo" id="imageFileOpenInput" accept="image/*">
  </div>
<div class="modal-footer justify-content-between">
<a href='list' class="btn btn-secondary">목록</a>
<input class="btn" style="background-color: #FFADAD;" type='submit' value='등록'>
</div>
</form>
</div>
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