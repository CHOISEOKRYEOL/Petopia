<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/web/css/mypage.css">
<link rel="stylesheet" type="text/css" href="/web/css/layout.css">
<link rel="stylesheet" type="text/css" href="/web/css/common.css">
</head>
<body>
<header></header>
<div class="wrap">
<img src="/web/images/mypage.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">${loginUser.nick}님</p>
    <p>마이펫과 자주 가는 병원을 등록하고<br>
    나의 반려동물들을 간단하게 관리해보세요</p> 
  </div>
</div>

<div class="container">
<sidebar></sidebar>

<div class="main">
<div class="main-mypet" style="margin-left: 10px;">
<div id="form-add">
<table class="table table-hover">
<form action="add" method="post" enctype="multipart/form-data">
<h1></h1>
이름: <input type="text" name="name"><br>
나이: <input type="int" name="age"><br>
생일: <input type="date" name="birthDay"><br>
성별: <input type="radio" name="gender" value="0">남
      <input type="radio" name="gender" value="1">여<br>
      
품종: <select id="species" name="species.no">
      <option value="1">강아지</option>
      <option value="2">고양이</option>
      <option value="3">기타</option>
    </select>
    
    <select id="type" name="type.no">
      <option value = "1">진돗개</option>
      <option value = "2">시바</option>
      <option value = "3">저먼 셰퍼드</option>
      <option value = "4">래브라도 리트리버</option>
      <option value = "5">시베리안 허스키</option>
      <option value = "6">포메라니안</option>
      <option value = "7">불도그</option>
      <option value = "8">푸들</option>
      <option value = "9">로트바일러</option>
      <option value = "10">치와와</option>
    </select><br>
   
사진: <input type="file" name="photoFile"><br>
<input type="submit" value="등록"  class="button">
</form>
</table>
</div>
</div>
</div>

<script>
   
   var t1 = document.querySelector("#species");
   var t2 = document.querySelector("#type");
   t1.onchange = function() {
     var xhr = new XMLHttpRequest();
     xhr.open("GET","../../type/type.jsp?species=" + t1.value, false);
     xhr.send();
     
     t2.innerHTML = xhr.responseText;
   }
   </script>
</div>
</div>

<footer></footer>
<script>
$(document).ready(function() {
    $("header").load("/web/html/header.jsp");
    $("sidebar").load("/web/html/sidebar.jsp");
    $("footer").load("/web/html/footer.html");
  });
</script>
</body>
</html>