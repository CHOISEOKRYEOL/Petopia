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
<% 
Member loginUser = (Member) request.getSession().getAttribute("loginUser"); 
%>
<h1><%=loginUser.getNick() %>님의 Q&A 목록</h1>
<p><a href='add'>새 Q&A 작성</a></p>
     <table border='1'>
  <thead> 
  <tr>
  <th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> 
  </tr>
  </thead>
  <tbody>
<% 
  List<Qna> list = (List<Qna>) request.getAttribute("list");
  for(Qna q : list) {
    if(q.getWriter().getNo() == loginUser.getNo()) 
    {
%>
<tr>
<td><%=q.getNo()%></td>
<td><a href='detail?no=<%=q.getNo()%>'><%=q.getTitle()%></a></td>
<td><%=q.getWriter().getNick()%></td>
<td><%=q.getCreatedDate()%></td>
</tr>
<%
    }
}
%>
  </tbody>
  </table>
   </body>
</html>