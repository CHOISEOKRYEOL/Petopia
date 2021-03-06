<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<link rel="stylesheet" type="text/css" href="../../css/common.css">
<title>관리자 게시판 관리</title>
<style type="text/css">

boady{
width: 1000px;
margin: 0 auto;
font-family: 'Noto Sans KR', sans-serif;
font-size: medium;
vertical-align: middel;
display: center;
}

td{
  margin-top: 10px;
  height: 36px;
  margin-right: 4px;
  line-height: 36px;
  padding: 0 10px 0 11px;
}

.table{
margin: 0 auto;
border: 0px solid #cccccc;

.search{
display: block;
min-width: 1000px;
margin: 0 auto;
  text-align: center;
}

 .button{
  margin-top: 10px;
  display: inline-block;
  height: 36px;
  margin-right: 4px;
  border: 0px;
  border-radius: 6px;
  padding: 0 10px 0 11px;
  line-height: 36px;
  font-weight: 700;
  font-size: 13px;
  text-align: center;
  color: #323232;
  background: #ededed;
} 

.content{
display: block;
min-width: 1000px;
  height: 680;
  padding: 30px 30px 30px 30px;
}

footer{
position: absolute;
bottom: 0;
width: 100%;
}

</style>
</head>
<body>
<header></header>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="display: block;"> 
<a class="navbar-brand">게시글 관리</a>
  <div class="container-fluid" style="display: block; min-width: 1000px;">
    <div class="button">
      <span>
         <a href="/web/app/admin/main" style="color: gray; text-decoration:none;">뒤로가기</a>
      </span>
    </div>
  </div>
</nav>

	<table class="table" border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>추천수</th>
				<th>처리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mList}" var="m">
				<tr>
					<td>${m.no}</td>
					<td>${m.title}</td>
					<td>${m.writer.nick}</td>
					<td>${m.createdDate}</td>
					<td>${m.viewCount}</td>
					<td>${m.recommentCount}</td>
					<td><div class="button">
              <span>
              <a href="../mytown/deleteByAdmin?no=${m.no}">삭제</a>
              </span>
              </div>        
              </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<div class="button">
<span>
  <a href="../main">뒤로가기</a>
</span>
</div>
</div>
	 <footer></footer>
<script>
$(document).ready(function() {
      $("header").load("../../html/header2.jsp");
      $("footer").load("../../html/footer.html");
    });
</script>
</body>
</html>