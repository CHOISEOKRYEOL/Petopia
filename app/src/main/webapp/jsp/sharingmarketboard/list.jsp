<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>나눔장터 게시글 목록</title>
</head>
<body>
<h1>나눔 장터 게시글 목록</h1>
<p><a href='/web/sharingmarketboard/add'>새 글</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>분류</th> <th>제목</th> <th>작성자</th> <th>작성일</th>
</tr>
</thead>
<tbody>

<c:forEach items="${smBoards}" var="smb">
<tr>
<td>${smb.no}</td>
<td>${smb.category.name}</td>
<td><a href='detail?no=${smb.no}'>${smb.title}</a></td>
<td>${smb.writer.name}</td>
<td>${smb.createdDate}</td>
</tr>
</c:forEach>
</tbody>
</table>

<form method='get'>
<select name='category'>
<option value='0' >전체</option>
<c:forEach items="${catList}" var="cat">
 <c:if test="${smb.category.no == cat.no}">
      <c:set var="selected" value="selected"/>
    </c:if>
<option value='${cat.no}' ${selected}>${cat.name}</option>
</c:forEach>
</select>

<select name='item'>
  <option value='0' ${param.item == "0" ? "selected" : ""}>전체</option>
  <option value='1' ${param.item == "1" ? "selected" : ""}>제목</option>
  <option value='2' ${param.item == "2" ? "selected" : ""}>작성자</option>
</select>
<input type='search' name='keyword' value=''> 
<button>검색</button>
</tbody>
 </table>
</form>
</body>
</html>
    