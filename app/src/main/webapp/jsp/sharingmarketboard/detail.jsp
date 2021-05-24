<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>나눔장터 게시글 상세</title>
</head>
<body>
<h1>나눔장터 게시글 상세보기</h1>
<c:if test="${not empty smb}">
<table border='1'>
<tbody>
<tr><th>번호</th> <td>${smb.no}</td>
<th>분류</th> <td colspan="3">${smb.category.name}</td></tr>
<tr><th>작성자</th> <td>${smb.writer.name}</td>
<th>작성일</th> <td>${smb.createdDate}</td>
<th>조회수</th> <td>${smb.viewCount}</td></tr>
<tr><th>제목</th> <td colspan="5">${smb.title}</td></tr>
<tr><th>내용</th> <td colspan="5">${smb.content}</td></tr>
<tr><th>사진</th>

<td>
<form action='../sharingmarketboardphoto/add' method='post'>
<c:forEach items="${photList}" var="phot">
  <c:if test="${not empty phot.photo}">
    <c:set var="photoUrl">../upload/${phot.photo}_30x30.jpg</c:set>
  </c:if>
  <c:if test="${empty phot.photo}">
    <c:set var="photoUrl">../images/person_30x30.jpg</c:set>
  </c:if>
	<tr> 
	  <td>${phot.no}</td> 
	  <td><img src='${photoUrl}'></td> 
	  <td><a href='detail?no=${phot.no}'>${phot.name}</a></td> 
	</tr>
	<tr><td><input type='submit' value='등록'></td></tr>
</c:forEach>
</form>
</td>
</tr>

</tbody>
</table>


<c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
	<tfoot>
	<tr>
	  <td colspan='2'>
	    <a href='update?no=${smb.no}'>변경</a><a href='delete?no=${smb.no}'>삭제</a>
	  </td>
	</tr>
	</tfoot>    
  </c:if>
  </c:if>
  
<c:if test="${empty smb}">
<p>해당 번호의 게시글이 없습니다.</p>
</c:if>

<jsp:include page="/jsp/sharingmarketboardcomment/list.jsp"/>

<!--<c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
<form action='../sharingmarketboardcomment/add' method='post' enctype="multipart/form-data">
<table border='1'>
<tr><td><input type='hidden' name='no' value='${smb.no}'> <br></td>
<td><textarea name='content' rows='10' cols='20'></textarea></td>
<td><input type='submit' value='등록'></td></tr>
  </table>
  </form>
  </c:if>-->
  
 <jsp:include page="/jsp/sharingmarketboardphoto/form.jsp"/>
  
  
<p><a href='list'>목록</a></p>
</body>
</html>

