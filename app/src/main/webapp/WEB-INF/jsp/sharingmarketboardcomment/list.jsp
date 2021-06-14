<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../../css/common.css" rel="stylesheet" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>나눔장터 댓글</title>
<style>
.comment-table{
width: 700px;
margin: 15px auto;
border: 1px solid #cccccc;
padding: 10px;
}
#comment-remove, #comment-modify {
/*display: none;*/
margin: 10px;
}
button {
text-align: center;
border: 1px solid #cccccc;
}
th,tr,td{
padding: 5px;
margin: 15px;
}


.modify-btn, .remove-btn{
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
</style>
</head>
<body>
<c:if test="${not empty comtList}">
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
          
<c:forEach items="${comtList}" var="comt">

<table class ="comment-table" data-no='${comt.no}'>
<tr><td bgcolor="pink">작성자</td><td bgcolor="pink">작성일</td></tr>
<tr>
<td>${comt.writer.name}</td>
<td>${comt.createdDate}</td></tr>
<tr><td id="comment-btn"></td></tr>
<tr>
  <tr><td colspan="2"><c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
    <div id="d2">
        <button type='button' class='modify-btn' data-no='${comt.no}' 
         style="item-align: center; color: #323232; background: #ededed; border: 0px;">수정</button>
        <button type='button' class='remove-btn' data-no='${comt.no}'
         style="item-align: center; color: #323232; background: #ededed; border: 0px;">삭제</button>
    </div>
  </c:if></td></tr>
  
  <tr><td class="c-cont"  data-no="${comt.no}" colspan="2" ><span>${comt.content}</span></td></tr>
</table>
  </c:forEach>
</c:if>
      
<c:if test="${empty comtList}">
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
	 console.log(comtNo);
	var comtTd = $('.c-cont[data-no=' + comtNo + ']');
	var comtSpan = comtTd.find('span');
	comtSpan.css('display', 'none');
	comtTd.append(commentModifyDiv);
	commentModifyTa.val(comtSpan.html());
	commentModifyTa.attr('data-no', comtNo);
	commentModifyDiv.css('display', '');
});

//--------------삭제버튼을 눌렀을 시
var commentRemoveDiv = $('#comment-remove');
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
	 $('#comment-remove-btn').attr('data-no', comtNoRe);
  commentRemoveDiv.css('display', '');
	 
});

//--------------수정 확인버튼을 눌렀을 시
$('#comment-modify-btn').click(function(e) {
	var commentText = commentModifyTa.val();
	var commentNo = commentModifyTa.attr('data-no');
	console.log(commentNo, commentText);
	
	    var xhr = new XMLHttpRequest();
    xhr.open("POST","../sharingmarketboardcomment/update",true);
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
                    comtSpan.css('white-space','pre');
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
	var commentReNo = $('#comment-remove-btn').attr('data-no');
	  console.log(commentReNo);
	  var comtTable = $('.comment-table[data-no=' + commentReNo + ']');
	 
	 var xhr = new XMLHttpRequest();
	    xhr.open("GET","../sharingmarketboardcomment/delete?no="+commentReNo, true);
	      xhr.onreadystatechange = () => {
	          if (xhr.readyState == 4) {
	            if (xhr.status == 200) {
	                alert("댓글을 삭제했습니다.");
	                comtTable.css('display', 'none');
	                commentRemoveDiv.css('display', 'none');
	                resetBtn();
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