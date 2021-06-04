<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/web/css/mypage.css">
<link rel="stylesheet" type="text/css" href="/web/css/layout.css">
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
	<form action='update' method='post'>
	<div class="mt-3 mb-3 row">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-6">
      <input class="form-control-plaintext" id="name" name="name" value='${member.name}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="id" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-6">
      <input class="form-control-plaintext" id="id" name="id" value='${member.id}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="email" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-6">
      <input class="form-control-plaintext" id="email" name="email" value='${member.email}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="nick" class="col-sm-2 col-form-label">닉네임</label>
    <div class="col-sm-6">
      <input type='text' class="form-control" id="nick" name="nick" value='${member.nick}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-6">
      <input type='password' class="form-control" id="password" name="password" minlength="8">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="tel" class="col-sm-2 col-form-label">휴대전화</label>
    <div class="col-sm-6">
      <input class="form-control-plaintext" id="tel" name="tel" value='${member.tel}'>
    </div>
  </div>
	
<div class="modal-footer justify-content-end">
  <input class="btn" style="background-color: #FFADAD;" type='submit' value='등록'>
</div>
	</form>
	<form action='delete' method='post'>
		<input type='hidden' name='no' value='${member.no}'> <input
			type='submit' name='delete' value='회원탈퇴'>
	</form>
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