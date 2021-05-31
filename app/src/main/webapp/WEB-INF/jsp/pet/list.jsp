<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    
<!DOCTYPE html>
<html>

<head>
<title>마이펫 목록</title>
</head>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ffd1e0; opacity: 0.9" >
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
        <a class="nav-link " aria-current="page" href="../sharingmarketboard/list">나눔장터</a>
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
<body>
<h1 style="background-color: #e9e9e9; opacity: 0.9" >마이펫 목록</h1>

<table class="table table-hover">
<thead>
<tr>
<th style="color:red;">번호</th> <th style="color:red;">사진</th> <th style="color:red;">품종</th> <th style="color:red;">이름</th> <th style="color:red;">나이</th> <th style="color:red;">생일</th> <th style="color:red;">성별</th>  
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var= "pets">
  <c:if test="${not empty pets.photo}">
    <c:set var="photoUrl">../upload/${pets.photo}_30x30.jpg</c:set>
  </c:if>
  <c:if test="${empty pets.photo}">
    <c:set var="photoUrl">../images/person_30x30.jpg</c:set>
  </c:if>
 <tr>
  <td>
  <div>
    <input type="radio" name="leader" value="1"> ${pets.no} </td> 
  </div>
  <td><img src='${photoUrl}'></td>
  <td>${pets.type.type}</td>
  <td><a href='detail?no=${pets.no}'>${pets.name}</a></td> 
  <td>${pets.age}</td>
  <td>${pets.birthDay}</td>
  <c:if test="${pets.gender == 0}"> 
  <td> 암 </td> </c:if>
  <c:if test="${pets.gender == 1}">
  <td> 수 </td> </c:if>
</tr>
</c:forEach>
</tbody>
</table>
<a class="d-grid gap-2 d-md-flex justify-content-md-end" href="setLeaderPet" role="button">대표펫 등록</a>
<a class="d-grid gap-2 d-md-flex justify-content-md-end" href="add" role="button">새 펫</a>

  <div class="btn-group me-2" role="group" aria-label="First group">
    <button type="button" class="btn btn-outline-secondary">1</button>
    <button type="button" class="btn btn-outline-secondary">2</button>
    <button type="button" class="btn btn-outline-secondary">3</button>
    <button type="button" class="btn btn-outline-secondary">4</button>
  </div>
  
  <div class="d-flex justify-content-center">
  <div class="spinner-border" role="status">
    <span class="visually-hidden">Loading...</span>
  </div>
</div>
</form>
</div>
</div>
</body>
</div>
</html>