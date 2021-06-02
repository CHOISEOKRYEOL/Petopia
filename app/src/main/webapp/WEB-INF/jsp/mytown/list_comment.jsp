<%@page import="com.pms.petopia.domain.MyTownBoardComment"%>
<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.comment-table{
width: 700px;
margin: 0 auto;
border: 1px solid #cccccc;
}
#comment-remove, #comment-modify {
/*display: none;*/
margin: 10px;
}
button {
text-align: center;
border: 1px solid #cccccc;
}
th,tr{
padding: 5px;
}
</style>

</head>
<body>
<p>댓글 개수 : ${commentCount}</p>

<div id="comment-modify">
      <textarea id="modify-content" rows="3" cols="50"></textarea>
      <button type="button" id="comment-modify-btn">수정 확인</button>
     <button type="button" id="comment-modify-cancle-btn">수정 취소</button>
</div>

<div id="comment-remove">
      <b>정말 삭제하시겠습니까?</b>
      <button type="button" id="comment-remove-btn">삭제 확인</button>
      <button type="button" id="comment-remove-cancle-btn">삭제 취소</button>
</div>

<c:forEach items="${comments}" var="c">
<c:if test="${myTownBoard.no == c.myTownBoard.no}">

<form action='../mytown/updateComment' method='post'>
<table class ="comment-table">
<tr><td bgcolor="pink">작성자</td><td bgcolor="pink">작성일</td></tr>
<tr>
<td>${c.writer.nick}</td>
<td>${c.createdDate}</td></tr>
<tr><td id="comment-btn"></td></tr>
<tr>
  <tr><td colspan='2'><c:if test="${not empty loginUser and c.writer.no == loginUser.no}">
    <div id="d2">
        <button type="button" class='modify-btn' data-no='${c.no}' >수정</button>
        <button type="button" class="remove-btn" data-no="${c.no}">삭제</button>
    </div>
</c:if></td></tr>
   <tr><td class="c-cont" data-no="${c.no}" colspan="2" style="white-space:pre;"><span>${c.content}</span></td></tr>
</table>
<input type='hidden' name='no' value='${c.no}'/>
</form>
<br>
</c:if>
</c:forEach>

<c:if test="${empty coments}">
<!--   <p>댓글이 없습니다.</p> -->
</c:if>


<script>  
"use strict"

//--------------버튼 초기화
function resetBtn(){
  $('.modify-btn').css('display', '');
  $('.remove-btn').css('display', '');
};

//--------------수정버튼을 눌렀을시
var commentModifyDiv = $('#comment-modify'),
    commentModifyTa = commentModifyDiv.find('textarea');
    
commentModifyDiv.css('display', 'none');

$('.modify-btn').click(function(e) {
  var comtNo = $(this).attr("data-no");
  var comtTd = $('.c-cont[data-no=' + comtNo + ']');
  var comtSpan = comtTd.find('span');
  comtSpan.css('display', 'none');
  comtTd.append(commentModifyDiv);
  commentModifyTa.val(comtSpan.html());
  commentModifyTa.attr('data-no', comtNo);
  commentModifyDiv.css('display', '');
});

var commentRemoveDiv = $('#comment-remove');

//--------------삭제버튼을 눌렀을 시
commentRemoveDiv.css('display', 'none');

$('.remove-btn').click(function(e) {
  console.log(this);
   var comtNoRe = $(this).attr("data-no");
   var comtTdRe = $('.c-cont[data-no=' + comtNoRe + ']');
   
   var comtReBtnRe = $('.remove-btn[data-no=' + comtNoRe + ']');
   comtReBtnRe.css('display', 'none');
   var comtMoBtnRe = $('.modify-btn[data-no=' + comtNoRe + ']');
     comtMoBtnRe.css('display', 'none');
     
    comtTdRe.append(commentRemoveDiv);
    commentRemoveDiv.css('display', '');
});

//--------------수정 확인버튼을 눌렀을 시
$('#comment-modify-btn').click(function(e) {
  var commentText = commentModifyTa.val();
  var commentNo = commentModifyTa.attr('data-no');
  console.log(commentNo, commentText);
  
      var xhr = new XMLHttpRequest();
    xhr.open("POST","updateComment",true);
      xhr.onreadystatechange = () => {
          if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                if(commentText ==""){
                    alert("변경할 댓글내용을 입력해주세요.");
                     return;
                  }else if(commentText !=""){
                    alert("댓글을 변경완료 했습니다.");
                    commentModifyDiv.css('display', 'none');
                    var comtTd = $('.c-cont[data-no=' + commentNo + ']');
                    var comtSpan = comtTd.find('span');
                    comtSpan.html(commentText);
                    comtSpan.css('display', '');
                  }
                } else {
              alert("요청오류 : " + xhr.status);
              }
            }
        };
        var params = "no="+commentNo+"&content="+encodeURIComponent(commentText);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(params);
        });
  
  
//--------------삭제 확인버튼을 눌렀을 시  
$('#comment-remove-btn').click(function(e) {
    var commentNum = $('.remove-btn').attr('data-no');

   var xhr = new XMLHttpRequest();
      xhr.open("GET","deleteComment?no="+commentNum,true);
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
              if (xhr.status == 200) {
                  alert("댓글을 삭제했습니다.");
              } else {
                alert("요청오류 : " + xhr.status);
                }
              }
          };
          xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
          xhr.send();
          console.log("send() 리턴함.");
});

//--------------수정 취소버튼을 눌렀을 시
$('#comment-modify-cancle-btn').click(function(e) {
  $('#comment-modify').css('display', 'none');
  resetBtn();
   var commentNo = commentModifyTa.attr('data-no');
   var comtTd = $('.c-cont[data-no=' + commentNo + ']');
   var comtSpan = comtTd.find('span');
   comtSpan.css('display', '');
  
});
//--------------삭제 취소버튼을 눌렀을 시
$('#comment-remove-cancle-btn').click(function(e) {
  $('#comment-remove').css('display', 'none');
  resetBtn();
  var commentNo = commentModifyTa.attr('data-no');
  var comtTd = $('.c-cont[data-no=' + commentNo + ']');
  var comtSpan = comtTd.find('span');
  comtSpan.css('display', '');
  
});


</script>


</body>
</html>