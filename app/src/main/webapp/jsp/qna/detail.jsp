<%@page import="com.pms.petopia.domain.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Q&A 상세보기</title>
</head>
<body>
<jsp:useBean id="qna" type="com.pms.petopia.domain.Qna" scope="request"/>
<form action='update' method='post'>
<table border = '1'>
<tbody>
<tr><th>제목</th><td><input name='title' type='text' value=<%=qna.getTitle()%>></td></tr>
<tr><th>내용</th><td><textarea name='content' rows='10' cols='60'><%=qna.getContent()%></textarea></td></tr><br>
</tbody>
</table>
<input type='hidden' name='no' value=<%=qna.getNo() %>>
<input type='submit' value='수정'>
</form>
<a href='delete?no=<%=qna.getNo()%>'>삭제</a> 
<p><a href='list'>목록</a>
</body>
</html>