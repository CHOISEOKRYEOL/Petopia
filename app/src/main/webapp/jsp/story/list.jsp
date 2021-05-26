<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>스토리</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../css/common2.css">
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body>
<header id="header"></header>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand" style="font-size: 30px;">Story</a>
  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
    <li class="nav-item">
      <a href='add' class="btn" style="background-color: #FFADAD;">새 글</a>
    </li>
  </ul>
  <form class="d-flex">
    <input class="form-control me-2" type="search" name="keyword" value='${param.keyword}' placeholder="검색" aria-label="검색">
    <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
  </form>
</nav>

<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>제목</th> <th>사이트</th> <th>등록일</th> <th>스크랩</th>
</tr>
</thead>

<tbody>
<c:forEach items="${storys}" var="s">
<tr> 
  <td>
  <c:if test="${loginUser.id eq 'admin'}">
  <a href='detail?no=${s.no}'>${s.no}</a>
  </c:if>
  <c:if test="${loginUser.id ne 'admin'}">
  ${s.no}
  </c:if>
  </td> 
  <td><a href='${s.url}'>${s.title}</a></td> 
  <td>${s.site}</td> 
  <td>${s.registeredDate}</td> 
  <td>
  <c:set var="count" value="0"/>
  <c:set var="scrapLength" value="${fn:length(scrapList)}"/>
  <c:if test="${not empty loginUser}">
  <c:if test="${empty scrapList}">
  <form action='scrapadd' method='get'>
      <input type='hidden' name='newsNo' value ='${s.no}'>
      <input type='submit' value ='스크랩'>
    </form>
  </c:if>
  <c:if test="${not empty scrapList}">
  <form action='scrapdelete' method='get'>
    <c:forEach items="${scrapList}" var="scrap">
        <c:if test="${scrap.story.no eq s.no}">
          <c:if test="${scrap.isScrap eq 1}">
            <input type='hidden' name='scrapNo' value ='${s.no}'>
            <input type='submit' value ='스크랩취소'>
          </c:if>
        </c:if>
    </c:forEach>
   </form>
   <form action='scrapadd' method='get'>
     <c:set var="count" value="0"/>
     <c:forEach items="${scrapList}" var="scrap">
        <c:if test="${scrap.story.no ne s.no}">
            <c:set var="count" value="${count+1}"/>
            <c:if test="${fn:length(scrapList) eq count}">
            <input type='hidden' name='newsNo' value ='${s.no}'>
            <input type='submit' value ='스크랩'>
            </c:if>
        </c:if>
     </c:forEach> 
   </form>
   </c:if>
   </c:if>
  </td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<footer id="footer"></footer>
</body>
</html>
    