<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test = '${param.species == 1}'>
  <option value = "1">진돗개</option>
  <option value = "2">시바</option>
  <option value = "3">저먼 셰퍼드</option>
  <option value = "4">래브라도 리트리버</option>
  <option value = "5">시베리안 허스키</option>
  <option value = "6">포메라니안</option>
  <option value = "7">불도그</option>
  <option value = "8">푸들</option>
  <option value = "9">로트바일러</option>
  <option value = "10">치와와</option>
  </c:if>
  
  <c:if test = '${param.species == 2}'>
  <option value = "11">페르시안</option>
  <option value = "12">벵골</option>
  <option value = "13">메인쿤</option>
  <option value = "14">시암</option>
  <option value = "15">브리티시 쇼트헤어</option>
  <option value = "16">스핑크스</option>
  <option value = "17">래그돌</option>
  <option value = "18">먼치킨</option>
  <option value = "19">노르웨이 숲</option>
  <option value = "20">러시안 블루</option>
  </c:if>
  
    <c:if test = '${param.species == 3}'>
  <option value = "21">햄스터</option>
  <option value = "22">새</option>
  <option value = "23">거위</option>
  <option value = "24">벌</option>
  <option value = "25">거북이</option>
  <option value = "26">도마뱀</option>
  <option value = "27">뱀</option>
  <option value = "28">악어</option>
  <option value = "29">토끼</option>
  <option value = "30">고슴도치</option>
  </c:if>