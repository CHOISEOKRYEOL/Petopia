<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>나눔장터 댓글</title>
<style>
.comment-table{
width: 700px;
margin: 0 auto;
border: 1px solid #cccccc;
}
#comment-remove, #comment-modify {
display: none;
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
<c:if test="${not empty comtList}">
<c:forEach items="${comtList}" var="comt">
<table class ="comment-table">
<tr><td bgcolor="pink">작성자</td><td bgcolor="pink">작성일</td></tr>
<tr>
<td>${comt.writer.name}</td>
<td>${comt.createdDate}</td></tr>
<tr><td id="comment-btn"></td></tr>
<tr>
  <tr><td colspan="2"><c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
    <div id="d2">
        <button type="button" class='modify-btn' data-no='${comt.no}' >수정</button>
        <button type="button" class="remove-btn" data-no="${comt.no}">삭제</button>
    </div>
  </c:if></td></tr>
  
<tr id="c-tr"><td class="c-cont"  data-no="${comt.no}" colspan="2">${comt.content}</td></tr>
</table>
  </c:forEach>
</c:if>


      
<c:if test="${empty comtList}">
  <p>댓글이 없습니다.</p>
</c:if>

<c:if test="${not empty comtList}">
<c:forEach items="${comtList}" var="comt">
        <c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
          <div id="comment-modify">
                <textarea id="modify-content" rows="3" cols="50">${comt.content}</textarea>
                <button type="button" class="modify-detail-btn" onclick='modifyComment(${comt.no});'>수정 확인</button>
               <button type="button" id="modify-cancle-btn">수정 취소</button>
          </div>
            
      <div id="comment-remove">
          <div id="remove-message">
          <b>정말 삭제하시겠습니까?</b>
              <button type="button" class="remove-detail-btn" onclick='deleteComment(${comt.no});'>삭제 완료</button>
              <button type="button" id="remove-cancle-btn">삭제 취소</button>
            </div>
          </div>
       </c:if>
       </c:forEach>
       </c:if> 

<script>	
"use strict"

function initModify(){
	$("#modify-content").val("");
};

	var el =document.querySelectorAll(".modify-btn");
	
	var btnClick = (e) => {
	  console.log(e.target.getAttribute("data-no"));
	  var no = e.target.getAttribute("data-no");
	  console.log(e.target);
	  console.log(no);
	 /*  console.log($(".modify-btn").data("no")); */
/* 	  console.log($(".modify-btn")[no].getAttribute("data-no")); */
	};
	for(var e of el){
	  e.addEventListener("click",btnClick);
	}
	
 	$(".modify-btn").click(function() {
		   //console.log(this);
		   console.log(this.parentElement);
		   $(this.parentElement).find('.modify-btn').hide();
		   $(this.parentElement).find('.remove-btn').hide(); 
		   $("#comment-modify").show().appendTo("#c-tr");
		   $(".c-cont").hide();
		  }); 
	
function modifyComment(no){
    console.log(no);
    var content = $("#modify-content").val();
    console.log(content);
    
    var xhr = new XMLHttpRequest();
    xhr.open("POST","../sharingmarketboardcomment/update",true);
      xhr.onreadystatechange = () => {
          if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                if(xhr.responseText =="empty"){
                    alert("변경할 댓글내용을 입력해주세요.");
                     $("#modify-content").focus();
                     return;
                  }else if(xhr.responseText =="working"){
                      console.log(content);
                      $("#comment-modify").hide();
                      $("#d2").find('.modify-btn').data("no").show();
                      $("#d2").find('.remove-btn').data("no").show(); 
                    alert("댓글을 변경완료 했습니다.");
                  }
                } else {
              alert("요청오류 : " + xhr.status);
              }
            }
        };
        var params = "no="+no+"&content="+encodeURIComponent(content);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(params);

   
};

/* $(".remove-btn").data("no").click(function() {
	   $(this.parentElement).find('.modify-btn').data("no").hide();
	   $(this.parentElement).find('.remove-btn').data("no").hide(); 
	   $("#comment-remove").show().appendTo("#c-tr");
}); */


function deleteComment(no){
    console.log(no);
    var xhr = new XMLHttpRequest();
    xhr.open("GET","../sharingmarketboardcomment/delete?no="+no,true);
      xhr.onreadystatechange = () => {
          if (xhr.readyState == 4) {
            if (xhr.status == 200) {
            	if(xhr.responseText=="working"){
            		alert("댓글을 삭제했습니다.");
            		 $("#comment-remove").hide();
            		 $()
            	}
            } else {
              alert("요청오류 : " + xhr.status);
              }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send();
        console.log("send() 리턴함.");
};

</script>
</body>
</html>