<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty loginUser and loginUser.getRole()==0}">
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #FFADAD;">
  <div class="container-fluid">
    <a class="navbar-brand-main" href="/web/app/main"><img src="/web/images/Petopia.png"></a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/admin/hospital_list">병원 관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/admin/sharing_board_list">나눔장터 관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/admin/mytown_board_list">우리동네</a>
        </li>
          <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/admin/qnalist">Q&A 관리</a>
        </li>
           <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/admin/review_list">리뷰 관리</a>
        </li>
            <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/web/app/admin/member_list">회원 관리</a>
        </li>
      </ul>
        <c:if test="${empty loginUser}">
        <div class="d-flex justify-content-between">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/web/app/login_form">로그인</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/web/app/member/member_form">회원가입</a>
            </li>
          </ul>
        </div>
        </c:if>
        
        <div class="d-flex justify-content-between">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/web/app/logout">로그아웃</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/web/app/pet/list">마이페이지</a>
            </li>
          </ul>
        </div>
     
  </div>
</nav>
   </c:if>