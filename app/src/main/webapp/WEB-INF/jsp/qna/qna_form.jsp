<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Q&A 작성</title>
</head>
<body>
	<h1>Q&A 작성</h1>
	<form action="add" method='post'>
		<table border='1'>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type='text' name='title' minlength="3"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name='content' rows='10' cols='60' minlength="10"></textarea></td>
				</tr>
				<tr>
					<td><input type='submit' value='작성'></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>