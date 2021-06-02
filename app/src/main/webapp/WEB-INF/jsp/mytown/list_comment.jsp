<%@page import="com.pms.petopia.domain.MyTownBoardComment"%>
<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>댓글 개수 : ${commentCount}</p>
<c:forEach items="${comments}" var="c">
<c:if test="${myTownBoard.no == c.myTownBoard.no}">
<form action='../mytown/updateComment' method='post'>
<table border='1'>
<tbody>
<tr><th>작성자</th><td>${c.writer.nick}</td>
<th>작성일</th><td>${c.createdDate}</td></tr>
<tr><th>내용</th><td><textarea name='content'>${c.content}</textarea></td></tr>
<c:if test="${not empty loginUser and c.writer.no == loginUser.no}">
<tr>
  <td colspan='2'>
    <div id="d2">
        <button type="button" class='modify-btn' data-no='${comt.no}' >수정</button>
        <button type="button" class="remove-btn" data-no="${comt.no}">삭제</button>
    </div>
  </td>
</tr>
</c:if>
</tbody>
</table>
<input type='hidden' name='no' value='${c.no}'/>
</form>
<br>
</c:if>
</c:forEach>
</body>
</html>