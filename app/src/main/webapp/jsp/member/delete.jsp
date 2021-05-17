<%@page import="com.pms.petopia.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<jsp:useBean id="member" type="com.pms.petopia.domain.Member" scope="request"/>
<h1><%=member.getId()%> 님 그동안 Petopia를 이용해주셔서 감사합니다.</h1>
</body>
</html>