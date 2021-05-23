<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원찾기</title>
</head>
<body>
	<h1>병원 등록</h1>
	<form action="add" method="post" enctype="multipart/form-data">
		<table border='1'>
			<tbody>
				<tr>
					<th>병원이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="tel"></td>
				</tr>
				<tr>
					<th>기본주소</th>
					<td><select name='gno'>
							<option value=''>분류</option>
							<option value='1'>서울특별시</option>
							<option value='2'>경기도</option>
							<option value='3'>인천광역시</option>
					</select> <select name='cno'>
							<option value=''>분류</option>
							<optgroup label="서울특별시">
								<option value='1'>강남구</option>
							</optgroup>
							<optgroup label="경기도">
								<option value='2'>김포시</option>
							</optgroup>
							<optgroup label="인천광역시">
								<option value='3'>중구</option>
							</optgroup>
					</select></td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>진료시간</th>
					<td><input type="number" name="startTime" min="0" max="24"
						value="0">시 <input type="number" name="endTime" min="0"
						max="24" value="0">시</td>
				</tr>
				<tr>
					<th>주차여부</th>
					<td><input type="radio" name="parking" value="1">Yes <input
						type="radio" name="parking" value="0">No</td>
				</tr>
				<tr>
					<th>수의사</th>
					<td><input type="number" name="vet" min="1" max="50" value="1">명</td>
				</tr>
				<tr>
					<th>병원사진</th>
					<td><input type="file" name="photo" id="imageFileOpenInput"
						accept="image/*"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan='2'><input type="submit" value="등록"></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<form action="list">
		<input type="submit" value="취소">
	</form>
</body>
</html>