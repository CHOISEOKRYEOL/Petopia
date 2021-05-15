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
<% 
Qna q = (Qna) request.getAttribute("qna");
if(q != null) {
%>
<form action='update' method='post'>
<table border = '1'>
<tbody>
<tr><th>제목</th><td><input type='text' values='<%=q.getTitle()%>'></td></tr>
<tr><th>내용</th><td><textarea name='content' rows='10' cols='60' values='<%=q.getContent()%>'></td></tr>
<input type='submit' value='수정'></form>
<a href='delete=<%=q.getNo()%>'>삭제</a> 
<%
} else {
%>
  <p>존재하지 않는 글입니다.</p>
<%
}
%>
<p><a href='list'>목록</a>
</body>
</html>