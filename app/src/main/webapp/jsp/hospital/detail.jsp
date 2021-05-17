<%@page import="com.pms.petopia.domain.Review"%>
<%@page import="com.pms.petopia.domain.Member"%>
<%@page import="com.pms.petopia.domain.Hospital"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<title>병원 상세</title>
</head>
<body>
<h1>병원 상세보기</h1>
<%
Hospital h = (Hospital) request.getAttribute("hospital");
if (h != null) {
%>
<form action='update' method='post' enctype='multipart/form-data'>
<table border='1'>
<tbody>
<tr>
  <th>번호</th> 
  <td><input type='text' name='no' value='<%=h.getNo()%>' readonly></td></tr>
<tr>
  <th>병원이름</th> 
  <td><input type='text' name='name' value='<%=h.getName()%>'></td></tr>
<tr>
  <th>전화번호</th> 
  <td><input type='tel' name='tel' value='<%=h.getTel()%>'></td></tr>
<tr>
  <th>기본주소</th> 
  <td><select name='gno'><option value=''>분류</option>
                         <option value='1'>서울특별시</option>
                         <option value='2'>경기도</option>
                         <option value='3'>인천광역시</option></select>
      <select name='cno'><option value=''>분류</option>
      <optgroup label='서울특별시'><option value='1'>강남구</option></optgroup>
      <optgroup label='경기도'><option value='2'>김포시</option></optgroup>
      <optgroup label='인천광역시'><option value='3'>중구</option></optgroup></select></td></tr>
<tr>
  <th>상세주소</th> 
  <td><input type='text' name='address' value='<%=h.getAddress()%>'></td></tr>
<tr>
  <th>진료시간</th> 
  <td><input type='number' name='startTime' value='<%=h.getStartTime()%>'>
  <input type='number' name='endTime' value='<%=h.getEndTime()%>'></td></tr>
<tr>
  <th>주차여부</th> 
  <td>
  <input type='radio' name='parking' value='1' <%=h.getParking() == 1 ? "checked" : ""%>>Yes
  <input type='radio' name='parking' value='0' <%=h.getParking() == 0 ? "checked" : ""%>>No</td></tr>
<tr>
  <th>수의사</th> 
  <td><input type='number' name='vet' value='<%=h.getVeterinarian()%>'></td></tr>
<tr>
  <th>사진</th> 
  <td><a href='<%=h.getPhoto() != null ? "../upload/" + h.getPhoto() : ""%>'>
  <img src='<%=h.getPhoto() != null ? "../upload/" + h.getPhoto() + "_300x300.jpg" : "../images/person_80x80.jpg"%>'></a><br>
  <input name='photo' type='file'></td></tr>
</tbody>
<tfoot>
<tr><td colspan='2'>
<input type='submit' value='변경'> <a href='delete?no=<%=h.getNo()%>'>삭제</a>
</td></tr>
</tfoot>
</table>
</form>

<%} else {%>
<p>해당 번호의 병원이 없습니다.</p>
<%}%>
</body>

<head>
<title>병원 리뷰 목록</title>
</head>
<body>
<h1>병원 리뷰</h1>
<%-- 
<%
Member loginUser = (Member) request.getSession().getAttribute("loginUser");
%>
<%
List<Review> list = (List<Review>) request.getAttribute("list");
Hospital h = (Hospital) request.getAttribute("hospital");
for(Review r : list) {
  if(r.getHospital().getNo() == h.getNo()) {
%>

<table border='1'>
  <thead>
  <tr>
  <th>서비스</th> <th>청결도</th> <th>비용</th> <th>작성자</th> <th>내용</th> <th>등록일</th> 
  </tr>
  </thead>
<tbody>
<tr>
<td><%=r.getServiceRating() %>점</td>
<td><%=r.getCleanlinessRating() %>점</td>
<td><%=r.getCostRating() %>점</td>
<td><%=r.getWriter().getNick()%></td>
<td><%=r.getComment()%></td>
<td><%=r.getCreatedDate()%></td>
</tr>
</tbody>  
</table>
<% if(r.getWriter().getNo() == loginUser.getNo()) 
{
%>
      <a href='delete?no=<%=r.getNo()%>'>삭제</a>
<%
      }
    }
  }
%>
--%>
<p><a href='../review/add'>새 리뷰 작성</a></p>
<p><a href='list'>목록</a></p>
<p><a href='../main'>메인</a></p>
</body>
</html>