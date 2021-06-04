<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원 즐겨찾기</title>
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
	<table class="table table-hover">
		<thead>
			<tr>
				<th>병원 이름</th>
				<th>병원 주소</th>
				<th>전화번호</th>
				<th>즐겨찾기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="b">
				<tr>
					<td>${b.hospital.name}</td>
					<td>${b.hospital.address}</td>
					<td>${b.hospital.tel}</td>
					<td>
						<form action="delete">
							<input type="hidden" name="no" value="${b.no}"> <input
								type="hidden" name="hno" value="0"> <input type="submit"
								value="★">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="../main">뒤로가기</a></p>
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