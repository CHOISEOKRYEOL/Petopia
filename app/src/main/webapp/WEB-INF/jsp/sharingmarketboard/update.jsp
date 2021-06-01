<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>나눔장터 게시글 상세</title>
</head>
<body>
<h1>나눔장터 게시글 변경</h1>
<c:if test="${not empty smb}">
<form action='update' method='post' enctype='multipart/form-data'>
<table border='1'>
<tbody>
<tr><th>번호</th> <td><input type='text' name='no' value='${smb.no}' readonly></td></tr>
<select name='category'>
<c:forEach items="${catList}" var="cat">
 <option value='${cat.no}' ${smb.category.no  == cat.no ? "selected" : ""}>${cat.name}</option>
</c:forEach>
</select>
<tr><th>제목</th> <td><input type='text' name='title'  value='${smb.title}'></td></tr><br>
<tr><th>내용</th> <td><textarea name='content' rows='10' cols='60'>${smb.content}</textarea></td></tr>
<tr><th>작성자</th> <td>${smb.writer.name}</td></tr>
<tr><th>작성일</th> <td>${smb.createdDate}</td></tr>
<tr><th>조회수</th> <td>${smb.viewCount}</td></tr>
<tr><th>사진</th> <td><input type="file" multiple="multiple" name=photo></td></tr>
</tbody>

<c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
	<tfoot>
	<tr>
	  <td colspan='2'>
	    <input type='submit' value='변경'><a href='delete?no=${smb.no}'>삭제</a>
	  </td>
	</tr>
	</tfoot>    
  </c:if>
  
</table>
</form>
</c:if>
<p><a href='detail?no=${smb.no}'>뒤로가기</a></p>
</body>
</html>

