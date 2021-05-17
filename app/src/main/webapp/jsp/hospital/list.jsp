<%@page import="com.pms.petopia.domain.Hospital"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

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
<% 
List<Hospital> list = (List<Hospital>) request.getAttribute("list");
for (Hospital h : list) {
%>
<tr>
  <td><%=h.getNo()%></td>
  <td><a href='detail?no=<%=h.getNo()%>'><%=h.getName()%></a></td>
  <td><%=h.getTel()%></td>
  <td><%=h.getSmallAddress().getName()%></td>
  <td><%=h.getAddress()%></td>
  <td><%=h.getStartTime()%>시 ~ <%=h.getEndTime()%>시</td>
  <td><%=h.getRate()%></td>
</tr>
<%
}
%>
</tbody>
</table>
</body>
</html>