<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>우리동네 새 게시글</title>
</head>
<body>
<h1>${small.bigAddress.name} ${small.name}</h1>
<h2>우리동네 새 게시글</h2>
<form action='add' method='post'>
광역시/도 : 
<select name ='stateNo'>
<c:forEach items="${smallAddresses}" var="s">
<option value='${s.bigAddress.no}' ${s.bigAddress.no == smallAddress.bigAddress.no ?  "selected" : ""}>${s.bigAddress.name}</option>
</c:forEach>
</select>
시/군/구 : 
<select name='cityNo'>
<c:forEach items="${smallAddresses}" var="s">
<option value='${s.no}' ${s.no == smallAddress.no ?  "selected" : ""}>${s.name}</option>
</c:forEach>
</select><br>

제목: <input type='text' name='title'><br>
내용: <textarea name='content' rows='10' cols='60'></textarea><br>
<a href='list?stateNo=${smallAddress.bigAddress.no} &cityNo=${smallAddress.no}'>목록</a><input type='submit' value='등록'>
</form>
</body>
</html>