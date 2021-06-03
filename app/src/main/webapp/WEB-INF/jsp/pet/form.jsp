<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이펫 등록</title>

</head>
<body>
<header></header>
<h1>마이펫 등록</h1>
<form action="add" method="post" enctype="multipart/form-data">
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
<input type="submit" value="등록">

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

</form>
<footer></footer>
</body>
</html>