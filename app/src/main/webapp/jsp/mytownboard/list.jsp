<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<title>우리동네 게시글 목록</title>
</head>
<body>
<<<<<<< HEAD
	<%
	int stateNo = Integer.parseInt(request.getParameter("stateNo"));
	int cityNo = Integer.parseInt(request.getParameter("cityNo"));
	String keyword = request.getParameter("keyword");
	%>
	<jsp:useBean id="smallAddresses" type="List<SmallAddress>"
		scope="request" />
	<jsp:useBean id="smallAddress"
		type="com.pms.petopia.domain.SmallAddress" scope="request" />
	<jsp:useBean id="boards" type="List<MyTownBoard>" scope="request" />
	<h1><%=smallAddress.getBigAddress().getName()%>&nbsp;<%=smallAddress.getName()%></h1>
	<form action='list' method='get'>
		광역시/도 : <select name='stateNo'>
			<%
			for (SmallAddress s : smallAddresses) {
			%>
			<option value='<%=s.getBigAddress().getNo()%>'
				<%=s.getBigAddress().getNo() == smallAddress.getBigAddress().getNo() ? "selected" : ""%>><%=s.getBigAddress().getName()%></option>
			<%
			}
			%>
		</select> 시/군/구 : <select name='cityNo'>
			<%
			for (SmallAddress s : smallAddresses) {
			%>
			<option value='<%=s.getNo()%>'
				<%=s.getNo() == smallAddress.getNo() ? "selected" : ""%>><%=s.getName()%></option>
			<%
			}
			%>
		</select> <input type='submit' value='찾기'>
	</form>
	<p>
		<a href='add?stateNo=1&cityNo=1'>새 글</a>
	<p>
	<table border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
				<th>댓글수</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (MyTownBoard t : boards) {
			%>
			<tr>
				<td><%=t.getNo()%></td>
				<td><a
					href='detail?stateNo=<%=smallAddress.getBigAddress().getNo()%>&cityNo=<%=smallAddress.getNo()%>&no=<%=t.getNo()%>'><%=t.getTitle()%></a></td>
				<td><%=t.getWriter().getNick()%></td>
				<td><%=t.getCreatedDate()%></td>
				<td><%=t.getViewCount()%></td>
				<td><%=t.getCommentCount()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<form action='list' method='get'>
		<input type='search' name='keyword' value=''> <input
			type='hidden' name='stateNo'
			value='<%=smallAddress.getBigAddress().getNo()%>'><br> <input
			type='hidden' name='cityNo' value='<%=smallAddress.getNo()%>'><br>
		<button>검색</button>
	</form>
=======
<%
int stateNo = Integer.parseInt(request.getParameter("stateNo"));
int cityNo = Integer.parseInt(request.getParameter("cityNo"));
String keyword = request.getParameter("keyword");
%>
<jsp:useBean id="smallAddresses" type = "List<SmallAddress>" scope = "request"/>
<jsp:useBean id="smallAddress" type = "com.pms.petopia.domain.SmallAddress" scope = "request"/>
<jsp:useBean id="boards" type = "List<MyTownBoard>" scope = "request"/>
<h1><%=smallAddress.getBigAddress().getName()%>&nbsp;<%=smallAddress.getName()%></h1>
<form action='list' method='get'>
광역시/도 : 
<select name ='stateNo'>
<%
for(SmallAddress s : smallAddresses) {
%>
<option value='<%=s.getBigAddress().getNo()%>' <%=s.getBigAddress().getNo() == smallAddress.getBigAddress().getNo() ?  "selected" : ""%>><%=s.getBigAddress().getName()%></option>
<%
}
%>
</select>
시/군/구 : 
<select name='cityNo'>
<%
for(SmallAddress s : smallAddresses) {
%>
<option value='<%=s.getNo()%>' <%=s.getNo() == smallAddress.getNo() ? "selected" : "" %>><%=s.getName()%></option>
<%
}
%>
</select>

<input type='submit' value='찾기'>
</form>
<p><a href='add?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}'>새 글</a><p><table border='1'>
<thead>
<tr>
<th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> <th>조회수</th> <th>추천수</th>
</tr>
</thead>
<tbody>
<% 
for (MyTownBoard t : boards){
  pageContext.setAttribute("t", t);
%>
<tr> <td>${t.no}</td> <td><a href='detail?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}&no=${t.no}'>${t.title}</a></td> 

<td>${t.writer.nick}</td> <td>${t.createdDate}</td> <td>${t.viewCount}</td> <td>${t.recommendCount}</td></tr>
<%
}
%>
</tbody>
</table>
<form action='list' method='get'>
<input type='search' name='keyword' value=''>
<input type='hidden' name='stateNo' value='${smallAddress.bigAddress.no}'><br>
<input type='hidden' name='cityNo' value='${smallAddress.no}'><br>
<button> 검색 </button>
</form>
>>>>>>> c0a5d0866b751dd681307a61f723ffb7ea73dc75
</body>
</html>

