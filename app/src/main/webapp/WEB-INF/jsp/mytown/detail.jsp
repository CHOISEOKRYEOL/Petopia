<%@page import="com.pms.petopia.domain.Member"%>
<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 상세</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<link rel="stylesheet" type="text/css" href="../../css/detailboard.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<header id="header"></header>
<div class="wrap">
<img src="../../images/20180515_203804.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">우리동네</p>
    <p style="font-size: 30px;">우리동네 친구찾기</p>
    <p>동네 커뮤니티로 정보를 나누고 수다 떨며<br>
    같이 산책할 내 반려동물의 친구 사귀어 보세요.</p>
  </div>
</div>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<img src="../../images/IMG_7390.PNG" width=10%; style=margin-right:70%;>
<a class="navbar-brand" style=margin-right:50%>${smallAddress.bigAddress.name}&nbsp;${smallAddress.name}</a>
</nav>
<span class="button"><a href='list?stateNo=${smallAddress.bigAddress.no}&cityNo=${smallAddress.no}'>목록</a></span>
<c:if test="${not empty loginUser}">
    <input id="board-no" type="hidden" name="no" value="${myTownBoard.no}">
    <input id="reco-count" type="hidden" name="rcount" value="${myTownBoard.recommentCount}">
    <button id="reco" type="button" class="reco">추천</button>
        <!--  <a href='recommentadd?no=${myTownBoard.no}' class ='btn'>추천</a> -->
</c:if>
  <form action='update' method='post'>
    <table border='1' id="detailTable" class="detail-table">
      <tbody>
        <tr class = "board-title">
          <td colspan = "8"><h1>${myTownBoard.title}</h1></td>
        </tr>  
        <tr>
          <td colspan = "6"></td>
          <th>작성자</th>
          <c:if test="${myTownBoard.writer.state == 1}">
            <td>탈퇴 회원</td>
          </c:if>
          <c:if test="${myTownBoard.writer.state == 0}">
            <td>${myTownBoard.writer.nick}</td>
          </c:if>
        </tr>
        <tr id="recomentCount">
          <th>조회수</th>
          <td>${myTownBoard.viewCount}</td>
          <th>추천수</th>
          <td colspan="3">${myTownBoard.recommentCount}</td>
          <th>등록일</th>
          <td>${myTownBoard.createdDate}</td>
        </tr>
        <tr>
          <td colspan="8"><span class="content">${myTownBoard.content}</span></td>
        </tr>
      </tbody>
    </table>
  </form>
  
  
  <c:if test="${not empty loginUser and myTownBoard.writer.no == loginUser.no}">
  <div class = "buttons">
    <span class = "button"><a href='update?no=${myTownBoard.no}'>변경</a></span>
    <span class = "button"><a href='delete?no=${myTownBoard.no}'>삭제</a></span>
  </div>
  </c:if>
  
  
  <h1>${result}</h1>
  
  <br>
  <jsp:include page="list_comment.jsp" />
  
  
<c:if test="${not empty loginUser}">
<form action='addComment' method='post'>
  <input id="state-no" type = 'hidden' name = 'stateNo' value='${smallAddress.bigAddress.no}'>
	<input id="city-no" type = 'hidden' name = 'cityNo' value='${smallAddress.no}'>
	<input id="detail-add-no" type='hidden' name='boardNo' value='${myTownBoard.no}'>
	<table class="detail-add-table">
	<tr>
	<td><textarea id="detail-add-comment" name='content' rows='2' cols='80'></textarea></td>
	<td><input id="detail-add-comment-btn" type="button" class="button" value='등록'></td></tr>
	</table>                          
</form>
</c:if>
<script>
  var boardNo = $('#board-no').val();
  var recommentCount = Number($('#detailTable > tbody > tr:nth-child(3) > td:nth-child(4)').html());
  // var recommentCount =  document.querySelector('#recommentCount').innerHTML
  console.log(recommentCount);
  
  $('#reco').click(function(){
   $.ajax({
   	url : "recommentAdd",
   	data : {
   		no : boardNo
   	},
   	success : function(data) {
   		console.log(data);
   		if(data == "fail") {
   			swal("이미 추천한 게시물입니다!", "You clicked the button!", "warning");
   		} else {
   			swal("추천이 완료되었습니다!", "You clicked the button!", "success");
   			$('#detailTable > tbody > tr:nth-child(3) > td:nth-child(4)').html(recommentCount + 1);
   			console.log($('#detailTable > tbody > tr:nth-child(3) > td:nth-child(4)').html());
   		}
   	}
   });
  });
</script>


<script>
"use strict"

$("#detail-add-comment-btn").click(function() {
  var content = $("#detail-add-comment").val();
  var no = $("#detail-add-no").val();
  var stateNo = $("#state-no").val();
  var cityNo = $("#city-no").val();
  console.log(no);
  var xhr = new XMLHttpRequest();
    xhr.open("POST","addComment",true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) {
          if (xhr.status == 200) {
              if(content == ""){
                  alert("댓글내용을 입력해주세요.");
                   return;
                }
	             console.log(content);
	             alert("댓글을 등록했습니다.");
	             window.location.href= "detail?stateNo="+stateNo+"&cityNo="+cityNo +"&no="+no;
              } else {
            alert("요청오류 : " + xhr.status);
            }
          }
      };
      var params = "boardNo="+no+"&content="+encodeURIComponent(content);
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      xhr.send(params);
  }); 


</script>

</div>
<footer></footer>
<script>
$(document).ready(function() {
    $("header").load("../../html/header.jsp");
    $("footer").load("../../html/footer.html");
  });
</script>
</body>
</html>
