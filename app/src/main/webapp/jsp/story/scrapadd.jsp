<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<head>
<meta charset="UTF-8">
<title>스크랩</title>
</head>
<body>
<c:if test="${result eq 'success'}">
    뉴스를 스크랩하였습니다!
</c:if>
<c:if test="${result eq 'fail'}">
    이미 스크랩한 뉴스입니다!
</c:if>
</body>
</html>