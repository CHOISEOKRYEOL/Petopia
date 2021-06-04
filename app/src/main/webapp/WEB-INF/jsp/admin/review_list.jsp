<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<title>병원 리뷰 목록</title>
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
width: 700px;
margin: 0 auto;
border: 1px solid #cccccc;
 font-weight: 500;
  font-size: 16px;
  text-align: center;
}

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

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="display: block;"> 
<a class="navbar-brand">관리자 병원 리뷰 목록</a>
  <div class="container-fluid" style="display: block; min-width: 1000px;">
 <div class="search" class="form-select form-select-sm" style="margin-bottom:10px; margin-right: 4px; display: block;
 font-size: 12px; font-family: 'Noto Sans KR', sans-serif;">
    <form method='get'>
    <select name='item'>
      <option value='0' ${param.item == "0" ? "selected" : ""}>전체</option>
      <option value='1' ${param.item == "1" ? "selected" : ""}>작성자</option>
      <option value='2' ${param.item == "2" ? "selected" : ""}>내용</option>
      <option value='3' ${param.item == "3" ? "selected" : ""}>작성일</option>
    </select> <input type='search' name='keyword' value='${param.keyword}'>
    <button class="button">검색</button>
        <div class="button">
      <span >
        <a href="../main">뒤로가기</a>
      </span>
    </div>
  </form>
  </div>
  </div>
</nav>

<div class="content">
	<table class="table table-hover" >
		<thead>
			<tr>
				<th>번호</th>
				<th>서비스</th>
				<th>청결도</th>
				<th>비용</th>
				<th>작성자</th>
				<th>내용</th>
				<th>등록일</th>
				<th>처리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="r">
				<tr>
					<td>${r.no}</td>
					<td>${r.serviceRating}점</td>
					<td>${r.cleanlinessRating}점</td>
					<td>${r.costRating}점</td>
					<td>${r.writer.nick}</td>
					<td>${r.comment}</td>
					<td>${r.createdDate}</td>
					<td><a href='../review/delete?no=${r.no}'>삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<footer></footer>
	<script>
$(document).ready(function() {
      $("header").load("../../html/header.jsp");
      $("footer").load("../../html/footer.html");
    });
</script>
</body>
</html>