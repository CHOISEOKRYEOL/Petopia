<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이펫 정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/web/css/mypage.css">
<link rel="stylesheet" type="text/css" href="/web/css/layout.css">
<link rel="stylesheet" type="text/css" href="/web/css/common.css">
</head>
<body>
<header></header>
<div class="wrap">
<img src="/web/images/mypage.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">${loginUser.nick}님</p>
    <p>마이펫과 자주 가는 병원을 등록하고<br>
    나의 반려동물들을 간단하게 관리해보세요</p> 
  </div>
</div>

<div class="container">
<sidebar></sidebar>

<div class="main">
<div class="main-mypet" style="margin-left: 10px;">

<c:if test="${not empty pet}">
  <c:if test="${not empty pet.photo}">
    <c:set var="photo80x80Url">../../upload/${pet.photo}_80x80.jpg</c:set>
    <c:set var="photoUrl">../upload/${pet.photo}</c:set>
  </c:if>
  <c:if test="${empty pet.photo}">
    <c:set var="photo80x80Url">../../images/person_80x80.jpg</c:set>
    <c:set var="photoUrl"></c:set>
  </c:if>
  
<form action='update' method='post' enctype="multipart/form-data">
<div class="mt-3 mb-3 row">
<label for="no" class="col-sm-1 col-form-label">번호</label>
    <div class="col-sm-6">
      <input type="text" class="form-control-plaintext" id="no" name="no" value='${pet.no}'>
    </div>
  </div>
<div class="mb-3 row">
<label for="name" class="col-sm-1 col-form-label">이름</label>
    <div class="col-sm-6">
      <input type="text" class="form-control-plaintext" id="name" name="name" value='${pet.name}'>
    </div>
  </div>
  <div class="mb-3 row">
<label for="age" class="col-sm-1 col-form-label">나이</label>
    <div class="col-sm-6">
      <input type="text" class="form-control-plaintext" id="age" name="age" value='${pet.age}'>
    </div>
  </div>
   <div class="mb-3 row">
<label for="birthDay" class="col-sm-1 col-form-label">생일</label>
    <div class="col-sm-6">
      <input type="date" class="form-control-plaintext" id="birthDay" name="birthDay" value='${pet.birthDay}'>
    </div>
  </div>
     <div class="form-row mb-3">
<label for="gender" class="col-sm-1 col-form-label">성별</label>
    <div class="form-check form-check-inline">
        <input type='radio' name='gender' value='0' ${pet.gender == 1 ? "checked" : ""}>남
      </div>
      <div class="form-check form-check-inline">
         <input type='radio' name='gender' value='1' ${pet.gender == 0 ? "checked" : ""}>여
      </div>
  </div>
 <div class="mb-3 row">
<label for="type" class="col-sm-1 col-form-label">품종</label>
    <div class="col-sm-6">
      <input type="text" class="form-control-plaintext" id="type" name="type" value='${pet.type.type}'>
    </div>
  </div>
    <div class="form-row mb-3">
      <label for="photo" class="col-sm-2 col-form-label">사진</label>
      <img src='${photo80x80Url}'><br>
      <input name='photoFile' type='file'>
    </div>

  <div class="modal-footer justify-content-between">
    <div>
   <a href='list' class="btn btn-secondary" type='submit'>목록</a>
   <a href='delete?no=${pet.no}' class="btn btn-danger" type='submit'>삭제</a>
    </div>
   <input class="btn" style="background-color: #FFADAD;" type='submit' value='변경' class="button">
</div>
 </form>
 </c:if>
</div>
      
</div>
</div>

<footer></footer>
<script>
$(document).ready(function() {
    $("header").load("/web/html/header.jsp");
    $("sidebar").load("/web/html/sidebar.jsp");
    $("footer").load("/web/html/footer.html");
  });
</script>
</body>
</html>