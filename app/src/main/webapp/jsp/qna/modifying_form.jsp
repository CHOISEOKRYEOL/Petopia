<%@page import="com.pms.petopia.domain.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Q&A 수정하기</title>
</head>
<body>

<form action='update' method='post'>
<table border = '1'>
<tbody>
<tr><th>제목</th><td><input name='title' type='text' value='${qna.title}'></td></tr>
<tr><th>내용</th><td><textarea name='content' rows='10' cols='60'>${qna.content}</textarea></td></tr><br>
</tbody>
</table>
<input type='hidden' name='no' value='${qna.no}'>
<input type='submit' value='완료'>
</form>
<a href='list'>목록</a>
</body>
</html>