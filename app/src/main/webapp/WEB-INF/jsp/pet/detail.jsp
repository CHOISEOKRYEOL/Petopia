<%@ page language="java" 
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
<link rel="stylesheet" type="text/css" href="../../css/common.css">
<link rel="stylesheet" type="text/css" href="../../css/layout.css">

<style>
  #form {
    width: 500px;
    margin-left: 550px;
  }
  
  .button {

  background-color: #FFADAD;

  border: none;

  color: white;

  padding: 6px 6px;

  text-align: center;

  text-decoration: none;

  display: inline-block;

  font-size: 16px;

  margin: 4px 2px;

  cursor: pointer;

}
</style>

</head>
<body>
<header></header>
<div class="wrap">
<img src="../../images/mypet.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">내 펫 상세정보</p>
    <p style="font-size: 30px;">나의 귀염둥이 정보</p>
    <p>내 펫에 대한 상세한 정보를 보여주고<br>
    각 정보를 수정할수 있습니다</p> 
  </div>
</div>

<c:if test="${not empty pet}">
  <c:if test="${not empty pet.photo}">
    <c:set var="photo80x80Url">../../upload/${pet.photo}_80x80.jpg</c:set>
    <c:set var="photoUrl">../upload/${pet.photo}</c:set>
  </c:if>
  <c:if test="${empty pet.photo}">
    <c:set var="photo80x80Url">../../images/person_80x80.jpg</c:set>
    <c:set var="photoUrl"></c:set>
  </c:if>
  
 <form action='update' method='post' enctype="multipart/form-data">
 <div id="form">
<table class="table table-hover">
 <tbody>
 <tr><th>번호</th> <td><input name='no' type='text' value='${pet.no}' readonly></td></tr> 
 <tr><th>이름</th> <td><input name='name' type='text' value='${pet.name}'></td></tr>
 <tr><th>나이</th> <td><input name='age' type='text' value='${pet.age}'readonly></td></tr>
 <tr><th>생일</th> <td><input name='birthDay' type='day' value='${pet.birthDay}' readonly></td></tr>
 <tr><th>성별</th> <td><input name='gender' type='text' value='${pet.gender}' readonly></td></tr>
 <tr><th>사진</th> 
  <td><a href='${photoUrl}'>
  <img src='${photo80x80Url}'></a><br>
  <input name='photoFile' type='file'></td></tr>
 <tr><th>품종</th> <td><input type='text' value='${pet.type.type}' readonly></td></tr><br>
 </tbody>
        <tfoot>
        <tr><td colspan='2'>
        <input type='submit' value='변경' class="button"> <a href='delete?no=${pet.no}' class="button">삭제</a>
        </td></tr>
        </tfoot>
      </table>
     </form>
     </c:if>
     <p><a href='list' class="button">목록</a></p>
</div>
</form>
      
      <script>
$(document).ready(function() {
    $("header").load("../../html/header.jsp");
    $("footer").load("../../html/footer.html");
  });
</script>
<footer></footer>
</body>

</html>
</html>