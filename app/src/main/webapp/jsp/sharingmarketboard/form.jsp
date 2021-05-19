<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>나눔장터 게시판</title>
</head>
<body>
<h1>게시글 등록</h1>
<form action='add' method='post'>
분류: <select name='category'>
<c:forEach items="${catList}" var="category">
<option value='${category.no}'>${category.name}</option>
</c:forEach>
</select>
제목: <input type='text' name='title' ><br>
내용: <textarea name='content' rows='10' cols='60'></textarea><br>
<input type='submit' value='등록'>
</form>
 <a href='list'>목록</a></p>
</body>
</html>
