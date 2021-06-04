<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script type="text/javascript" src="../../smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/web/css/layout.css">
<link rel="stylesheet" type="text/css" href="/web/css/board.css">
<meta charset='UTF-8'>
<title>우리동네 새 게시글</title>
</head>
<body>
<header></header>
<div class="wrap">
<img src="/web/images/mytown.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">우리동네</p>
    <p style="font-size: 30px;">우리동네 친구찾기</p>
    <p>동네 커뮤니티로 정보를 나누고 수다 떨며<br>
    같이 산책할 내 반려동물의 친구 사귀어 보세요.</p>
  </div>
</div>
<div class="board">
<div class="writingHeadr">
<h2 class="title">우리동네 게시글 쓰기</h2>
  <div class="save-area">
  <input class="button" type='button' id='savebutton' value='등록'>
  </div>
</div>

<form id='frm' action='add' method='post'>
<div class="writingContent">
  <div class="writtingArea">
    <div class="boardWritingEditor">
    <div class="row">
      <div class="categorySelectButton">
        <select name ='stateNo' style="margin-bottom:10px; color: #5c5c5c;" class="form-select form-select-sm" style="font-size: 12px; font-family: 'Noto Sans KR', sans-serif;">
        <c:forEach items="${smallAddresses}" var="s">
        <option value='${s.bigAddress.no}' ${s.bigAddress.no == smallAddress.bigAddress.no ?  "selected" : ""}>${s.bigAddress.name}</option>
        </c:forEach>
        </select>
        <select name='cityNo' style="margin-bottom:10px; color: #5c5c5c;" class="form-select form-select-sm" style="font-size: 12px; font-family: 'Noto Sans KR', sans-serif;">
        <c:forEach items="${smallAddresses}" var="s">
        <option value='${s.no}' ${s.no == smallAddress.no ?  "selected" : ""}>${s.name}</option>
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
    </div>
    </div>
  </div>
</div>
</form>

<div class="foot">
 <span><a href='list?stateNo=${smallAddress.bigAddress.no} &cityNo=${smallAddress.no}' class="btn btn-outline-secondary" 
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
	 var content = $('#content');
	 console.log(content);
   oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
    $("#frm").submit();
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