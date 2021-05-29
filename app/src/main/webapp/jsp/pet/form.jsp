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
<h1>마이펫 등록</h1>
<form action="add" method="post" enctype="multipart/form-data">
이름: <input type="text" name="name"><br>
나이: <input type="int" name="age"><br>
생일: <input type="date" name="birthDay"><br>
성별: <input type="radio" name="gender" value="0">암
      <input type="radio" name="gender" value="1">수<br>
품종: <input type="int" name="type"><br>
      <select>
    <optgroup label="강아지" value="1">
        <option value="">진돗개</option>
        <option value="">푸들</option>
        <option value="">시바</option>
    </optgroup>
    <optgroup label="고양이" value="2">
        <option value="">스핑크스</option>
        <option value="">먼치킨</option>
    </optgroup>
     <optgroup label="기타" value="3">
        <option value="">앵무새</option>
        <option value="">햄스터</option>
    </optgroup>
</select>
사진: <input type="file" name="photo"><br>
<input type="submit" value="등록">
</form>
</body>
</html>