<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>스토리</title>
</head>
<body>
<h1>스토리</h1>
<p><a href='add'>새 스토리</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>제목</th> <th>사이트</th> <th>등록일</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="s">
<tr> 
  <td><a href='detail?no=${s.no}'>${s.no}</a></td> 
  <td><a href='${s.url}'>${s.title}</a></td> 
  <td>${s.site}</td> 
  <td>${s.registeredDate}</td> 
</tr>
</c:forEach>
</tbody>
</table>

<form action='list' method='get'>
<input type='search' name='keyword' value='${param.keyword}'> 
<button>검색</button>
</form>

<form action='../main'>
<input type='submit' value='메인'>
</form>
</body>
</html>
    