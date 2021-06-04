<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style>
.star-input>.input,
.star-input>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('../../images/grade1_img.png')no-repeat;}
.star-input{display:inline-block; white-space:nowrap;width:160px;height:40px;padding:25px;line-height:30px;}
.star-input>.input{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}

.second-star-input>.input2,
.second-star-input>.input2>input:checked+label{display: inline-block;vertical-align:middle;background:url('../../images/grade2_img.png')no-repeat;}
.second-star-input{display:inline-block; white-space:nowrap;width:160px;height:40px;padding:25px;line-height:30px;}
.second-star-input>.input2{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}

.thrid-star-input>.input3,
.thrid-star-input>.input3>input:checked+label{display: inline-block;vertical-align:middle;background:url('../../images/grade3_img.png')no-repeat;}
.thrid-star-input{display:inline-block; white-space:nowrap;width:160px;height:40px;padding:25px;line-height:30px;}
.thrid-star-input>.input3{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}

.forth-star-input>.input4,
.forth-star-input>.input4>input:checked+label{display: inline-block;vertical-align:middle;background:url('../../images/grade4_img.png')no-repeat;}
.forth-star-input{display:inline-block; white-space:nowrap;width:160px;height:40px;padding:25px;line-height:30px;}
.forth-star-input>.input4{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}

.fifth-star-input>.input5,
.fifth-star-input>.input5>input:checked+label{display: inline-block;vertical-align:middle;background:url('../../images/grade5_img.png')no-repeat;}
.fifth-star-input{display:inline-block; white-space:nowrap;width:160px;height:40px;padding:25px;line-height:30px;}
.fifth-star-input>.input5{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}


</style>

</head>

<body>
<div class="reviewmain" style=" margin-top: 10px;">
<c:forEach items="${list}" var="r">
<div class="reviewlist" style="border: 2px solid #FFADAD;">
	<c:set var="photoUrl">../../upload/${r.photo}</c:set>
	<c:set var="thumbnail">../../upload/${r.photo}_100x100.jpg</c:set>
	<c:if test="${r.hospital.no == hospital.no}">
		<table class="table table-hover" style="text-align: center;">
			<thead>
				<tr>
					<th>서비스</th>
					<th>청결도</th>
					<th>비용</th>
					<th>사진</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				
					<td>
					<c:if test="${r.serviceRating == 1}">
					<span class="star-input">
					 <span class="input">
					</span>
					</span>
					</c:if>
					
					   <c:if test="${r.serviceRating == 2}">
          <span class="second-star-input">
           <span class="input2">
          </span>
          </span>
          </c:if>
					
					   <c:if test="${r.serviceRating == 3}">
          <span class="thrid-star-input">
           <span class="input3">
          </span>
          </span>
          </c:if>
					
					   <c:if test="${r.serviceRating == 4}">
          <span class="forth-star-input">
           <span class="input4">
          </span>
          </span>
          </c:if>
					
					   <c:if test="${r.serviceRating == 5}">
          <span class="fifth-star-input">
           <span class="input5">
          </span>
          </span>
          </c:if>
					
					</td>
					
					<td>
          <c:if test="${r.cleanlinessRating == 1}">
          <span class="star-input">
           <span class="input">
          </span>
          </span>
          </c:if>
          
             <c:if test="${r.cleanlinessRating == 2}">
          <span class="second-star-input">
           <span class="input2">
          </span>
          </span>
          </c:if>
          
             <c:if test="${r.cleanlinessRating == 3}">
          <span class="thrid-star-input">
           <span class="input3">
          </span>
          </span>
          </c:if>
          
             <c:if test="${r.cleanlinessRating == 4}">
          <span class="forth-star-input">
           <span class="input4">
          </span>
          </span>
          </c:if>
          
             <c:if test="${r.cleanlinessRating == 5}">
          <span class="fifth-star-input">
           <span class="input5">
          </span>
          </span>
          </c:if>
          
					</td>

					<td>
					     <c:if test="${r.costRating == 1}">
          <span class="star-input">
           <span class="input">
          </span>
          </span>
          </c:if>
          
             <c:if test="${r.costRating == 2}">
          <span class="second-star-input">
           <span class="input2">
          </span>
          </span>
          </c:if>
          
             <c:if test="${r.costRating == 3}">
          <span class="thrid-star-input">
           <span class="input3">
          </span>
          </span>
          </c:if>
          
             <c:if test="${r.costRating == 4}">
          <span class="forth-star-input">
           <span class="input4">
          </span>
          </span>
          </c:if>
          
             <c:if test="${r.costRating == 5}">
          <span class="fifth-star-input">
           <span class="input5">
          </span>
          </span>
          </c:if>
					</td>
					
					<td><a href='${photoUrl}' target="_blank"><img src='${thumbnail}'></a></td> 
					
					</tr>
					
					<thead>
					<tr>
					   <th>작성자</th>
          <th>내용</th>
          <th>등록일</th>
          
          <c:if test="${loginUser.no == r.writer.no}">
          <th>권한</th>
          </c:if>
					</tr>
					</thead>
					
					<tr>
					<td>${r.writer.nick}</td>
					<td>${r.comment}</td>
					<td>${r.createdDate}</td>
					
					<c:if test="${r.writer.no == loginUser.no}">
					<td>
					<form action="../review/delete">
					<input type="hidden" name="hno" value="${r.hospital.no}">
					<input type="hidden" name="no" value="${r.no}">
					<input type="submit" value="삭제">
					</form>
					</td>
					</c:if>
				</tr>
			</tbody>
		</table>
	</c:if>
	<br>
</div>
</c:forEach>
</div>

</body>
</html>
