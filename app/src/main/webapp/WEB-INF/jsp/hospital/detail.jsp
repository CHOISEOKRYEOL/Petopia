<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>병원 상세</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../../css/common.css">
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
</head>
<body>
<header></header>
<div class="wrap">
<img src="/web/images/bigstock.jpg" class="img-fluid width:100%;"
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
<a class="navbar-brand">병원 상세보기</a>
  <div class="boomark">
  <c:if test="${not empty loginUser and empty bookmark}">
    <form action="../bookmark/add" method="post">
      <input type="hidden" name="mno" value="${loginUser.no}"> <input
        type="hidden" name="hno" value="${hospital.no}"> <input
        type="hidden" name="hiddenNo" value="0"> <input
        type="submit" value="☆">
    </form>
  </c:if>

  <c:if test="${not empty loginUser and not empty bookmark}">
    <form action="../bookmark/delete">
      <input type="hidden" name="no" value="${bookmark.no}"> <input
        type="hidden" name="hno" value="${hospital.no}"> <input
        type="submit" value="★">
    </form>
  </c:if>
  </div>
</nav>

	<c:if test="${not empty hospital}">
		<c:if test="${not empty hospital.photo}">
			<c:set var="photo300x300Url">../../upload/${hospital.photo}_300x300.jpg</c:set>
			<c:set var="photoUrl">../../upload/${hospital.photo}</c:set>
		</c:if>
		<c:if test="${empty hospital.photo}">
			<c:set var="photo300x300Url">../../images/person_80x80.jpg</c:set>
			<c:set var="photoUrl"></c:set>
		</c:if>

		<form action='update' method='post' enctype='multipart/form-data'>
		
		<div class="mt-3 mb-3 row">
	    <label for="no" class="col-sm-2 col-form-label">번호</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control-plaintext" id="no" name="no" value='${hospital.no}'>
	    </div>
    </div>
    
    <div class="form-row mb-3">
      <label for="photo" class="col-sm-2 col-form-label">병원사진</label>
      <a href='${photoUrl}'> <img src='${photo300x300Url}'></a>
      <input name='photo' type='file'>
    </div>
    
    <div class="mb-3 row">
	    <label for="title" class="col-sm-2 col-form-label">병원이름</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="name" name="name" value='${hospital.name}'>
	    </div>
    </div>
    
    <div class="mb-3 row">
	    <label for="url" class="col-sm-2 col-form-label">전화번호</label>
	    <div class="col-sm-10">
	      <input type="tel" class="form-control" id="tel" name="tel" value='${hospital.tel}'>
	    </div>
    </div>

	  <div class="form-row mb-3">
	  <label for="gno" class="col-sm-2 col-form-label">기본주소</label>
	    <jsp:include page="../../../html/state3.jsp"/>
	  </div>
	  
	  <div class="mb-3 row">
	    <label for="address" class="col-sm-2 col-form-label">상세주소</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="address" name="address" value='${hospital.address}'>
	    </div>
	  </div>
	  
	  <div class="form-row mb-3">
	    <label for="startTime" class="col-sm-2 col-form-label">진료시간</label>
	    <input type="number" name="startTime" value='${hospital.startTime}'>시 ~ 
	    <input type="number" name="endTime" value='${hospital.endTime}'>시
	  </div>
	  
	  <div class="form-row mb-3">
	    <label for="parking" class="col-sm-2 col-form-label">주차여부</label>
	    <div class="form-check form-check-inline">
	      <input type='radio' name='parking' value='1' ${hospital.parking == 1 ? "checked" : ""}>Yes
	    </div>
	    <div class="form-check form-check-inline">
	       <input type='radio' name='parking' value='0' ${hospital.parking == 0 ? "checked" : ""}>No
	    </div>
	  </div>
	  
	  <div class="form-row mb-3">
	    <label for="vet" class="col-sm-2 col-form-label">수의사</label>
	    <input type="number" name="vet" value='${hospital.veterinarian}'>명
	  </div>
	  
	  <div class="form-row mb-3">
      <label for="photo" class="col-sm-2 col-form-label">평점</label> 
      <c:if test="${hospital.rating == 0}">0점</c:if>
      <c:if test="${hospital.rating > 0}">
        <fmt:formatNumber value="${hospital.rating}" pattern=".00" />점
      </c:if>
    </div>
		</form>
	</c:if>

  <div class="modal-footer justify-content-between">
    <div>
      <a href='list' class="btn btn-secondary">목록</a>
      <a href='delete?no=${hospital.no}' class="btn btn-danger">삭제</a>
    </div>
      <input class="btn" style="background-color: #FFADAD;" type='submit' value='변경'>
  </div>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand">병원 리뷰</a>
	<form action="/web/app/review/review_form">
    <input type='hidden' name='num' value='${hospital.no}'>
    <input type="submit" value="리뷰 작성">
  </form>
</nav>
<jsp:include page="/app/review/list"/>
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