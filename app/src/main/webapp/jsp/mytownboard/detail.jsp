<%@page import="com.pms.petopia.domain.Member"%>
<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 상세</title>
</head>
<body>
<h1>${smallAddress.bigAddress.name}&nbsp;${smallAddress.name}</h1>
<h2>게시글 상세보기</h2>
<form action='update' method='post'><table border='1'>
<tbody>
<tr><th>광역시/도</th> 
<td><select name ='stateNo'>
<c:forEach items="${smallAddresses}" var="s">
<option value='${s.bigAddress.no}' ${s.bigAddress.no == smallAddress.bigAddress.no ? "selected" : ""}>${s.bigAddress.name}</option>
</c:forEach>
</select></td>
<tr><th>시/군/구</th> 
<td><select name='cityNo'>
<c:forEach items="${smallAddresses}" var="s">
<option value='${s.no}' ${s.no == smallAddress.no ? "selected" : ""}>${s.name}</option>
</c:forEach>
</select></td></tr>

<tr><th>번호</th> <td><input type='text' name='no' value='${myTownBoard.no}'readonly></td></tr>
<tr><th>제목</th> <td><input name='title' type='text' value='${myTownBoard.title}'></td></tr>
<tr><th>내용</th> <td><textarea name='content' rows='10'>${myTownBoard.content}</textarea></td></tr>
<tr><th>작성자</th> <td>${myTownBoard.writer.nick}</td></tr>
<tr><th>등록일</th> <td>${myTownBoard.createdDate}</td></tr>
<tr><th>조회수</th> <td>${myTownBoard.viewCount}</td></tr>

<c:if test="${not empty loginUser and myTownBoard.writer.no == loginUser.no}">
<tr>
  <td colspan='2'>
    <input type='submit' value='변경'>
    <a href='delete?no=${myTownBoard.no}'>삭제</a>
  </td>
</tr>
</c:if>
</tbody>
</table>
</form>
<c:if test="${not empty loginUser}">
<tr>
  <td colspan='2'>
    <input type='submit' value='추천'>
  </td>
</tr>
</c:if>
<a href='list?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}'>목록</a>
<br>
<jsp:include page="/jsp/mytownboardcomment/list.jsp"/>
<form action='../mytowncomment/add' method='post'>
<input type='hidden' name='boardNo' value='${myTownBoard.no}'> <br>
댓글: <textarea name='content' rows='1' cols='30'></textarea><br>
<input type='submit' value='등록'>
</form>
</body>
</html> 
