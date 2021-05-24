<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<table border='1'>
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>가입일</th>
				<th>처리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="m">
				<c:if test="${m.role == 1}">
					<tr>
						<td>${m.id}</td>
						<td>${m.nick}</td>
						<td>${m.name}</td>
						<td>${m.email}</td>
						<td>${m.tel}</td>
						<td>${m.registeredDate}</td>
						<td>
						<form action="../member/delete" method="post">
						<input type="hidden" name="no" value="${m.no}">
						<input type="submit" value="강제 탈퇴">
						</form>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<form method='get'>
		<select name='item'>
			<option value='0' ${param.item == "0" ? "selected" : ""}>전체</option>
			<option value='1' ${param.item == "1" ? "selected" : ""}>아이디</option>
			<option value='2' ${param.item == "2" ? "selected" : ""}>닉네임</option>
			<option value='3' ${param.item == "3" ? "selected" : ""}>이메일</option>
			<option value='4' ${param.item == "4" ? "selected" : ""}>전화번호</option>
		</select> <input type='search' name='keyword' value='${param.keyword}'>
		<button>검색</button>
		<a href="../main">뒤로가기</a>
	</form>
</body>
</html>