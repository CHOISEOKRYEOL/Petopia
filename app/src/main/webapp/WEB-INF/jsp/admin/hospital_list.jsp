<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>병원 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<link rel="stylesheet" type="text/css" href="../../css/common.css">
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
<a class="navbar-brand">병원 리스트</a>
  <div class="container-fluid" style="display: block; min-width: 1000px;">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
  <li class="nav-item">
     <a href="/web/app/admin/main" style="color: gray; text-decoration:none;">뒤로가기</a>
    <a href='add' class="botton" >등록</a>
    </li>
    </ul>
 <div class="search" class="form-select form-select-sm" style="margin-bottom:10px; margin-right: 4px; display: block;
 font-size: 12px; font-family: 'Noto Sans KR', sans-serif;">
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
  </div>
</nav>

<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>전화</th> <th>기본주소</th> <th>상세주소</th> <th>진료시간</th> <th>평점</th> <th>처리</th>
</tr>
</thead>
<tbody>

      <c:forEach items="${list}" var="h">
        <tr>
          <td>${h.no}</td>
          <td><a href='../hospital/detail?no=${h.no}'>${h.name}</a></td>
          <td>${h.tel}</td>
          <td>${h.bigAddress.name}&nbsp;${h.smallAddress.name}</td>
          <td>${h.address}</td>
          <td>${h.startTime}시~${h.endTime}시</td>
          <td>${h.rating}</td>
          <td>
          <a href="../hospital/delete?no=${h.no}">삭제</a>
          </td>

        </tr>
      </c:forEach>
    </tbody>
  </table>
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
