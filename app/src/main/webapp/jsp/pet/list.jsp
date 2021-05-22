<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<title>마이펫 목록</title>
</head>
<body>
<h1>마이펫 목록</h1>
<p><a href='add'>새 펫</a>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>나이</th> <th>생일</th> <th>성별</th> <th>품종</th> <th>사진</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var= "pets">
  <c:if test="${not empty pets.photo}">
    <c:set var="photoUrl">../upload/${pets.photo}_30x30.jpg</c:set>
  </c:if>
  <c:if test="${empty pets.photo}">
    <c:set var="photoUrl">../images/person_30x30.jpg</c:set>
  </c:if>
 <tr> 
  <td>${pets.no}</td> 
  <td><a href='detail?no=${pets.no}'>${pets.name}</a></td> 
  <td>${pets.age}</td>
  <td>${pets.birthDay}</td>
  <td>${pets.gender}</td>
  <td>${pets.type.type}</td>
  <td><img src='${photoUrl}'></td> 
</tr>
</c:forEach>

</tbody>
</table>
</form>
</body>
</html>