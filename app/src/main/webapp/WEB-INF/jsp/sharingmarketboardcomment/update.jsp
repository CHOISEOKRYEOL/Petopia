<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>나눔장터 댓글</title>
</head>
<body>
<c:if test="${not empty comtList}">
<c:forEach items="${comtList}" var="comt">
<form action='../sharingmarketboardcomment/update' method='post'>
<input type='hidden' name='no' value='${comt.no}' readonly>
<table border='1'>
<tr>
<td bgcolor="pink">작성자</td> <td bgcolor="pink">작성일</td></tr>
<tr>
<td id="c-nick">${comt.writer.name}</td>
<td>${comt.createdDate}</td></tr>
<tr>
<td colspan="2">${comt.content}</td>
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
     -->