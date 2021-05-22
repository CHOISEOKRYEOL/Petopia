<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 게시판 관리</title>
</head>
<body>

<table border='1'>
<thead>
<tr>
<th>번호</th> <th>분류</th> <th>제목</th> <th>작성자</th> <th>작성일</th> <th>처리</th>
</tr>
</thead>
<tbody>
<c:forEach items="sList" var="s">
<tr>
<td>${s.no}</td>
<td>${s.category.name}</td>
<td>${s.title}</td>
<td>${s.writer.name}</td>
<td>${s.createdDate}</td>
<td><a href="../sharingmarketboard/delete?no${s.no}">삭제</a>
</tr>
</c:forEach>
</tbody>
</table>
<table border='1'>
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>추천수</th>
        <th>처리</th>
      </tr>
    </thead>
  <tbody>
<c:forEach items="mList" var="m">
        <tr>
          <td>${m.no}</td>
          <td>${m.title}</td>
          <td>${m.writer.nick}</td>
          <td>${m.createdDate}</td>
          <td>${m.viewCount}</td>
          <td>${m.recommentCount}</td>
          <td><a href="../mytown/delete?no=${m.no}">삭제</a></td>
        </tr>
</c:forEach>
</tbody>
</table>

<a href="../main">뒤로가기</a>
</body>
</html>