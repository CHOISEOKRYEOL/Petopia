<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원찾기</title>
</head>
<body>
<h1>병원 등록</h1>
<form action="add" method="post" enctype="multipart/form-data">
병원이름 <input type="text" name="name"><br>
전화번호 <input type="tel" name="tel"><br>
기본주소 <select name='gno'>
          <option value=''>분류</option>
          <option value='1'>서울특별시</option>
          <option value='2'>경기도</option>
          <option value='3'>인천광역시</option>
         </select>
         <select name='cno'>
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
         </select><br>
상세주소 <input type="text" name="address"><br>
진료시간 <input type="number" name="startTime" min="0" max="24" value="0">시 
         <input type="number" name="endTime" min="0" max="24" value="0">시<br>
주차여부 <input type="radio" name="parking" value="1">Yes
         <input type="radio" name="parking" value="0">No<br>
수의사 <input type="number" name="vet" min="1" max="50" value="1">명<br>
병원사진 <input type="file" name="photo" id="imageFileOpenInput" accept="image/*"><br>
<input type="submit" value="등록">
</form>
<form action="../main">
<input type="submit" value="취소">
</form>
</body>
</html>