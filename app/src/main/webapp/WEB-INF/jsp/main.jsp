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
			<a href='member/member_form'>가입</a>
		</p>
		<p>
			<a href='login_form'>로그인</a>
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
			<a href='pet/form'>마이펫 등록</a>
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
			<a href='qna/qna_form'>Q&A 작성</a>
		</p>
		<p>
			<a href='qna/list'>Q&A 목록</a>
		</p>
		<p>
		  <a href='bookmark/list'>병원 즐겨찾기</a>
		</p>
		<p>
		  <a href='mypage/main'>My Page</a>
		</p>
	</c:if>
</body>
</html>
