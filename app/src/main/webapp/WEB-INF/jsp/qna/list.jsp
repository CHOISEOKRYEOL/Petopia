<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>내 Q&A 목록</title>
</head>
<body>
	<h1>${loginUser.nick}님의Q&A 목록</h1>

	<table border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>답변</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="q">
				<c:if test="${q.writer.no == loginUser.no}">
					<tr>
						<td>${q.no}</td>
						<td><a href='detail?no=${q.no}'>${q.title}</a></td>
						<td>${q.writer.nick}</td>
						<td>${q.createdDate}</td>
						<c:if test="${q.state == 0}">
							<td>대기</td>
						</c:if>
						<c:if test="${q.state == 1}">
							<td>완료</td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href='qna_form'>새 Q&A 작성</a>
	</p>
	<p>
		<a href='../main'>돌아가기</a>
	</p>
</body>
</html>