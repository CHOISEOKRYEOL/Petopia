<%@page import="com.pms.petopia.domain.Hospital"%>
<%@page import="java.util.List"%>
<%@page import="com.pms.petopia.domain.Review"%>
<%@page import="com.pms.petopia.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>병원 리뷰 목록</title>
</head>
<body>
<h1>병원 리뷰</h1>
<jsp:useBean id="loginUser" type="com.pms.petopia.domain.Member" scope="session"/>
<jsp:useBean id="list" type="List<Review>" scope="request"/>
<jsp:useBean id="hospital" type="com.pms.petopia.domain.Hospital" scope="request"/>

<%
for(Review r : list) {
  pageContext.setAttribute("r", r);
  pageContext.setAttribute("photoUrl",
      r.getPhoto() != null ? "../upload/" + r.getPhoto() + "_100x100.jpg" : "");
  if(r.getHospital().getNo() == hospital.getNo()) {
%>
<table border='1'>
  <thead>
  <tr>
  <th>서비스</th> <th>청결도</th> <th>비용</th> <th>작성자</th> <th>내용</th> <th>등록일</th> <th> 사진</th>
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
<td><img src='${photoUrl}'>
</tr>
</tbody>  
</table>
<% if(r.getWriter().getNo() == loginUser.getNo()) 
{
%>
      <a href='delete?no=${r.no}'>삭제</a>
<%
      }
    }
  }
%>
<p><a href='add'>새 리뷰 작성</a></p>
<p><a href='../main'>돌아가기</a></p>
</body>
</html>