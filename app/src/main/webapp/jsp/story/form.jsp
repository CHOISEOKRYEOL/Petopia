<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>새 스토리</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<style>
  .container {
    width: 500px;
    margin: 0px auto;
  }
</style>
</head>
<body>
<div class="container">
<h1>새 스토리</h1>
<form action='add' method='post'>
  <div class="mb-3 row">
    <label for="title" class="col-sm-2 col-form-label">제목</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="title" name="title">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="url" class="col-sm-2 col-form-label">URL</label>
    <div class="col-sm-10">
      <input type="url" class="form-control" id="url" name="url">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="site" class="col-sm-2 col-form-label">사이트</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="site" name="site">
    </div>
  </div>
<input class="btn" style="background-color: #FFADAD;" type='submit' value='등록'>
<a href='list' class="btn btn-secondary">목록</a>
</form>
</div>
</body>
</html>
