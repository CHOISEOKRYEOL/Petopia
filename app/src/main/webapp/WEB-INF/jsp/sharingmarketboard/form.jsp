<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>나눔장터 게시판</title>
</head>
<body>
<h1>게시글 등록</h1>
<form action='add' method='post' enctype='multipart/form-data'>
분류: <select name='category'>
<c:forEach items="${catList}" var='category'>
<option value='${category.no}'>${category.name}</option>
</c:forEach>
</select>
제목: <input type='text' name='title'><br>
내용: <textarea name='content' rows='10' cols='60'></textarea><br>
사진: <input type="file" multiple="multiple" name="photo">
<input type='submit' value='등록'>
</form>

 <a href='list'>목록</a>
</body>
</html>
