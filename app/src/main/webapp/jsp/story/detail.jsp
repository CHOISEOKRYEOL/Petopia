<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>스토리 상세</title>
</head>
<body>
<h1>스토리 상세보기</h1>
<c:if test="${not empty story}">
<form action='update' method='post'>
<table border='1'>
  <tbody>
		<tr><th>번호</th> <td><input type='text' name='no' value='${story.no}' readonly></td></tr>
		<tr><th>제목</th> <td><input name='title' type='text' value='${story.title}'></td></tr>
		<tr><th>URL</th> <td><input name='url' type='url' value='${story.url}'></td></tr>
		<tr><th>사이트</th> <td><input name='site' type='text' value='${story.site}'></td></tr>
		<tr><th>등록일</th> <td>${story.registeredDate2}</td></tr>
  </tbody>

  <tfoot>
    <tr><td colspan='2'>
      <input type='submit' value='변경'> <a href='delete?no=${story.no}'>삭제</a></td>
    </tr>
  </tfoot>
</table>
</form>
</c:if>

<c:if test="${empty story}">
<p>해당 번호의 스토리가 없습니다.</p>
</c:if>

<p><a href='list'>목록</a></p>
</body>
</html>
