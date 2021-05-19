<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>"
<html>
<head>
<title>나눔장터 게시글 변경</title>
</head>
<body>
<h1>나눔장터 게시글 변경</h1>
<c:if test="${not empty smb}">	
	<c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
		<p>변경 권한이 없습니다!</p>
  	</c:if>
      
<input type='submit' value='등록'>
 <a href='list'>목록</a></p>

<p>나눔장터 게시글을 변경하였습니다.</p>"
</c:if>
</body>
</html>