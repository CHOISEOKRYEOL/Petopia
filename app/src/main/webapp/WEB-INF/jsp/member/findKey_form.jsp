<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petopia 아이디 / 비밀번호 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="css/common.css" rel="stylesheet" >
<style>
  #id-form {
    width: 500px;
    margin: 50px auto;
  }
</style>

<style>
  #password-form {
    width: 500px;
    margin: 70px auto;
  }
</style>
</head>
<body>

<div id="id-form">
<h1>아이디 찾기</h1>
<form action="findkey" method='post'>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="text" class="form-control form-control-sm" id="name" name="name" placeholder="이름">
    </div>
  </div>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="text" class="form-control form-control-sm" id="nick" name="nick" placeholder="닉네임">
    </div>
  </div>
<button class="btn btn-primary btn-sm" id="findById">아이디 찾기</button>
</form>
</div>

<div id="id-form">
<h1>비밀번호 찾기</h1>
<form method='post'>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="id" class="form-control form-control-sm" id="id" name="id" placeholder="아이디 or 이메일">
    </div>
  </div>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="tel" class="form-control form-control-sm" id="tel" name="tel" placeholder="휴대전화번호">
      <button>인증번호 받기</button>
    </div>
  </div>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="number" class="form-control form-control-sm" id="number" name="number" placeholder="인증번호 입력"><button id="find">인증</button>
    </div>
  </div>
<button class="btn btn-primary btn-sm">비밀번호 찾기</button>
</form>
</div>
<script>


</script>
</body>
</html>