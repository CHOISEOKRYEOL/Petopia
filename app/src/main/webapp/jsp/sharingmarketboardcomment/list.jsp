<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>나눔장터 댓글</title>
</head>
<body>
<c:if test="${not empty comtList}">
<c:forEach items="${comtList}" var="comt">
<form action='../sharingmarketboardcomment/update' method='post'>
<table border='1'>
<tr>
<td bgcolor="pink">번호</td> <td bgcolor="pink">작성자</td> <td bgcolor="pink">작성일</td></tr>
<tr>
<td><input type='text' name='no' value='${comt.no}' readonly></td>
<td>${comt.writer.name}</td>
<td>${comt.createdDate}</td></tr>
<tr>
<td colspan="3">${comt.content}</td>
</tr>
<tr>
<c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
  
  <td><textarea name='content' rows='1' cols='30'></textarea></td>
	  <td align = "center"><input type='submit' value='변경'></td>
	 <td><a href='../sharingmarketboardcomment/delete?no=${comt.no}'>삭제</a></td>
  </c:if>
 </tr>
  </table>
  </form>
  </c:forEach>
</c:if>

<c:if test="${empty comtList}">
<p>댓글이 없습니다.</p>
</c:if>


</body>
</html>
    