<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<style>
  .container {
    width: 700px;
    margin: 0px auto;
  }
</style>
</head>
<body>

<div class="container">
<h1>병원 등록</h1>
<form action="add" method="post" enctype="multipart/form-data">
  <div class="mb-3 row">
    <label for="name" class="col-sm-2 col-form-label">병원이름</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="tel" class="col-sm-2 col-form-label">전화번호</label>
    <div class="col-sm-10">
      <input type="tel" class="form-control" id="tel" name="tel">
    </div>
  </div>
  
  <div class="form-row mb-3">
  <label for="gno" class="col-sm-2 col-form-label">기본주소</label>
      <select id="gno" class="col-md-4" name='gno'>
          <option value=''>시/도</option>
          <option value='1'>서울특별시</option>
          <option value='2'>경기도</option>
          <option value='3'>인천광역시</option>
         </select>
       <select id="cno" class="col-md-4" name='cno'>
          <option value=''>시/군/구</option>
          <optgroup label="서울특별시">
          <option value='1'>강남구</option>
          </optgroup>
          <optgroup label="경기도">
          <option value='2'>김포시</option>
          </optgroup>
          <optgroup label="인천광역시">
          <option value='3'>중구</option>
          </optgroup>
         </select>
  </div>
  
  <div class="mb-3 row">
    <label for="address" class="col-sm-2 col-form-label">상세주소</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="address" name="address">
    </div>
  </div>
  
  <div class="form-row mb-3">
    <label for="startTime" class="col-sm-2 col-form-label">진료시간</label>
    <input type="number" name="startTime" min="0" max="24" value="0">시 ~ 
    <input type="number" name="endTime" min="0" max="24" value="0">시
  </div>
  
  <div class="form-row mb-3">
    <label for="parking" class="col-sm-2 col-form-label">주차여부</label>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="radio" name="parking" id="parking" value="1">Yes
    </div>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="radio" name="parking" id="parking" value="0">No
    </div>
  </div>
  
  <div class="form-row mb-3">
    <label for="vet" class="col-sm-2 col-form-label">수의사</label>
    <input type="number" name="vet" min="1" max="50" value="1">명
  </div>
  
  <div class="form-row mb-3">
    <label for="photo" class="col-sm-2 col-form-label">병원사진</label>
    <input type="file" name="photo" id="imageFileOpenInput" accept="image/*">
  </div>
  
<input class="btn" style="background-color: #FFADAD;" type='submit' value='등록'>
<a href='list' class="btn btn-secondary">목록</a>

</form>
</div>
</body>
</html>