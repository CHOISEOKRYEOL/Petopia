<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>나눔장터 게시글 목록</title>
<style>
.list-table{
width: 500px;
margin: 0 auto;
border: 1px solid #cccccc;
}
</style>
</head>
<body>
<header id="header"></header>
<div class="wrap">
<img src="../images/20180115_1208492.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">추억을 나누는 나눔 장터</p>
    <p>사용하지 않는 반려동물 용품을<br>
    버리지 말고 동네 친구들에게 나눠 보세요</p>
  </div>
</div>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light"> 
<a class="navbar-brand">나눔 장터 게시글</a>
  <div class="container-fluid">
  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
  <li class="nav-item">
    <a href='add' class="btn" style="background-color: #FFADAD;">새 글</a>
    </li>
    </ul>
    <form class="d-flex" action='list' method='get'>
    <select name='category'>
      <option value='0' >전체</option>
      <c:forEach items="${catList}" var="cat">
	      <c:if test="${smb.category.no == cat.no}">
	        <c:set var="selected" value="selected"/>
	      </c:if>
        <option value='${cat.no}' ${selected}>${cat.name}</option>
      </c:forEach>
    </select>

    <select name='item'>
		  <option value='0' ${param.item == "0" ? "selected" : ""}>전체</option>
		  <option value='1' ${param.item == "1" ? "selected" : ""}>제목</option>
		  <option value='2' ${param.item == "2" ? "selected" : ""}>작성자</option>
    </select>
		<input type='search' name='keyword' value=''> 
		<button class="btn btn-outline-success" type="submit">검색</button>
    </form>
  </div>
</nav>

<h1>나눔 장터 게시글 목록</h1>
<p><a href='/web/sharingmarketboard/add'>새 글</a></p>
<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>사진</th> <th>분류</th> <th>제목</th> <th>작성자</th> <th>작성일</th>
</tr>
</thead>
<tbody>
<c:forEach items="${smBoards}" var="smb">
<tr>
<td>${smb.no}</td>
<td><c:forEach items="${photList}" var="p">
  <c:if test="${not empty p.sharingmarketboard.no and smb.no == p.sharingmarketboard.no}">
    <c:set var="photoUrl">../upload/${p.photo}_30x30.jpg</c:set>
    <img src='${photoUrl}'>
  </c:if>
  <c:if test="${empty p.sharingmarketboard.no}">
    <c:set var="photoUrl">../images/person_30x30.jpg</c:set>
    <img src='${photoUrl}'>
  </c:if>
</c:forEach></td>
<td>${smb.category.name}</td>
<td><a href='detail?no=${smb.no}'>${smb.title}</a></td>
<c:if test="${smb.writer.state == 0}">
<td>${smb.writer.nick}</td>
</c:if>
<c:if test="${smb.writer.state == 1}">
<td>탈퇴 회원</td>
</c:if>
<td>${smb.createdDate}</td>
</tr>
</c:forEach>
</tbody>
</table>



<form method='get'>
<select name='category'>
<option value='0' >전체</option>
<c:forEach items="${catList}" var="cat">
 <c:if test="${smb.category.no == cat.no}">
      <c:set var="selected" value="selected"/>
    </c:if>
<option value='${cat.no}' ${selected}>${cat.name}</option>
</c:forEach>
</select>


 <c:if test="${smb.category.no == cat.no}">
<select name='item'>
  <option value='0' ${param.item == "0" ? "selected" : ""}>전체</option>
  <option value='1' ${param.item == "1" ? "selected" : ""}>제목</option>
  <option value='2' ${param.item == "2" ? "selected" : ""}>작성자</option>
</select>
</c:if>
<input type='search' name='keyword' value='${param.keyword}'> 
<button>검색</button>
</form>

</div>
<footer id="footer"></footer>
</body>
</html>


    