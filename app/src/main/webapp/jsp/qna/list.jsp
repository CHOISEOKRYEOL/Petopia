<%@page import="com.pms.petopia.service.QnaService"%>
<%@page import="com.pms.petopia.domain.Qna"%>
<%@page import="java.util.List"%>
<%@page import="com.pms.petopia.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>내 Q&A 목록</title>
</head>
<body>
<jsp:useBean id="loginUser" type="com.pms.petopia.domain.Member" scope="session"/>
<h1><%=loginUser.getNick() %>님의 Q&A 목록</h1>
<p><a href='add'>새 Q&A 작성</a></p>
     <table border='1'>
  <thead> 
  <tr>
  <th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> 
  </tr>
  </thead>
  <tbody>
  <jsp:useBean id="list" type="List<Qna>" scope="request"/>
<% 
  for(Qna q : list) {
    pageContext.setAttribute("q", q);
    if(q.getWriter().getNo() == loginUser.getNo()) 
    {
%>
<tr>
<td>${q.no}</td>
<td><a href='detail?no=${q.no}'>${q.title}</a></td>
<td>${q.writer.nick}</td>
<td>${q.createdDate}</td>
</tr>
<%
    }
}
%>
  </tbody>
  </table>
   </body>
</html>