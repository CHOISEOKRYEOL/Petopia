<%@page import="com.pms.petopia.domain.MyTownBoardComment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="comments" type = "List<MyTownBoardComment>" scope = "request"/>
<jsp:useBean id="myTownBoard" type = "com.pms.petopia.domain.MyTownBoard" scope = "request"/>
<%
for(MyTownBoardComment c : comments) {
  if(myTownBoard.getNo() == c.getMyTownBoard().getNo()) {
%>
<table border='1'>
<tbody>
<tr><th>작성자</th><td><%=c.getWriter().getNick()%></td>
<th>작성일</th><td><%=c.getCreatedDate()%></td></tr>
<tr><th>내용</th><td><%=c.getContent()%></td></tr><a href='../mytowncomment/delete?no=<%=c.getNo()%>'> 삭제</a>  <br>
</tbody>
</table>
<br>

<%    
  }
}
%>
</body>
</html>