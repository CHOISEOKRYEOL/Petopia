<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.pms.petopia.domain.Story"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<!DOCTYPE html>
<html>
<head>
<title>스토리 상세</title>
</head>
<body>
<h1>스토리 상세보기</h1>
<% 
Story s = (Story) request.getAttribute("story");
if (s != null) {
%>
<form action='update' method='post'>
<table border='1'>
<tbody>
<tr><th>번호</th> <td><input type='text' name='no' value='<%=s.getNo()%>' readonly></td></tr>
<tr><th>제목</th> <td><input name='title' type='text' value='<%=s.getTitle()%>'></td></tr>
<tr><th>URL</th> <td><input name='url' type='url' value='<%=s.getUrl()%>'></td></tr>
<tr><th>사이트</th> <td><input name='site' type='text' value='<%=s.getSite()%>'></td></tr>
<tr><th>등록일</th> <td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(s.getRegisteredDate())%></td></tr>
</tbody>
<tfoot>
<tr><td colspan='2'>
<input type='submit' value='변경'> <a href='delete?no=<%=s.getNo()%>'>삭제</a></td></tr>
</tfoot>
</table>
</form>

<%} else {%>
<p>해당 번호의 스토리가 없습니다.</p>
<%}%>

<p><a href='list'>목록</a></p>
</body>
</html>
    