<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이펫 등록</title>
</head>
<body>
<h1>마이펫 등록</h1>
<form action="add" method="post" enctype="multipart/form-data">
이름: <input type="text" name="name"><br>
나이: <input type="int" name="age"><br>
생일: <input type="date" name="birthDay"><br>
성별: <input type="int" name="gender"><br>
품종: <input type="int" name="type"><br>
사진: <input type="file" name="photo"><br>
<input type="submit" value="등록">
</form>
</body>
</html>