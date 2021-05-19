<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>우리동네 게시글 목록</title>
</head>
<body>
<h1>${smallAddress.bigAddress.name}&nbsp;${smallAddress.name}</h1>
<!-- ${s.bigAddress.no == smallAddress.bigAddress.no ? "selected" : ""}   
 ${s.no == smallAddress.no ? "selected" : ""}-->
<c:set var="smallAddress" value="smallAddress"/>-->
<!--<jsp:useBean id="smallAddress" type = "com.pms.petopia.domain.SmallAddress" scope = "request"/>-->
<form action='list' method='get'>
광역시/도 : 
<select name ='stateNo'>
<c:forEach items="${smallAddresses}" var="s">
<option value='${s.bigAddress.no}'>${s.bigAddress.name}</option>
</c:forEach>
</select>
시/군/구 : 
<select name='cityNo'>

<c:forEach items="${smallAddresses}" var="s">
<option value='${s.no}'>${s.name}</option>
</c:forEach>
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

<c:forEach items="${boards}" var="t">
<tr> <td>${t.no}</td> <td><a href='detail?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}&no=${t.no}'>${t.title}</a></td> 

<td>${t.writer.nick}</td> <td>${t.createdDate}</td> <td>${t.viewCount}</td> <td>${t.likeCount}</td></tr>
</c:forEach>
</tbody>
</table>
<form action='list' method='get'>
<input type='search' name='keyword' value='${param.keyword}'>
<input type='hidden' name='stateNo' value='${smallAddress.bigAddress.no}'><br>
<input type='hidden' name='cityNo' value='${smallAddress.no}'><br>
<button> 검색 </button>
</form>
</body>
</html>

