<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Q&A 상세보기</title>
</head>
<body>

	<table border='1'>
		<tbody>
			<tr>
				<th>제목</th>
				<td><input name='title' type='text' value='${qna.title}'
					readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name='content' rows='10' cols='60' readonly>${qna.content}
<c:if test="${qna.state == 1}">



■ 관리자 답변 ■

${qna.answer}</c:if>
</textarea></td>
			</tr>
			<br>
		</tbody>
	</table>
	<c:if test="${loginUser.id ne 'admin'}">
		<c:if test="${qna.state == 0}">
			<a href='modifying_form?no=${qna.no}'>수정</a>
		</c:if>
		<a href='delete?no=${qna.no}'>삭제</a>
		<a href='list'>목록</a>
	</c:if>
	<c:if test="${loginUser.id eq 'admin'}">
		<a href='../admin/qnalist'>돌아가기</a>
	</c:if>
</body>
</html>