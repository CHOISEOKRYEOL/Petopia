<%@page import="com.pms.petopia.domain.Story"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<!DOCTYPE html>
<html>
<head>
<title>스토리</title>
</head>
<body>
<h1>스토리</h1>
<p><a href='add'>새 스토리</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>제목</th> <th>사이트</th> <th>등록일</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="list" type="List<Story>" scope="request"/>
<%
for (Story s : list) {
%>
<tr> 
  <td><a href='detail?no=<%=s.getNo()%>'><%=s.getNo()%></a></td> 
  <td><a href='<%=s.getUrl()%>'><%=s.getTitle()%></a></td> 
  <td><%=s.getSite()%></td> 
  <td><%=s.getRegisteredDate()%></td> 
</tr>
<%}%>
</tbody>
</table>

<% String keyword = request.getParameter("keyword");%>
<form action='list' method='get'>
<input type='search' name='keyword' value='<%=keyword != null ? keyword : ""%>'> 
<button>검색</button>
</form>
</body>
</html>
    