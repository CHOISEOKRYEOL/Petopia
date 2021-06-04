<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script type="text/javascript" src="../../smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="../../css/board.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<title>나눔장터 게시글 상세</title>
<style>
a {
text-decoration:none
} 
</style>
</head>
<body>
<header></header>
<div class="wrap">
<img src="../../images/20180115_1208492.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">나눔장터</p>
    <p style="font-size: 30px;">추억을 나누는 나눔 장터</p>
    <p>사용하지 않는 반려동물 용품을<br>
    버리지 말고 동네 친구들에게 나눠 보세요</p>
  </div>
</div>

<div class="board">
<div class="writingHeadr">
<h2 class="title">게시글 변경</h2>
<c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
  <div class="save-area">
  <input type='button' class="button" id="updatebutton" value='변경'>
  <span class="button"  style="color: #323232; background: #ededed;"><a href='delete?no=${smb.no}' style=" color: #323232;border: 0px;" >삭제</a></span>
  </div>
  </c:if>
</div>
<form id="updatefrm" action='update' method='post' enctype='multipart/form-data'>
<c:if test="${not empty smb}">
<div class="writingContent">
  <div class="writtingArea">
    <div class="boardWritingEditor">
    <div class="row">
      <div class="categorySelectButton">
          <select name='category' style="margin-bottom:10px;" class="form-select form-select-sm" style="font-size: 12px; font-family: 'Noto Sans KR', sans-serif;" aria-label=".form-select-lg example">
						<c:forEach items="${catList}" var="cat">
						 <option value='${cat.no}' ${smb.category.no  == cat.no ? "selected" : ""}>${cat.name}</option>
						</c:forEach>
						</select>
           <div class="input-group">
            <input type='text' name='title' style="width: 888px; margin-bottom:10px;" class="form-control"  value='${smb.title}'>
          </div>
      </div>
    </div>
    <div class="row">
   <div>
  <textarea id="content" name='content' cols="108" rows="15">${smb.content}</textarea>
  </div>
      <div class="input-group">
      <input type="file" multiple="multiple" style="font-size: 14px;
      color: #5c5c5c; font-family: 'Noto Sans KR', sans-serif; width: 888px; margin-top:10px;" name=photo class="form-control" style="width: 888px; margin-top:10px;">
    </div>
    </div>
    </div>
  </div>
</div>
</c:if>
 <input type='hidden' name='no' value='${smb.no}' readonly>
</form>


 
<div class="button2">
<span style="color: #323232; background: #ededed;" ><a href='detail?no=${smb.no}' style=" color: #323232;">뒤로가기</a></span>
</div>
</div>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder: "content",
 sSkinURI: "../../smarteditor/SmartEditor2Skin.html",
 fCreator: "createSEditor2"
});

</script>
<script type="text/javascript">
$("#updatebutton").click(function(){
   oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
    $("#updatefrm").submit();
})
</script>
<footer></footer>
<script>
$(document).ready(function() {
    $("header").load("../../html/header.jsp");
    $("footer").load("../../html/footer.html");
  });
</script>
</body>
</html>

