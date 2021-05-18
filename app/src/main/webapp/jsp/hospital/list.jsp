<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>병원 찾기</title>
</head>
<body>
<h1>병원 찾기</h1>
<p><a href='add'>새 병원</a></p>

<form action='search' method='get'>
<select name='gno'><option value=''>분류</option>
<option value='1'>서울특별시</option>
<option value='2'>경기도</option>
<option value='3'>인천광역시</option></select>
<select name='cno'><option value=''>분류</option>
<optgroup label='서울특별시'>
<option value='1'>강남구</option></optgroup>
<optgroup label='경기도'>
<option value='2'>김포시</option></optgroup>
<optgroup label='인천광역시'>
<option value='3'>중구</option></optgroup></select>
<button>검색</button>
</form>

<table border='1'>
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>전화</th> <th>기본주소</th> <th>상세주소</th> <th>진료시간</th> <th>평점</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="h">
<tr>
  <td>${h.no}</td>
  <td><a href='detail?no=${h.no}'>${h.name}</a></td>
  <td>${h.tel}</td>
  <td>${h.smallAddress.name}</td>
  <td>${h.address}</td>
  <td>${h.startTime}시 ~ ${h.endTime}시</td>
  <td>${h.rate}</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>