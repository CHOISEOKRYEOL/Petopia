<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h1>Petopia 회원 가입</h1>
	<form action="add" method="post">
		이름 : <input type="text" name="name"><br> 아이디 : <input
			type="text" name="id"> <input type="button" name="checkId"
			value="중복 확인"><br> 이메일 : <input type="email"
			name="email"> <input type="button" name="checkEmail"
			value="중복 확인"><br> 닉네임 : <input type="text" name="nick">
		<input type="button" name="checkNick" value="중복 확인"><br>
		비밀번호 : <input type="password" name="password"><br> 비밀번호
		확인 : <input type="password" name="checkPassword"><br>
		휴대전화 : <input type="tel" name="tel"> <input type="button"
			name="checkTel" value="인증번호 받기"><br> <input
			type="submit" value="가입하기">
	</form>
	<form action="../main">
		<input type="submit" value="뒤로가기">
	</form>
</body>
</html>
<%-- 
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
<title>회원 가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body>
<header id="header"></header>
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
<a class="navbar-brand" style="font-size: 30px;">Petopia 회원 가입</a>
</nav>
<div class="addform">
  <form action="add" method="post">
  <div class="mt-3 mb-3 row">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="name" name="name">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="id" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="id" name="id">
      <input type="button" name="checkId" value="중복 확인">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="email" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-6">
      <input type="email" class="form-control" id="email" name="email">
      <input type="button" name="checkEmail" value="중복 확인">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="nick" class="col-sm-2 col-form-label">닉네임</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="nick" name="nick">
      <input type="button" name="checkNick" value="중복 확인">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" id="password" name="password">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="checkPassword" class="col-sm-2 col-form-label">비밀번호 확인</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" id="checkPassword" name="checkPassword">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="tel" class="col-sm-2 col-form-label">휴대전화</label>
    <div class="col-sm-6">
      <input type="tel" class="form-control" id="tel" name="tel">
      <input type="button" name="checkTel" value="인증번호 받기">
    </div>
  </div>
  
<div class="modal-footer justify-content-between">
<a href='../main' class="btn btn-secondary">메인</a>
<input class="btn" style="background-color: #FFADAD;" type='submit' value='가입하기'>
</div>
</form>
</div>
</div>

<footer id="footer"></footer>
</body>
</html>
 --%>