<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>홈</title>
</head>
<body>
	<c:if test="${empty loginUser}">
		<h1>비회원</h1>
		<p>
			<a href='member/add'>가입</a>
		</p>
		<p>
			<a href='login'>로그인</a>
		</p>
		<p>
			<a href='hospital/list'>병원 찾기</a>
		</p>
		<p>
			<a href='story/list'>스토리</a>
		</p>
		<p>
			<a href='sharingmarketboard/list'>나눔 장터</a>
		</p>
		<p>
			<a href='mytown/main'>우리 동네</a>
		</p>
		<p>
			<a href='qna/list'>Q&A 목록</a>
		</p>
	</c:if>
	<c:if test="${not empty loginUser and loginUser.id eq 'admin'}">
		<h1>관리자</h1>
		<p>
		  <form action='logout' method='post'>
      <input name='logout' type='submit' value='로그아웃'>
    </form>
		</p>
		<p>
			<a href='admin/memberlist'>ADMIN 회원 리스트</a>
		</p>
		<p>
		  <a href='admin/hospitallist'>ADMIN 병원 리스트</a>
		</p>
		<p>
			<a href='admin/reviewlist'>ADMIN 리뷰 리스트</a>
		</p>
		<p>
			<a href='admin/qnalist'>ADMIN Q&A 리스트</a>
		</p>
		<p>
			<a href='admin/boardlist'>ADMIN 게시판 리스트</a>
		</p>
	</c:if>
	<c:if test="${not empty loginUser and loginUser.id ne 'admin'}">
		<h1>회원</h1>
		<p>
		<form action='member/detail' method='get'>
			</p>
			<input name='detail' type='submit' value='내 계정 관리'>
		</form>
		<p>
		<form action='logout' method='post'>
			</p>
			<input name='logout' type='submit' value='로그아웃'>
		</form>
		<p>
		</p>
		<p>
			<a href='pet/add'>마이펫 등록</a>
		</p>
		<p>
			<a href='pet/list'>마이펫 리스트</a>
		</p>
		<p>
			<a href='hospital/add'>병원 등록</a>
		</p>
		<p>
			<a href='hospital/list'>병원 목록</a>
		</p>
		<p>
			<a href='record/add'>진찰기록 등록</a>
		</p>
		<p>
			<a href='story/add'>스토리 추가</a>
		</p>
		<p>
			<a href='story/list'>스토리 목록</a>
		</p>
		<p>
			<a href='sharingmarketboard/list'>나눔 장터 목록</a>
		</p>
		<p>
			<a href='mytown/main'>우리 동네 목록</a>
		</p>
		<p>
			<a href='qna/add'>Q&A 작성</a>
		</p>
		<p>
			<a href='qna/list'>Q&A 목록</a>
		</p>
		<p>
		  <a href='member/bookmarklist'>병원 즐겨찾기</a>
		</p>
		<p>
		  <a href='mypage/main'>My Page</a>
		</p>
	</c:if>
</body>
</html>

<%-- 
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body>
<header id="header"></header>
<div class="wrap">
<img src="../images/Screenshot_2017-01-05-23-08-49.png" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">우리 아이들의 이야기</p>
    <p>동네 커뮤니티로 정보를 나누고, 수다 떨며,<br>
    같이 산책할 내 반려동물의 친구를 사귀어 보세요.</p> 
  </div>
</div>

<div class="container">
</div>

<footer id="footer"></footer>
</body>
</html>
--%>