<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>우리동네 게시글 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<h1>${smallAddress.bigAddress.name}&nbsp;${smallAddress.name}</h1>
	<form action='list' method='get'>
		광역시/도 : <select name='stateNo'>
			<c:forEach items="${smallAddresses}" var="s">
				<option value='${s.bigAddress.no}' ${s.bigAddress.no == smallAddress.bigAddress.no ? "selected" : ""}>${s.bigAddress.name}</option>
			</c:forEach>
		</select> 시/군/구 : <select name='cityNo'>
			<c:forEach items="${smallAddresses}" var="s">
				<option value='${s.no}' ${s.no == smallAddress.no ? "selected" : ""}>${s.name}</option>
			</c:forEach>
		</select> <input type='submit' value='찾기'>
	</form>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
  <li class="nav-item">
    <a href='../main' class="btn" style="background-color: #FFADAD;">메인</a>
		<a href='form?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}' class="btn" style="background-color: #FFADAD;">새 글</a>
		<form class="d-flex" action='list'>
		  <input type='hidden' name='stateNo' value='${smallAddress.bigAddress.no}'>
      <input type='hidden' name='cityNo' value='${smallAddress.no}'>
      <input type='hidden' name='r' value='r'> 
      <button class="btn" style="background-color: #FFFFFF;" type="submit">추천수</button>
    </form>
  </li>
  </ul>
	</div>
  </nav>
	<table border='1' class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="t">
				<tr>
					<td>${t.no}</td>
					<td><a
						href='detail?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}&no=${t.no}'>${t.title}</a></td>
					<c:if test="${t.writer.state == 1}">
          <td>탈퇴 회원</td>					
					</c:if>
					<c:if test="${t.writer.state == 0}">
					<td>${t.writer.nick}</td>
					</c:if>
					<td>${t.createdDate}</td>
					<td>${t.viewCount}</td>
					<td>${t.recommentCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action='list' method='get' class="d-flex">
	  <input type='hidden' name='stateNo' value='${smallAddress.bigAddress.no}'>
    <input type='hidden' name='cityNo' value='${smallAddress.no}'><br>
		<input class="form-control me-2" type='search' name='keyword' value='${param.keyword}' placeholder="검색" aria-label="검색"> 
		<button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
	</form>
</div>
</body>
</html>



