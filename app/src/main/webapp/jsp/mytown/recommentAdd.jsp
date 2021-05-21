<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<head>
<meta charset="UTF-8">
<title>추천</title>
</head>
<body>
<c:forEach items="${recomments}" var="r">
  <c:if test="${r.myTownBoard.no == boardNo and r.recommender.no == loginUser.no}">
    이미 추천한 게시물입니다!
  </c:if>
  <c:if test="${r.myTownBoard.no != boardNo and r.recommender.no == loginUser.no}">
    게시물을 추천하였습니다!
  </c:if>
</c:forEach>
</body>
</html>