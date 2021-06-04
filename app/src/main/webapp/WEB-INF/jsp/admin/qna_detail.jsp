<%@page import="com.pms.petopia.domain.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<link rel="stylesheet" type="text/css" href="../../css/common.css">
<link rel="stylesheet" type="text/css" href="../../css/board.css">
<title>Q&A 답변</title>
<style>
body{
font-family: 'Noto Sans KR', sans-serif;
font-size: medium;
}

form{
  margin: 0 auto;
  display: center;
text-align: center;
}

td{
  padding: 10px;
}

table{
border: 0px;
 font-weight: 500;
  font-size: 16px;
  margin: 0 auto;
  display: center;
text-align: center;
}

 .button{
  margin-top: 10px;
  display: inline-block;
  height: 36px;
  margin-right: 4px;
  border: 0px;
  border-radius: 6px;
  padding: 0 10px 0 11px;
  line-height: 36px;
  font-weight: 700;
  font-size: 13px;
  text-align: center;
  color: #323232;
  background: #ededed;
} 

.button3{
color: rgb(252, 116, 116); background: rgba(255, 173, 173, 0.30);
} 

.content{
  padding: 10px 10px 10px 10px;
}

.footer{
position: relative;
bottom: 0;
width: 100%;
}

a{
text-decoration:none
}

.button-area{
  margin-right: 60px;
  margin-top: 0px;
  margin-bottom: 30px;
}

.btnHeadr{
  margin: 10px;
  position: relative;
  margin-top: 3px;
  margin-bottom: 10px;
  font-size: 12px;
}


</style>
</head>
<body>
<header></header>
	
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="display: block;"> 
<a class="navbar-brand">관리자 Q&A 관리</a>
  <div class="container-fluid" style="display: block; min-width: 1000px;">
   <div class="button"><span><a href='qnalist' style="color: gray;">목록</a></span></div>
  </div>
</nav>


<div class="content">
  <form class="frm"
    action='answer' method='post'>
    <table>
      <tbody>
        <tr>
          <th></th>
          <td>
          <div class="writingHeadr">
		      <h4 class="title">Q. ${qna.title}</h4>
		      </div>
      <textarea rows='10' cols='60' readonly>${qna.content}
<c:if test="${qna.state == 1}">



■ 관리자 답변 ■

${qna.answer}</c:if></textarea></td>
        </tr>
        <br>
        <tr>
          <th></th>
          <td>
            <div class="writingHeadr">
            <h4 class="title">A. 관리자 답변</h4>
            </div>
            <textarea name='answer' rows='10' cols='60'></textarea></td>
        </tr>
      </tbody>
    </table>
    <input type='hidden' name='no' value='${qna.no}'>
    <div class="btnHeadr">
    <input class="button" style="color: rgb(252, 116, 116); background: rgba(255, 173, 173, 0.30);" type='submit' value='답변'>
      <div class="button"><span><a href='qnalist' style="color: gray;">목록</a></span></div>
  </div>
  </form>
	
	</div>
	</div>
	<script>
$(document).ready(function() {
      $("header").load("../../html/header2.jsp");
      $("footer").load("../../html/footer.html");
    });
</script>
</body>
</html>