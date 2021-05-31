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
<h1>${loginUser.nick}님의 우리동네 게시물</h1>
<c:if test="${emptyList eq 'true'}">
  <p>등록된 게시글이 없습니다!</p>
</c:if>
<c:if test="${emptyList ne 'true'}">
<table border='1'>
  <thead>
    <tr>
      <th> 동네 </th>
      <th> 제목 </th>
      <th> 등록일 </th>
      <th> 조회수 </th>
      <th> 추천수 </th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${myTownList}" var="t">
      <tr>
        <td>${t.bigAddress.name} ${t.smallAddress.name} </td>
        <td><a href='../mytown/detail?stateNo=${t.bigAddress.no}&cityNo=${t.smallAddress.no}&no=${t.no}'>${t.title}</a></td>
        <td>${t.createdDate}</td>
        <td>${t.viewCount}</td>
        <td>${t.recommentCount}</td>
      </tr>
    </c:forEach>
  </tbody>
 </table>
</c:if>
</body>
</html>