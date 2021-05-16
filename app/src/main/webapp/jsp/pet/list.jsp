<%@page import="com.pms.petopia.service.PetService"%>
<%@page import="com.pms.petopia.domain.Pet"%>
<%@page import="java.util.List"%>
<%@ page 
language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
trimDirectiveWhitespaces="true"%>
    
    
<!DOCTYPE html>
<html>
<head>
<title>마이펫 목록</title>
</head>
<body>
<h1>마이펫 목록(JSP)</h1>
<p><a href='form.html'>새 펫</a>
<table border'1'>
<thead>
<tr>
<th>번호</th> <th>이름></th> <th>나이</th> <th>생일></th> <th>성별</th> <th>품종></th> <th>사진></th>
</tr>
</thead>
<tbody>
<%
List<Pet> list = (List<Pet>) request.getAttribute("list");
for( Pet p : list) {
%>
 <tr> 
  <td><%=p.getNo()%></td> 
  <td><a href='detail?no=<%=p.getNo()%>'></a></td>
  <td><%=p.getOwner().getNo()%></td>
  <td><%=p.getName()%></td>
  <td><%=p.getAge()%></td>
  <td><%=p.getBirthDay()%></td>
  <td><%=p.getGender()%></td>
  <td><%=p.getType()%></td>
  <td><%=p.getPhoto()%></td>
</tr>
<%
}
%>
</tbody>
</table>
</form>
</body>
</html>