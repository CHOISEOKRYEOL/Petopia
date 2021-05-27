<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand" style="font-size: 30px;">Petopia 회원 가입</a>
</nav>
<div class="addform">
  <form action="add" method="post">
  <div class="mt-3 mb-3 row">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-6">
      <input type="text" required class="form-control" id="name" name="name" placeholder="이름">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="id" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-6">
      <input type="text" required class="id" id="id" name="id" placeholder="아이디" oninput="checkId()">
      <!-- <input type="button" name="checkId" value="중복 확인"> -->
    </div>
  </div>
  <div class="mb-3 row">
    <label for="email" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-6">
      <input type="email" required class="form-control" id="email" name="email" placeholder="이메일">
      <input type="button" name="checkEmail" value="중복 확인">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="nick" class="col-sm-2 col-form-label">닉네임</label>
    <div class="col-sm-6">
      <input type="text" required class="form-control" id="nick" name="nick" placeholder="닉네임">
      <input type="button" name="checkNick" value="중복 확인">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-6">
      <input type="password" required class="pass" id="password" name="password" placeholder="비밀번호">
    </div>
  </div>
  
  <div class="mb-3 row">
  <label for="password" class="col-sm-2 col-form-label">비밀번호 확인</label>
  <div class="col-sm-6">
            <input type="password" placeholder="비밀번호 확인" name="checkPassword" 
                required class="pass" id="checkPassword" oninput="checkPwd()">
  </div>
  </div>

  <div class="mb-3 row">
    <label for="tel" class="col-sm-2 col-form-label">휴대전화</label>
    <div class="col-sm-6">
      <input type="tel" required class="form-control" id="tel" name="tel">
      <input type="button" name="checkTel" value="인증번호 받기">
    </div>
  </div>
  
<div class="modal-footer justify-content-between">
<a href='../main' class="btn btn-secondary">메인</a>

<button type="submit" class="btn" style="background-color: #FFADAD;" disabled="disabled">가입하기</button>
</div>

</form>

</div>
</div>


<script>

var idCheck = 0;
var pwdCheck = 0;
function checkId() {
 var inputed = $('.id').val();
 $.ajax({
     url : "checkid",
     data : {
         id : inputed
     },
     success : function(data) {
         if(inputed=="" && data=='0') {
             $(".btn").prop("disabled", true);
             $(".btn").css("background-color", "#aaaaaa");
             $("#id").css("background-color", "#FFCECE");
             idCheck = 0;
         } else if (data == '0') {
             $("#id").css("background-color", "#B0F6AC");
             idCheck = 1;
             if(idCheck==1 && pwdCheck == 1) {
                 $(".btn").prop("disabled", false);
                 $(".btn").css("background-color", "#4CAF50");
                 signupCheck();
             } 
         } else if (data == '1') {
             $(".btn").prop("disabled", true);
             $(".btn").css("background-color", "#aaaaaa");
             $("#id").css("background-color", "#FFCECE");
             idCheck = 0;
         } 
     }
 });
}





</script>

</body>
</html>
