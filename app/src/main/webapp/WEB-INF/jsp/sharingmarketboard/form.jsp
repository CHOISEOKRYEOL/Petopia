<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../../css/board.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<script type="text/javascript" src="../../smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>나눔장터 게시판</title>
<style>
footer{
position: relative;
bottom: 0;
width: 100%;
}

a {
text-decoration:none
} 

</style>
</head>
<body>
<header></header>
<div class="wrap">
<img src="../../images/20180115_1208492.jpg" class="img-fluid"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6; min-width:900px;">
  <div class="text-group">
    <p style="font-size: 50px;">나눔장터</p>
    <p style="font-size: 30px;">추억을 나누는 나눔 장터</p>
    <p>사용하지 않는 반려동물 용품을<br>
    버리지 말고 동네 친구들에게 나눠 보세요</p>
  </div>
</div>

<div class="board">
<div class="writingHeadr">
<h2 class="title">게시글 쓰기</h2>
	<div class="save-area">
	 <span><a href='list' class="button" 
    style="color: #323232; background: #ededed; border: 0px;" role="button" >목록</a></span>
	<input class="button" type='button' id='savebutton' value='등록'>
	</div>
</div>
<form action='add' id='frm' method='post' enctype='multipart/form-data'>

<div class="writingContent">
  <div class="writtingArea">
    <div class="boardWritingEditor">
    <div class="row">
      <div class="categorySelectButton">
        <select name='category' style="margin-bottom:10px; color: #5c5c5c;" class="form-select form-select-sm" style="font-size: 12px; font-family: 'Noto Sans KR', sans-serif;" aria-label=".form-select-lg example">
					<c:forEach items="${catList}" var='category'>
					<option value='${category.no}'>${category.name}</option>
					</c:forEach>
					</select>
					 <div class="input-group">
				    <input type="text" name="title" style="width: 888px; margin-bottom:10px;" class="form-control" placeholder="제목을 입력해주세요.">
				  </div>
      </div>
    </div>
    <div class="row">
	 <div>
  <textarea id="content" name="content" cols="108" rows="15"></textarea>
  </div>
      <div class="input-group">
      <input type="file" multiple="multiple" name=photo class="form-control" style="font-size: 14px;
      color: #5c5c5c; font-family: 'Noto Sans KR', sans-serif; width: 888px; margin-top:10px;">
    </div>
    </div>
    </div>
  </div>
</div>
</form>

<div class="foot">
 <span><a href='list' class="btn btn-outline-secondary" 
 style="  border: 0px;
  margin-top: 40px;
  margin-left: 50px;
  margin-bottom: 80px;
  display: inline-block;
  height: 36px;
  border-radius: 6px;
  padding: 0 10px 0 11px;
  line-height: 36px;
  font-weight: 700;
  font-size: 13px;
  color: #323232;
  text-align: center;
  background: #ededed;" role="button" >목록</a></span>
</div>
</div>
<span></span>
 <footer></footer>

 
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
$("#savebutton").click(function(){
	 oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
    $("#frm").submit();
})
</script>
<script>
$(document).ready(function() {
    $("header").load("../../html/header.jsp");
    $("footer").load("../../html/footer.html");
  });
</script>
</body>
</html>
