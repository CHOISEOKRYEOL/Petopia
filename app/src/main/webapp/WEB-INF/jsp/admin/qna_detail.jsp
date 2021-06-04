<%@page import="com.pms.petopia.domain.Qna"%>
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
<title>Q&A 답변</title>
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

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="display: block;"> 
<a class="navbar-brand">관리자 Q&A 목록</a>
  <div class="container-fluid" style="display: block; min-width: 1000px;">
    <div class="button">
      <span >
        <a href="../main">뒤로가기</a>
      </span>
    </div>
  </div>
</nav>

<div class="content">
	<form action='answer' method='post'>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>질문</th>
					<td><textarea rows='10' cols='60' readonly>${qna.content}
<c:if test="${qna.state == 1}">



■ 관리자 답변 ■

${qna.answer}</c:if></textarea></td>
				</tr>
				<br>
				<tr>
					<th>답변</th>
					<td><textarea = name='answer' rows='10' cols='60'></textarea></td>
				</tr>
			</tbody>
		</table>
		<input class="button" type='hidden' name='no' value='${qna.no}'> <input
			type='submit' value='수정'>
	</form>

	<div class="button"><span><a href='qnalist'>목록</a></span></div>
	
	
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