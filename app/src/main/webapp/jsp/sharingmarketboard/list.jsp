<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<title>나눔장터 게시글 목록</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="../main">
     <img src="https://image.flaticon.com/icons/png/512/3047/3047827.png" alt="" width="30" height="24">
     Petopia
    </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
     <div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		  <li class="nav-item">
		    <a class="nav-link" href="../hospital/list">병원찾기</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="../story/list">스토리</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="../sharingmarketboard/list">나눔장터</a>
		  </li>
		  	  <li class="nav-item">
		    <a class="nav-link" href="../mytown/main">우리동네</a>
		  </li>
		</ul>
		
		<ul class="nav">
		  <li class="nav-item">
		    <a class="nav-link" href="#">myPage</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">Login</a>
		  </li>
		</ul>
		
	</div>
  </div>
</nav>

<h1>나눔 장터 게시글 목록</h1>

<p><a href='/web/sharingmarketboard/add'>새 글</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>분류</th> <th>제목</th> <th>작성자</th> <th>작성일</th>
</tr>
</thead>
<tbody>

<c:forEach items="${smBoards}" var="smb">
<tr>
<td>${smb.no}</td>
<td>${smb.category.name}</td>
<td><a href='detail?no=${smb.no}'>${smb.title}</a></td>
<td>${smb.writer.name}</td>
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

<select name='item'>
  <option value='0' ${param.item == "0" ? "selected" : ""}>전체</option>
  <option value='1' ${param.item == "1" ? "selected" : ""}>제목</option>
  <option value='2' ${param.item == "2" ? "selected" : ""}>작성자</option>
</select>
<input type='search' name='keyword' value=''> 
<button type="button" class="btn btn-outline-primary">검색</button>
</tbody>
 </table>
</form>

</body>
</html>
    