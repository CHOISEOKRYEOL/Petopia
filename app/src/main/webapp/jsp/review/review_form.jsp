<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
</head>
<body>
<h1>리뷰 등록</h1>
<form method="post">
서비스 : <select name="serviceRating" id="selectBox">
<option value="1" selected>1점</option>
<option value="2">2점</option>
<option value="3">3점</option>
<option value="4">4점</option>
<option value="5">5점</option>
</select>

청결도 : <select name="cleanlinessRating" id="selectBox">
<option value="1" selected>1점</option>
<option value="2">2점</option>
<option value="3">3점</option>
<option value="4">4점</option>
<option value="5">5점</option>
</select>

비용 : <select name="costRating" id="selectBox">
<option value="1" selected>1점</option>
<option value="2">2점</option>
<option value="3">3점</option>
<option value="4">4점</option>
<option value="5">5점</option>
</select>
<br>
<br>
내용 : 
<br>
<textarea name="comment" rows='10' cols='60'></textarea><br>

영수증 : <input type="file" name="photo" accept="image/*"><br>
<input type="submit" value="등록하기">
</form>
<form action="../main">
<input type="submit" value="뒤로가기">
</form>
</body>
</html>