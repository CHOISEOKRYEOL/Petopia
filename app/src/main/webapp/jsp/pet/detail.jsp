<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<title>게시글 상세</title>
</head>
<body>
<h1>게시글 상세보기</h1>

<c:if test="${not empty pet}">
  <c:if test="${not empty pet.photo}">
    <c:set var="photo80x80Url">../upload/${pet.photo}_80x80.jpg</c:set>
    <c:set var="photoUrl">../upload/${pet.photo}</c:set>
  </c:if>
  <c:if test="${empty pet.photo}">
    <c:set var="photo80x80Url">../images/person_80x80.jpg</c:set>
    <c:set var="photoUrl"></c:set>
  </c:if>
  
 <form action='update' method='post' enctype='multipart/form-data'>
 <table border='1'>
 <tbody>
 <tr><th>번호</th> <td><input type='text' name='no' value='${pet.no}' readonly></td></tr> 
 <tr><th>이름</th> <td><input name='name' type='text' value='${pet.name}'></td></tr>
 <tr><th>나이</th> <td><input name='age' type='text' value='${pet.age}'readonly></td></tr>
 <tr><th>생일</th> <td><input name='birthDay' type='day' value='${pet.birthDay}' readonly></td></tr>
 <tr><th>성별</th> <td><input name='gender' type='int' value='${pet.gender}' readonly></td></tr>
 <tr><th>사진</th> 
  <td><a href='${photoUrl}'>
  <img src='${photo80x80Url}'></a><br>
  <input name='photo' type='file'></td></tr>
 <tr><th>품종</th> <td><input name='type' type='int' value ='${pet.type.type}' readonly></td></tr><br>
 </tbody>
        <tfoot>
        <tr><td colspan='2'>
        <input type='submit' value='변경'>
        </td></tr>
        </tfoot>
      </table>
     </form>
     </c:if>
     
 <p><a href='list'>목록</a></p>
        <a href='delete?no=${pet.no}'>삭제</a>
</body>
</html>
</html>