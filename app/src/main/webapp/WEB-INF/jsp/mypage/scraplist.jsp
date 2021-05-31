<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크랩</title>
</head>
<body>
<h1>${loginUser.nick}님의 기사</h1>
<c:if test="${emptyList eq 'true'}">
  <p>스크랩된 기사가 없습니다!</p>
</c:if>
<c:if test="${emptyList ne 'true'}">
<table border='1'>
  <thead>
    <tr>
      <th> 기사 제목 </th>
      <th> 제공 사이트 </th>
      <th> 스크랩 날짜 </th>
      <th> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${scrapList}" var="s">
      <tr>
        <td><a href='${s.story.url}'>${s.story.title}</a></td>
        <td>${s.story.site}</td>
        <td>${s.story.registeredDate}</td>
        <td>
        <form action='../story/scrapdelete' method='get'>
          <input type="hidden" name='scrapNo' value ='${s.story.no}'>
          <input type="submit" value ='삭제'>
        </form>
        </td>
      </tr>
    </c:forEach>
  </tbody>
 </table>
</c:if>
</body>
</html>