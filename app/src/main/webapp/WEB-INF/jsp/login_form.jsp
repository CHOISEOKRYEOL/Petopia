<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/web/css/main.css">
<link rel="stylesheet" type="text/css" href="/web/css/layout.css">
</head>
<body>
<header></header>
<div class="wrap">
<img src="/web/images/1433886.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">우리 아이들의 이야기</p>
    <p>동네 커뮤니티로 정보를 나누고, 수다 떨며<br>
    같이 산책할 내 반려동물의 친구를 사귀어 보세요</p> 
  </div>
</div>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand">로그인</a>
</nav>
<div id="login-form">
<form action="login" method='post'>
  <div class="mt-3 mb-3 row">
    <label for="id" class="col-sm-2 col-form-label">아이디/이메일</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="id" name="id" value='${cookie.id.value}' placeholder="아이디 또는 이메일을 입력하세요." required>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="password" class="col-sm-2 col-form-label">암호</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요." required>
    </div>
  </div>
<div class="modal-footer justify-content-between">
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="saveIdOrEmail" name="saveIdOrEmail">
    <label class="form-check-label" for="saveEmail">ID/Email 저장</label>
    <a href="member/findKey_form">아이디/비밀번호 찾기</a>
  </div>
<button id="login" class="btn" style="background-color: #FFADAD;">로그인</button>
</div>
</form>
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
