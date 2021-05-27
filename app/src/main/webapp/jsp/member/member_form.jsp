
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../css/common.css">

<script type="text/javascript" src="../js/page.js"></script>
</head>
<body>
<header id="header"></header>
<div class="wrap">
<img src="../images/20180115_115933.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">우리 아이들의 이야기</p>
    <p>동네 커뮤니티로 정보를 나누고, 수다 떨며<br>
    같이 산책할 내 반려동물의 친구를 사귀어 보세요</p> 
  </div>
</div>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand">Petopia 회원 가입</a>
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
    </div>
  </div>
  <div class="mb-3 row">
    <label for="email" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-6">
      <input type="email" required class="email" id="email" name="email" placeholder="이메일" oninput="checkEmail()">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="nick" class="col-sm-2 col-form-label">닉네임</label>
    <div class="col-sm-6">
      <input type="text" required class="nick" id="nick" name="nick" placeholder="닉네임" oninput="checkNick()">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-6">
      <input type="password" required class="password" id="password" name="password" placeholder="비밀번호">
    </div>
  </div>
  
  <div class="mb-3 row">
  <label for="password" class="col-sm-2 col-form-label">비밀번호 확인</label>
  <div class="col-sm-6">
            <input type="password" placeholder="비밀번호 확인" name="checkPassword" 
                required class="password" id="checkPassword" oninput="checkPwd()">
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

<footer id="footer"></footer>

<script>

var idCheck = 0;
var pwdCheck = 0;
var emailCheck = 0;
var nickCheck = 0;
function checkId() {
 var userId = $('.id').val();
 $.ajax({
     url : "checkid",
     data : {
         id : userId
     },
     success : function(data) {
         if(userId=="" && data=='0') {
             $(".btn").prop("disabled", true);
             $(".btn").css("background-color", "#aaaaaa");
             $("#id").css("background-color", "#FFCECE");
             idCheck = 0;
         } else if (data == '0') {
             $("#id").css("background-color", "#B0F6AC");
             idCheck = 1;
             if(idCheck==1 && pwdCheck == 1 && emailCheck == 1 && nickCheck == 1) {
                 $(".btn").prop("disabled", false);
                 $(".btn").css("background-color", "#4CAF50");
                 nameCheck();
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


function checkEmail() {
	 var userEmail = $('.email').val();
	 $.ajax({
	     url : "checkemail",
	     data : {
	         email : userEmail
	     },
	     success : function(data) {
	         if(userEmail=="" && data=='0') {
	             $(".btn").prop("disabled", true);
	             $(".btn").css("background-color", "#aaaaaa");
	             $("#email").css("background-color", "#FFCECE");
	             emailCheck = 0;
	         } else if (data == '0') {
	             $("#email").css("background-color", "#B0F6AC");
	             emailCheck = 1;
	             if(idCheck==1 && pwdCheck == 1 && emailCheck == 1 && nickCheck == 1) {
	                 $(".btn").prop("disabled", false);
	                 $(".btn").css("background-color", "#4CAF50");
	                 nameCheck();
	             } 
	         } else if (data == '1') {
	             $(".btn").prop("disabled", true);
	             $(".btn").css("background-color", "#aaaaaa");
	             $("#email").css("background-color", "#FFCECE");
	             emailCheck = 0;
	         } 
	     }
	 });
	}

function checkNick() {
	   var userNick = $('.nick').val();
	   $.ajax({
	       url : "checknick",
	       data : {
	           nick : userNick
	       },
	       success : function(data) {
	           if(userNick=="" && data=='0') {
	               $(".btn").prop("disabled", true);
	               $(".btn").css("background-color", "#aaaaaa");
	               $("#nick").css("background-color", "#FFCECE");
	               nickCheck = 0;
	           } else if (data == '0') {
	               $("#nick").css("background-color", "#B0F6AC");
	               nickCheck = 1;
	               if(idCheck==1 && pwdCheck == 1 && emailCheck == 1 && nickCheck == 1) {
	                   $(".btn").prop("disabled", false);
	                   $(".btn").css("background-color", "#4CAF50");
	                   nameCheck();
	               } 
	           } else if (data == '1') {
	               $(".btn").prop("disabled", true);
	               $(".btn").css("background-color", "#aaaaaa");
	               $("#nick").css("background-color", "#FFCECE");
	               nickCheck = 0;
	           } 
	       }
	   });
	  }



function checkPwd() {
    var originalPassword = $('.password').val();
    var repeatedPassword = $('#checkPassword').val();
    if(repeatedPassword=="" && (originalPassword != repeatedPassword || originalPassword == repeatedPassword)){
        $(".btn").prop("disabled", true);
        $(".btn").css("background-color", "#aaaaaa");
        $("#checkPassword").css("background-color", "#FFCECE");
    }
    else if (originalPassword == repeatedPassword) {
        $("#checkPassword").css("background-color", "#B0F6AC");
        pwdCheck = 1;
        if(idCheck==1 && pwdCheck == 1 && emailCheck == 1 && nickCheck == 1) {
            $(".btn").prop("disabled", false);
            $(".btn").css("background-color", "#4CAF50");
            nameCheck();
        }
    } else if (originalPassword != repeatedPassword) {
        pwdCheck = 0;
        $(".btn").prop("disabled", true);
        $(".btn").css("background-color", "#aaaaaa");
        $("#checkPassword").css("background-color", "#FFCECE");
        
    }
}

function nameCheck() {
	  var name = $("#name").val();
	  if(name == "") {
	    $(".btn").prop("disabled", true);
	    $(".btn").css("background-color", "#aaaaaa");
	  }
	}


$(".cancelbtn").click(function(){
        $(".name").val('');
        $(".id").val('');
        $(".email").val('');
        $(".nick").val('');
        $(".password").val('');
        $(".checkpassword").val('');
        $(".btn").prop("disabled", true);
        $(".btn").css("background-color", "#aaaaaa");
});


</script>

</body>
</html>
