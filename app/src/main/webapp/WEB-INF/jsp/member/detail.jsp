<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>내 정보</title>
</head>
<body>
	<form action='update' method='post'>
		<table border='1'>
			<tbody>
				<tr>
					<th>이름</th>
					<td><input name='name' value='${member.name}' readonly></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input name='id' value='${member.id}' readonly></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input name='email' value='${member.email}' readonly></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input name='nick' type='text' value='${member.nick}'></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input name='password' type='password' minlength="8"></td>
				</tr>
				<tr>
					<th>휴대전화</th>
					<td><input name='tel' type='tel' value='${member.tel}' readonly></td>
				</tr>
				<br>
			</tbody>
		</table>
		<input type='submit' value='수정'>
	</form>
	<form action='delete' method='post'>
		<input type='hidden' name='no' value='${member.no}'> <input
			type='submit' name='delete' value='회원탈퇴'>
	</form>
	<p>
		<a href='../main'>메인 화면</a>
	</p>
</body>
</html>