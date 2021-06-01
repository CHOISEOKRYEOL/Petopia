<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.sido == '1'}">
  <option value="1">종로구</option>
  <option value="2">중구</option>
  <option value="3">용산구</option>
  <option value="4">성동구</option>
  <option value="5">광진구</option>
  <option value="6">동대문구</option>
  <option value="7">중랑구</option>
  <option value="8">성북구</option>
  <option value="9">강북구</option>
  <option value="10">도봉구</option>
  <option value="11">노원구</option>
  <option value="12">은평구</option>
  <option value="13">서대문구</option>
  <option value="14">마포구</option>
  <option value="15">양천구</option>
  <option value="16">강서구</option>
  <option value="17">구로구</option>
  <option value="18">금천구</option>
  <option value="19">영등포구</option>
  <option value="20">동작구</option>
  <option value="21">관악구</option>
  <option value="22">서초구</option>
  <option value="23">강남구</option>
  <option value="24">송파구</option>
  <option value="25">강동구</option>
</c:if>

<c:if test="${param.sido == '102'}">
  <option value="">해운대</option>
  <option value="">해운대2</option>
  <option value="">해운대3</option>
  <option value="">해운대4</option>
</c:if>
