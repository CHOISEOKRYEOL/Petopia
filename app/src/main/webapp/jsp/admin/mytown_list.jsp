<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우리동네 게시판 관리</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="boards" var="b">
				<tr>
				<td>${b.no}</td>
				<td>${b.title}</td>
				<td>${b.content}</td>
				<td>${b.writer.nick}</td>
				<td>${b.createdDate}</td>
				<td><a href='mytowndelete?no=${b.no}'>삭제</a></td>
				</tr>
		</tbody>
	</table>
	</c:forEach>
</body>
</html>