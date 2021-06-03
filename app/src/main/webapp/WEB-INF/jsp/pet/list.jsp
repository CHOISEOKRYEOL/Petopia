<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script type="text/javascript" src="../js/page.js"></script>

</head>

<body>
<header></header>

<img src="../../images/ggjpg.jpg" class="img-fluid width:50;"
style="filter:alpha(opacity=60); opacity:0.7; -moz-opacity:0.4;">
  <div class="text-group">
<h1></h1>

<table class="table table-hover">
<thead>
<tr>
<th style="color:red;">번호</th> <th style="color:red;">사진</th> <th style="color:red;">품종</th> <th style="color:red;">이름</th> <th style="color:red;">나이</th> <th style="color:red;">생일</th> <th style="color:red;">성별</th>  
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var= "pets">
  <c:if test="${not empty pets.photo}">
    <c:set var="photoUrl">../../upload/${pets.photo}_30x30.jpg</c:set>
  </c:if>
  <c:if test="${empty pets.photo}">
    <c:set var="photoUrl">../../images/person_30x30.jpg</c:set>
  </c:if>
 <tr>
 
  <td>${pets.no}   </td> 
  <td><img src='${photoUrl}'></td>
  <td>${pets.type.type}</td>
  <td><a href='detail?no=${pets.no}'>${pets.name}</a></td> 
  <td>${pets.age}</td>
  <td>${pets.birthDay}</td>
  <c:if test="${pets.gender == 0}"> 
  <td> 남 </td> </c:if>
  <c:if test="${pets.gender == 1}">
  <td> 여 </td> </c:if>
</tr>
</c:forEach>
</tbody>
</table>
<a class="d-grid gap-2 d-md-flex justify-content-md-end" href="form" role="button">새 펫</a>
</div>
</form>
</div>
</div>
<footer></footer>
<script>
$(document).ready(function() {
    $("header").load("../../html/header.jsp");
    $("footer").load("../../html/footer.html");
  });
</script>
</body>
</div>
</html>