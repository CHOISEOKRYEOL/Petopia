<%@page import="com.pms.petopia.domain.Member"%>
<%@page import="com.pms.petopia.domain.MyTownBoard"%>
<%@page import="com.pms.petopia.domain.SmallAddress"%>
<%@page import="java.util.List"%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script type="text/javascript" src="../../smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<meta charset='UTF-8'>
<title>게시글 변경</title>
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
<a class="navbar-brand" style=margin-right:50%>${oldBoard.bigAddress.name}&nbsp;${oldBoard.smallAddress.name}</a>
</nav>
<h2>게시글 변경</h2>
<form action='update' method='post' id='frm'>
<table border='1'>
<tbody>
<tr><th>광역시/도</th> 
<td><select name ='stateNo'>
<c:forEach items="${smallAddresses}" var="s">
<option value='${s.bigAddress.no}' ${s.bigAddress.no == bigAddress.no ? "selected" : ""}>${s.bigAddress.name}</option>
</c:forEach>
</select></td>
<tr><th>시/군/구</th> 
<td><select name='cityNo'>
<c:forEach items="${smallAddresses}" var="s">
<option value='${s.no}' ${s.no == smallAddress.no ? "selected" : ""}>${s.name}</option>
</c:forEach>
</select></td></tr>
 
<tr><th>번호</th> <td><input type='text' name='no' value='${oldBoard.no}'readonly></td></tr>
<tr><th>제목</th> <td><input name='title' type='text' value='${oldBoard.title}'></td></tr>
<tr><th>내용</th> <td><textarea id='content' name='content' rows='10'>${oldBoard.content}</textarea></td></tr>
<tr><th>작성자</th> <td>${oldBoard.writer.nick}</td></tr>
<tr><th>등록일</th> <td>${oldBoard.createdDate}</td></tr>
<tr><th>조회수</th> <td>${oldBoard.viewCount}</td></tr>

<c:if test="${not empty loginUser and oldBoard.writer.no == loginUser.no}">
<tr>
  <td colspan='2'>
    <input type='button' id='updatebutton' value='변경'>
    <!--<a href='delete?no=${myTownBoard.no}'>삭제</a>-->
  </td>
</tr>
</c:if>
</tbody>
</table>
</form>
<a href='list?stateNo=${bigAddress.no}&cityNo=${smallAddress.no}'>목록</a>
<br>
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
