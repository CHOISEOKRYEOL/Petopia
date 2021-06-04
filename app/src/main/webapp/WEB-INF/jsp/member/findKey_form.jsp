<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petopia 아이디 / 비밀번호 찾기</title>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
  crossorigin="anonymous">
<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
  integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
  crossorigin="anonymous"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script><link href="css/common.css" rel="stylesheet" >
<style>
  #id-form {
    width: 500px;
    margin: 50px auto;
  }
</style>

<style>
  #password-form {
    width: 500px;
    margin: 70px auto;
  }
</style>
</head>
<body>

<div id="id-form">
<h1>아이디 찾기</h1>
<form action="findkey" method='post'>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="text" class="form-control form-control-sm" id="name" name="name" placeholder="이름">
    </div>
  </div>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="text" class="form-control form-control-sm" id="nick" name="nick" placeholder="닉네임">
    </div>
  </div>
<button class="btn btn-primary btn-sm" id="findById">아이디 찾기</button>
</form>
</div>

<div id="id-form">
<h1>비밀번호 찾기</h1>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="text" class="form-control form-control-sm" id="id" name="id" placeholder="아이디">
    </div>
  </div>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="number" class="form-control form-control-sm" id="tel" name="tel" placeholder="휴대전화번호">
      <br>
      <button class="btn btn-primary btn-sm" id="firstAuthentication" name="firstAuthentication">인증번호 요청</button>
    </div>
  </div>
  <div class="mb-3 row">
    <div class="col-sm-9">
      <input type="number" class="form-control form-control-sm" id="number" name="number" placeholder="인증번호 입력" style="display: none">
      <br>
      <button class="btn btn-primary btn-sm" id="secondAuthentication" style="display: none">인증</button>
    </div>
  </div>
</div>

<script>

var authenticationNumber = 0;
var confirmNumber = 0;
var phoneNumber = 0;


var temp = function() {
    
    swal("인증 번호 전송", "인증 번호를 입력해주세요.", "info", { button: "확인" });
    
    phoneNumber = $('#tel').val();
    $.ajax({
      url : "checknumber2",
      data : {
        tel : phoneNumber
      },
      success : function(response) {
        confirmNumber = response;
      }
    })
  };
  
$('#secondAuthentication').click(function() {
	var tempNumber = $('#number').val();
	if(tempNumber == confirmNumber) {
		var tempId = $('#id').val();
		phoneNumber = $('#tel').val();
		$.ajax({
			url : "checkpassword",
			data : {
				id : tempId,
				tel : phoneNumber
			},
			success : function(response) {
				console.log("test");
				console.log(response);
				swal("인증 성공", "문자로 임시 비밀번호가 전송됩니다.", "success", { button: "확인"});
			},
			error : function(response) {
				swal("인증 성공", "문자로 임시 비밀번호가 전송됩니다.", "success", { button: "확인"});
			}
			 
		})
	}
	else {
		swal("인증 실패", "다시 인증 해주세요.", "error", { button: "확인"});
		$('#number').val('');
	}
});


$('#firstAuthentication').click(function() {
	var id = $('#id').val();
	var tel = $('#tel').val();
     
     $.ajax({
    	 type : 'POST',
       url : "checkidtel",
       data : {
    	   id : id,
         tel : tel
       },
       success : function(response) {
         if(response == "1") {
        	 authenticationNumber = 1;
        	 
        	 swal("인증 번호 전송", "인증 번호를 입력해주세요.", "info", { button: "확인"});
        	 temp();
        	 
        	 if(authenticationNumber == 1) {
        		 $('#number').show();
        		 $('#secondAuthentication').show();
         }
        	 
         }
         else {
        	 authenticationNumber = 0;
        	   if(authenticationNumber == 0) {
        		   swal("오류", "아이디와 전화번호가 일치하지 않습니다.", "error", { button: "확인"});
                   $('#findPassword').hide();
                   $('#number').hide();
                   $('#secondAuthentication').hide();
                 }
         }
       }
     })
   });
	

</script>
</body>
</html>