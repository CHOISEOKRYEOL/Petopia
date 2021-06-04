<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>병원 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/web/css/common.css">
<link rel="stylesheet" type="text/css" href="/web/css/layout.css">
</head>
<body>
<header></header>
<div class="wrap">
<img src="/web/images/bigstock.jpg" class="img-fluid width:100%;"
style="filter:alpha(opacity=60); opacity:0.6; -moz-opacity:0.6;">
  <div class="text-group">
    <p style="font-size: 50px;">펫토피아</p>
    <p style="font-size: 30px;">집에서 가까운 병원 찾기</p>
    <p>직접 동네 병원을 검색할 필요 없이<br>
    내 집에서 가장 가까운 병원을, 상세 리뷰와 함께 보여드립니다</p>
  </div>
</div>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<a class="navbar-brand">병원 찾기</a>
  <div class="container-fluid">
  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
  <c:if test="${loginUser.role == 0}">
    <li class="nav-item">
      <a href='form' class="btn" style="background-color: #FFADAD;">새 글</a>
    </li>
    </c:if>
  </ul>
  <jsp:include page="../../../html/state4.jsp"/>
  </div>
</nav>

<jsp:include page="map.jsp"/>

<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>전화 번호</th> <th>기본주소</th> <th>상세주소</th> <th>진료시간</th> <th>평점</th>
<c:if test="${not empty loginUser}">
          <th>즐겨찾기</th>
        </c:if>
</tr>
</thead>
<tbody>
			<c:forEach items="${hospitals}" var="h">
				<tr>
					<td>${h.no}</td>
					<td><a href='detail?no=${h.no}'>${h.name}</a></td>
					<td>${h.tel}</td>
					<td>${h.bigAddress.name}&nbsp;${h.smallAddress.name}</td>
					<td>${h.address}</td>
					<td>${h.startTime}시~${h.endTime}시</td>
					<td>
					<c:if test="${h.rating == 0}">
					0점
					</c:if>
					<c:if test="${h.rating > 0 }">
					<fmt:formatNumber value="${h.rating}" pattern=".0" />점
					</c:if>
					</td>

					<c:if test="${not empty loginUser}">
						<c:set var="loop" value="false" />
						<c:forEach items="${book}" var="b">
							<c:if test="${not loop}">
								<c:if
									test="${b.member.no == loginUser.no and b.hospital.no == h.no}">
									<td>
									<form action="../bookmark/delete">
									     <input type="hidden" name="no" value="${b.no}"> 
									     <input type="hidden" name="hno" value="-1"> 
                        <input type="submit" value="★">
									</form>
									</td>
									<c:set var="loop" value="true" />
								</c:if>
							</c:if>
						</c:forEach>
						<c:if test="${not loop}">
							<td>
							<form action="../bookmark/add" method="POST">
							     <input type="hidden" name="mno" value="${loginUser.no}">
                  <input type="hidden" name="hno" value="${h.no}"> 
                  <input type="hidden" name="hiddenNo" value="1">
									<input type="submit" value="☆">
									</form>
							</td>
						</c:if>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<footer id="footer"></footer>

<script>
$(document).ready(function() {
    $("header").load("/web/html/header.jsp");
    $("footer").load("/web/html/footer.html");
  });
</script>
</body>
</html>
