<%@page import="com.pms.petopia.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 변경</title>
</head>
<jsp:useBean id="member" type="com.pms.petopia.domain.Member" scope="request"/>
<body>
<h1><%=member.getId() %> 님의 정보가 성공적으로 변경되었습니다.</h1>
</body>
</html>