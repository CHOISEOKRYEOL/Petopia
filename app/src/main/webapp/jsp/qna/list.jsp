<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>내 Q&A 목록</title>
</head>
<body>
<h1>${loginUser.nick}님의 Q&A 목록</h1>
<p><a href='add'>새 Q&A 작성</a></p>
     <table border='1'>
  <thead> 
  <tr>
  <th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> 
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="q">
  <c:if test="${q.writer.no == loginUser.no}">
<tr>
<td>${q.no}</td>
<td><a href='detail?no=${q.no}'>${q.title}</a></td>
<td>${q.writer.nick}</td>
<td>${q.createdDate}</td>
</tr>
</c:if>
</c:forEach>
  </tbody>
  </table>
   </body>
</html>