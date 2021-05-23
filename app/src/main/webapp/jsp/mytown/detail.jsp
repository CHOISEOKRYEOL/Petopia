<%@page import="com.pms.petopia.domain.Member"%>
<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 상세</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet">
</head>
<body>
	<h1>${smallAddress.bigAddress.name}&nbsp;${smallAddress.name}</h1>
	<h2>게시글 상세보기</h2>
	<form action='update' method='post'>
		<table border='1'>
			<tbody>
				<tr>
					<th>번호</th>
					<td>${myTownBoard.no}</td>
					<th>광역시/도</th>
					<td>${smallAddress.bigAddress.name}</td>
					<th>시/군/구</th>
					<td>${smallAddress.name}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${myTownBoard.title}</td>
					<th>작성자</th>
					<c:if test="${myTownBoard.writer.state == 1}">
						<td>탈퇴 회원</td>
					</c:if>
					<c:if test="${myTownBoard.writer.state == 0}">
						<td>${myTownBoard.writer.nick}</td>
					</c:if>
					<th>등록일</th>
					<td>${myTownBoard.createdDate}</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${myTownBoard.viewCount}</td>
					<th>추천수</th>
					<td>${myTownBoard.recommentCount}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${myTownBoard.content}</td>
				</tr>

				<c:if
					test="${not empty loginUser and myTownBoard.writer.no == loginUser.no}">
					<tr>
						<td colspan='2'><a href='update?no=${myTownBoard.no}'>변경</a>
							<a href='delete?no=${myTownBoard.no}'>삭제</a></td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</form>
	<c:if test="${not empty loginUser}">
		<tr>
			<td colspan='2'><a href='recommentadd?no=${myTownBoard.no}'>추천</a>
			</td>
		</tr>
	</c:if>
	<a
		href='list?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}'>목록</a>
	<br>
	<jsp:include page="/jsp/mytownboardcomment/list.jsp" />
	<form action='../mytowncomment/add' method='post'>
		<input type='hidden' name='boardNo' value='${myTownBoard.no}'>
		<br> 댓글:
		<textarea name='content' rows='1' cols='30'></textarea>
		<br> <input type='submit' value='등록'>
	</form>
</body>
</html>
