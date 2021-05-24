<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<h1>마이페이지</h1>
${loginUser.nick}님의 페이지입니다!
<br>
<br>
<form action='scraplist' method='post'>
<input type='submit' value='나의 스크랩'><br>
</form>
<form action='mytownlist' method='post'>
<input type='submit' value='우리동네 나의 게시글'><br>
</form>
</body>
</html>