<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h1>Petopia 회원 가입</h1>
	<form action="add" method="post">
		이름 : <input type="text" name="name"><br> 아이디 : <input
			type="text" name="id"> <input type="button" name="checkId"
			value="중복 확인"><br> 이메일 : <input type="email"
			name="email"> <input type="button" name="checkEmail"
			value="중복 확인"><br> 닉네임 : <input type="text" name="nick">
		<input type="button" name="checkNick" value="중복 확인"><br>
		비밀번호 : <input type="password" name="password"><br> 비밀번호
		확인 : <input type="password" name="checkPassword"><br>
		휴대전화 : <input type="tel" name="tel"> <input type="button"
			name="checkTel" value="인증번호 받기"><br> <input
			type="submit" value="가입하기">
	</form>
	<form action="../main">
		<input type="submit" value="뒤로가기">
	</form>
</body>
</html>