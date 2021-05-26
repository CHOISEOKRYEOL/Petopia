<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form method='post'>
		<table border='1'>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input name='id' type='id' value='${cookie.id.value}'></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input name='password' type='password'></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan='2'><input type='checkbox' name='saveIdOrEmail'>아이디/이메일
						저장</td>
				</tr>
				<tr>
					<td colspan='2'><button>로그인</button></td>
				</tr>
			</tfoot>
		</table>
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
<title>로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../css/common2.css">
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body>
<header id="header"></header>

<div class="container" style="border: 1px solid lightgray;">
<div id="login-form">
  <form method='post'>
    <div class="mt-3 mb-3 row">
      <label for="id" class="col-sm-3 col-form-label">아이디</label>
      <div class="col-sm-9">
      <input type="text" class="form-control" id="id" name="id" value='${cookie.id.value}'>
      </div>
    </div>
    <div class="mb-3 row">
      <label for="password" class="col-sm-3 col-form-label">암호</label>
      <div class="col-sm-9">
      <input type="password" class="form-control" id="password" name="password">
      </div>
    </div>
    <div class="mb-3 form-check">
      <input type="checkbox" class="form-check-input" id="saveIdOrEmail" name="saveIdOrEmail">
      <label class="form-check-label" for="saveIdOrEmail">아이디/이메일 저장</label>
    </div>
    <button class="btn btn-primary">로그인</button>
  </form>
</div>  
</div>
 
<footer id="footer"></footer>
</body>
</html>
--%>