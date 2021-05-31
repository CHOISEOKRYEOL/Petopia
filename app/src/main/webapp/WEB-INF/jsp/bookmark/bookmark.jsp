<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원 즐겨찾기</title>
</head>
<body>
	<h1>병원 즐겨찾기 리스트</h1>
	<table border='1'>
		<thead>
			<tr>
				<th>병원 이름</th>
				<th>병원 주소</th>
				<th>전화번호</th>
				<th>즐겨찾기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="b">
				<tr>
					<td>${b.hospital.name}</td>
					<td>${b.hospital.address}</td>
					<td>${b.hospital.tel}</td>
					<td>
						<form action="bookmarkdelete">
							<input type="hidden" name="no" value="${b.no}"> <input
								type="hidden" name="hno" value="0"> <input type="submit"
								value="★">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="../main">뒤로가기</a></p>
</body>
</html>