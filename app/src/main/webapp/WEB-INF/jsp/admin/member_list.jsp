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
<title>회원 목록</title>
<style type="text/css">

body{
width: 100%;
margin: 0 auto;
font-family: 'Noto Sans KR', sans-serif;
font-size: medium;
}

td{
  margin-top: 10px;
  height: 36px;
  margin-right: 4px;
  line-height: 36px;
  padding: 0 10px 0 11px;
}

/* .table{
width: 700px;
margin: 0 auto;
border: 1px solid #cccccc;
 font-weight: 500;
  font-size: 16px;
  text-align: center;
} */

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
vertical-align: middle;
display: block;
text-align: center;
/* min-width: 1000px; */
/*   height: 300;*/
  padding: 30px 30px 30px 30px; 
}

footer{
position: relative;
bottom: 0;
width: 100%;
}

a{
text-decoration:none
}

</style>
</head>
<body>
<header></header>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="display: block;"> 
<a class="navbar-brand">회원 관리</a>
  <div class="container-fluid" style="display: block;">
 <div class="search" class="form-select form-select-sm" style="margin-bottom:10px; margin-right: 4px; display: block;
 font-size: 12px; font-family: 'Noto Sans KR', sans-serif;">
  <form method='get'>
    <select name='item'>
      <option value='0' ${param.item == "0" ? "selected" : ""}>전체</option>
      <option value='1' ${param.item == "1" ? "selected" : ""}>아이디</option>
      <option value='2' ${param.item == "2" ? "selected" : ""}>닉네임</option>
      <option value='3' ${param.item == "3" ? "selected" : ""}>이메일</option>
      <option value='4' ${param.item == "4" ? "selected" : ""}>전화번호</option>
    </select> <input type='search' name='keyword' value='${param.keyword}'>
    <button class="button">검색</button>
    <div class="button" style="color: #323232; background: #ededed;">
      <span >
        <a href="../main" style="color: #323232;">뒤로가기</a>
      </span>
    </div>
  </form>
  </div>
  </div>
</nav>


	<table class="table table-hover">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>가입일</th>
				<th>처리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="m">
				<c:if test="${m.role == 1}">
					<tr>
						<td>${m.id}</td>
						<td>${m.nick}</td>
						<td>${m.name}</td>
						<td>${m.email}</td>
						<td>${m.tel}</td>
						<td>${m.registeredDate}</td>
						<td>
						<form action="../member/delete" method="post">
						<input type="hidden" name="no" value="${m.no}">
						<input type="submit" class="btn btn-outline-secondary"
						style="  display: inline-block; padding: 0 10px 0 11px;
              line-height: 36px; font-weight: 700; font-size: 13px;
						  height: 36px; margin-right: 4px;" id="remove" value="강제 탈퇴">
						</form>
						</td>
					</tr>
				</c:if>
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