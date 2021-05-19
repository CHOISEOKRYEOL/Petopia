<%@page import="com.pms.petopia.domain.Member"%>
<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 상세</title>
</head>
<body>
<%
int stateNo= Integer.parseInt(request.getParameter("stateNo"));
int cityNo = Integer.parseInt(request.getParameter("cityNo"));
int no = Integer.parseInt(request.getParameter("no"));
%>
<jsp:useBean id="smallAddresses" type = "List<SmallAddress>" scope = "request"/>
<jsp:useBean id="myTownBoard" type = "com.pms.petopia.domain.MyTownBoard" scope = "request"/>
<h1><%=myTownBoard.getBigAddress().getName()%>&nbsp;<%=myTownBoard.getSmallAddress().getName()%></h1>
<h2>게시글 상세보기</h2>
<form action='update' method='post'><table border='1'>
<tbody>
<tr><th>광역시/도</th> 
<td><select name ='stateNo'>

<%
for(SmallAddress s : smallAddresses) {
%>
<option value='<%=s.getBigAddress().getNo()%>' <%=s.getBigAddress().getNo() == myTownBoard.getBigAddress().getNo() ?  "selected" : ""%>><%=s.getBigAddress().getName()%></option>
<%
}
%>
</select>
시/군/구 : 
<select name='cityNo'>
<%
for(SmallAddress s : smallAddresses) {
%>
<option value='<%=s.getNo()%>' <%=s.getNo() == myTownBoard.getSmallAddress().getNo() ? "selected" : "" %>><%=s.getName()%></option>
<%
}
%>
</select></td></tr>

<tr><th>번호</th> <td><input type='text' name='no' value='<%=myTownBoard.getNo()%>'readonly></td></tr>
<tr><th>제목</th> <td><input name='title' type='text' value='<%=myTownBoard.getTitle()%>'></td></tr>
<tr><th>내용</th> <td><textarea name='content' rows='10'><%=myTownBoard.getContent()%></textarea></td></tr>
<tr><th>작성자</th> <td><%=myTownBoard.getWriter().getNick()%></td></tr>
<tr><th>등록일</th> <td><%=myTownBoard.getCreatedDate()%></td></tr>
<tr><th>조회수</th> <td><%=myTownBoard.getViewCount()%></td></tr>
<tr><th>추천수</th> <td><%=myTownBoard.getLikeCount()%></td></tr>
<% 
Member loginUser = (Member) request.getSession().getAttribute("loginUser");
if (loginUser != null && myTownBoard.getWriter().getNo() == loginUser.getNo()) {
%>
<tr>
  <td colspan='2'>
    <input type='submit' value='변경'><a href='delete?no=${myTownBoard.no}'>삭제</a>
  </td>
</tr>
<%}%>
</tbody>
</table>
</form><a href='list?stateNo=1&cityNo=1'>목록</a>
<br>
<jsp:include page="/jsp/mytownboardcomment/list.jsp"/>
<form action='../mytowncomment/add' method='post'>
<input type='hidden' name='boardNo' value='${myTownBoard.getNo()}'> <br>
댓글: <textarea name='content' rows='1' cols='30'></textarea><br>
<input type='submit' value='등록'>
</form>
</body>
</html> 
