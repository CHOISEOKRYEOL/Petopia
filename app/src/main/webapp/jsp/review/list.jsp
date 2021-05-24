<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${list}" var="r">
	<c:set var="photoUrl">../upload/${r.photo}</c:set>
	<c:set var="thumbnail">../upload/${r.photo}_100x100.jpg</c:set>
	<c:if test="${r.hospital.no == hospital.no}">
		<table border='1'>
			<thead>
				<tr>
					<th>서비스</th>
					<th>청결도</th>
					<th>비용</th>
					<th>작성자</th>
					<th>내용</th>
					<th>등록일</th>
					<th>사진</th>
					<c:if test="${loginUser.no == r.writer.no}">
					<th>권한</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${r.serviceRating}점</td>
					<td>${r.cleanlinessRating}점</td>
					<td>${r.costRating}점</td>
					<td>${r.writer.nick}</td>
					<td>${r.comment}</td>
					<td>${r.createdDate}</td>
					<td><a href='${photoUrl}'><img src='${thumbnail}'></a> 
					<c:if test="${r.writer.no == loginUser.no}">
					<td>
					<form action="../review/delete">
					<input type="hidden" name="hno" value="${r.hospital.no}">
					<input type="hidden" name="no" value="${r.no}">
					<input type="submit" value="삭제">
					</form>
					</td>
					</c:if>
				</tr>
			</tbody>
		</table>
	</c:if>
</c:forEach>
