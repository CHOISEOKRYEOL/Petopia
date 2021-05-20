<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>병원 리뷰 목록</title>
</head>
<body>
	<h1>관리자 병원 리뷰 목록</h1>
	<table border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>서비스</th>
				<th>청결도</th>
				<th>비용</th>
				<th>작성자</th>
				<th>내용</th>
				<th>등록일</th>
				<th>처리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="r">
				<tr>
					<td>${r.no}</td>
					<td>${r.serviceRating}점</td>
					<td>${r.cleanlinessRating}점</td>
					<td>${r.costRating}점</td>
					<td>${r.writer.nick}</td>
					<td>${r.comment}</td>
					<td>${r.createdDate}</td>
					<td><a href='reviewdelete?no=${r.no}'>삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form method='get'>
		<select name='item'>
			<option value='0' ${param.item == "0" ? "selected" : ""}>전체</option>
			<option value='1' ${param.item == "1" ? "selected" : ""}>작성자</option>
			<option value='2' ${param.item == "2" ? "selected" : ""}>내용</option>
			<option value='3' ${param.item == "3" ? "selected" : ""}>작성일</option>
		</select> <input type='search' name='keyword' value='${param.keyword}'>
		<button>검색</button>
		<a href='../main'>돌아가기</a>
	</form>
</body>
</html>