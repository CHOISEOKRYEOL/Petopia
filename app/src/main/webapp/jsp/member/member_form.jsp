<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h1>Petopia 회원 가입</h1>
	<form action="add" method="post">
		이름 : <input type="text" name="name"><br>
		
		아이디 : <input id="p-id" type="text" name="id"><button id="checkId" type="button">중복확인</button><br>
		
		이메일 : <input id="p-email" type="email" name="email"><button id="checkEmail" type="button">중복확인</button><br>
		
		닉네임 : <input type="text" id="p-nick" name="nick"><button type="button" id="checkNick">중복확인</button><br>
		
		비밀번호 : <input type="password" name="password"><br>
		비밀번호 확인 : <input type="password" name="checkPassword"><br>
		휴대전화 : <input type="tel" name="tel">
		<input type="button" name="checkTel" value="인증번호 받기"><br> 
			<input type="submit" value="가입하기">
	</form>
	<form action="../main">
		<input type="submit" value="뒤로가기">
	</form>
	
<script>

document.querySelector("#checkId").onclick = function() {
	
	var pId = document.querySelector("#p-id");
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "check?id=" + pId.value, false);
	xhr.send();

	if(xhr.responseText == "yes") {
		alert("이미 존재하는 ID 입니다.");
		pId.value = "";
	}
	else {
		alert("사용 가능한 ID 입니다.");
	}
};

var checkEmail = document.querySelector("#checkEmail").onclick = function() {
    var pEmail = document.querySelector("#p-email");
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "check?email=" + pEmail.value, false);
    xhr.send();
    
    if(xhr.responseText == "yes") {
      alert("이미 존재하는 이메일 입니다.");
      pEmail.value = "";
    }
    else {
      alert("사용 가능한 이메일 입니다.");
    }
  };

  var checkNick = document.querySelector("#checkNick").onclick = function() {
      var pNick = document.querySelector("#p-nick");
      var xhr = new XMLHttpRequest();
      xhr.open("GET", "check?nick=" + pNick.value, false);
      xhr.send();
      
      if(xhr.responseText == "yes") {
        alert("이미 존재하는 닉네임 입니다.");
        pNick.value = "";
      }
      else {
        alert("사용 가능한 닉네임 입니다.");
      }
    };
		
</script>
</body>
</html>