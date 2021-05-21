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
<h1>${oldBoard.bigAddress.name}&nbsp;${oldBoard.smallAddress.name}</h1>
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

<tr><th>번호</th> <td><input type='text' name='no' value='${oldBoard.no}'readonly></td></tr>
<tr><th>제목</th> <td><input name='title' type='text' value='${oldBoard.title}'></td></tr>
<tr><th>내용</th> <td><textarea name='content' rows='10'>${oldBoard.content}</textarea></td></tr>
<tr><th>작성자</th> <td>${oldBoard.writer.nick}</td></tr>
<tr><th>등록일</th> <td>${oldBoard.createdDate}</td></tr>
<tr><th>조회수</th> <td>${oldBoard.viewCount}</td></tr>

<c:if test="${not empty loginUser and oldBoard.writer.no == loginUser.no}">
<tr>
  <td colspan='2'>
    <input type='submit' value='변경'>
    <!--<a href='delete?no=${myTownBoard.no}'>삭제</a>-->
  </td>
</tr>
</c:if>
</tbody>
</table>
</form>
<a href='list?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}'>목록</a>
<br>
</body>
</html> 
