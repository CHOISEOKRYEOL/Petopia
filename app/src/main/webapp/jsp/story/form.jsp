<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>새 스토리</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<script type="text/javascript">
$(function(){
	$("header").load("../jsp/header.jsp");
	$("footer").load("../jsp/footer.jsp");
});
</script>
</head>
<body>
<header id="header"></header>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand" style="font-size: 30px;">새 스토리</a>
</nav>
<div class="addform">
<form action='add' method='post'>
  <div class="mt-3 mb-3 row">
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
</div>
<div class="modal-footer justify-content-between">
<a href='list' class="btn btn-secondary">목록</a>
<input class="btn" style="background-color: #FFADAD;" type='submit' value='등록'>
</div>
</form>
</div>

<footer id="footer"></footer>
</body>
</html>
