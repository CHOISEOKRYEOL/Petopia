<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>새 스토리</title>
</head>
<body>
<h1>새 스토리</h1>
<form action='add' method='post'>
제목: <input type='text' name='title'><br>
URL: <input type='url' name='url'><br>
사이트: <input type='text' name='site'><br>
<input type='submit' value='등록'>
</form>
<form action='../main'>
<input type='submit' value='취소'>
</form>
</body>
</html>
