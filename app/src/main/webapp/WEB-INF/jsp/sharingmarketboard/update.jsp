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
<link rel="stylesheet" type="text/css" href="../../css/common.css">
<link rel="stylesheet" type="text/css" href="../../css/layout.css">
<title>나눔장터 게시글 상세</title>
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

<h1>나눔장터 게시글 변경</h1>
<c:if test="${not empty smb}">
<form id="updatefrm" action='update' method='post' enctype='multipart/form-data'>
<table border='1'>
<tbody>
<tr><th>번호</th> <td><input type='text' name='no' value='${smb.no}' readonly></td></tr>
<select name='category'>
<c:forEach items="${catList}" var="cat">
 <option value='${cat.no}' ${smb.category.no  == cat.no ? "selected" : ""}>${cat.name}</option>
</c:forEach>
</select>
<tr><th>제목</th> <td><input type='text' name='title'  value='${smb.title}'></td></tr><br>
<tr><th>내용</th> <td><textarea id="content" name='content' rows='10' cols='60'>${smb.content}</textarea></td></tr>
<tr><th>작성자</th> <td>${smb.writer.name}</td></tr>
<tr><th>작성일</th> <td>${smb.createdDate}</td></tr>
<tr><th>조회수</th> <td>${smb.viewCount}</td></tr>
<tr><th>사진</th> <td><input type="file" multiple="multiple" name=photo></td></tr>
</tbody>

<c:if test="${not empty loginUser and loginUser.no == smb.writer.no}">
	<tfoot>
	<tr>
	  <td colspan='2'>
	    <input type='button' id="updatebutton" value='변경'><a href='delete?no=${smb.no}'>삭제</a>
	  </td>
	</tr>
	</tfoot>    
  </c:if>
  
</table>
</form>
</c:if>
<p><a href='detail?no=${smb.no}'>뒤로가기</a></p>

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

