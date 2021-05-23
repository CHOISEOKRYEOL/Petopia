<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<head>
<meta charset="UTF-8">
<title>추천</title>
</head>
<body>
<c:if test="${result eq 'success'}">
    게시물을 추천하였습니다!
</c:if>
<c:if test="${result eq 'fail'}">
    이미 추천한 게시물입니다!
</c:if>
</body>
</html>