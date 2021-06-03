<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/common.css">
<link rel="stylesheet" type="text/css" href="../../css/layout.css">

<style>
  #form-add {
    width: 500px;
    margin-left: 650px;
  }
</style>

<style>

.button {

  background-color: #FFADAD;

  border: none;

  color: white;

  padding: 8px 8px;

  text-align: center;

  text-decoration: none;

  display: inline-block;

  font-size: 16px;

  margin: 4px 2px;

  cursor: pointer;

}

</style>

<style>

</style>

</head>

<body>
<header></header>
<div class="wrap">
<img src="../../images/20180115_120703.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">나의 펫 등록</p>
    <p style="font-size: 30px;">소중한 나의 펫 등록</p>
    <p>나의 소중한 펫을 등록을 할수 있습니다<br>
    여러 </p> 
  </div>
</div>
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
</table>
</form>
</form>
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
   
   <script>
   $(document).ready(function() {
	    $("header").load("../../html/header.jsp");
	    $("footer").load("../../html/footer.html");
	  });
   </script>
<footer></footer>
</body>
</html>