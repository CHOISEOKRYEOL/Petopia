<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 Q&A 목록</title>
</head>
<body>
	<h1>관리자 Q&A 목록</h1>
	<table border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>상태</th>
				<th>처리1</th>
				<th>처리2</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="q">
				<tr>
					<td>${q.no}</td>
					<td><a href='../qna/detail?no=${q.no}'>${q.title}</a></td>
					<td>${q.writer.nick}</td>
					<td>${q.createdDate}</td>
					<c:if test="${q.state == 1}">
						<td>완료</td>
					</c:if>
					<c:if test="${q.state == 0}">
						<td>대기</td>
					</c:if>
					<td><a href='qnadetail?no=${q.no}'>답변</a></td>
					<td><a href='qnadelete?no=${q.no}'>삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href='../main'>뒤로가기</a>
</body>
</html>