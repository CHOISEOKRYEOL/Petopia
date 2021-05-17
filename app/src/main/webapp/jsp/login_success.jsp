<%@page import="com.pms.petopia.domain.Member"%>
<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
<h1>로그인 결과</h1>
<jsp:useBean id="loginUser" type="com.pms.petopia.domain.Member" scope="request"/>
<p><%=loginUser.getNick()%> 님 Petopia에 오신 걸 환영합니다.</p>
</body>
</html>