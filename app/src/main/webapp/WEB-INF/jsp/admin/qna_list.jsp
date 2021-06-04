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
<title>관리자 Q&A 목록</title>
<style type="text/css">

boady{
width: 1000px;
margin: 0 auto;
font-family: 'Noto Sans KR', sans-serif;
font-size: medium;
vertical-align: middel;
display: center;
}

.table{
width: 700px;
margin: 0 auto;
border: 1px solid #cccccc;
 font-weight: 500;
  font-size: 16px;
  text-align: center;
}

.search{
display: block;
min-width: 1000px;
margin: 0 auto;
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

.content{
display: block;
min-width: 1000px;
  height: 680;
  padding: 30px 30px 30px 30px;
}

footer{
position: relative;
bottom: 0;
width: 100%;
}

a{
text-decoration:none
}

td{
  margin-top: 10px;
  height: 36px;
  margin-right: 4px;
  line-height: 36px;
  padding: 0 10px 0 11px;
}

</style>
</head>
<body>

<header></header>

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="display: block;"> 
<a class="navbar-brand">관리자 Q&A 목록</a>
</nav>

	<div class="content">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>상태</th>
				<th>처리1</th>
				<th>처리2</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="q">
				<tr>
					<td>${q.no}</td>
					<td><a href='../qna/detail?no=${q.no}'>${q.title}</a></td>
					<td>${q.writer.nick}</td>
					<td>${q.createdDate}</td>
					<c:if test="${q.state == 1}">
						<td>완료</td>
					</c:if>
					<c:if test="${q.state == 0}">
						<td>대기</td>
					</c:if>
					<td>
					<div class="button" style="color: rgb(252, 116, 116); background: rgba(255, 173, 173, 0.30);">
              <span>
              <a href='qna_detail?no=${q.no}'>답변</a>
              </span>
              </div>
           </td>
					<td>
					    <div class="button" style="color: rgb(252, 116, 116); background: rgba(255, 173, 173, 0.30);">
              <span>
              <a href='../qna/delete?no=${q.no}'>삭제</a>
               </span>
              </div>
              </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
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