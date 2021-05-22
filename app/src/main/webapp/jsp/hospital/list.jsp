<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>병원 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>
<div class="container">
<h1>병원 찾기</h1>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
  <li class="nav-item">
    <a href='../main' class="btn" style="background-color: #FFADAD;">메인</a>
    <a href='add' class="btn" style="background-color: #FFADAD;">새 글</a>
    </li>
    </ul>
    <form class="d-flex" action='list' method='get'>
<select name='gno'>
  <c:forEach items="${area}" var="a">
    <option value='${a.bigAddress.no}'>${a.bigAddress.name}</option>
  </c:forEach>
</select>
<select name='cno'>
  <c:forEach items="${area}" var="a">
    <option value='${a.no}'>${a.name}</option>
  </c:forEach>
</select>
      <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
    </form>
  </div>
</nav>

<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>전화</th> <th>기본주소</th> <th>상세주소</th> <th>진료시간</th> <th>평점</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="h">
<tr>
  <td>${h.no}</td>
  <td><a href='detail?no=${h.no}'>${h.name}</a></td>
  <td>${h.tel}</td>
  <td>${h.bigAddress.name}&nbsp;${h.smallAddress.name}</td>
  <td>${h.address}</td>
  <td>${h.startTime}시 ~ ${h.endTime}시</td>
  <td>${h.rate}</td>
</tr>
</c:forEach>

</tbody>
</table>
</div>
</body>
</html>