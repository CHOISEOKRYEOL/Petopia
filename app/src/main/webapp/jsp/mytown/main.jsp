<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>우리동네</title>
</head>
<body>
<h1>우리동네 찾기</h1>
<form action='list' method='get'>
    광역시/도 : <select name='stateNo'>
      <c:forEach items="${smallAddresses}" var="s">
        <option value='${s.bigAddress.no}' ${s.bigAddress.no == smallAddress.bigAddress.no ? "selected" : ""}>${s.bigAddress.name}</option>
      </c:forEach>
    </select> 시/군/구 : <select name='cityNo'>
      <c:forEach items="${smallAddresses}" var="s">
        <option value='${s.no}' ${s.no == smallAddress.no ? "selected" : ""}>${s.name}</option>
      </c:forEach>
    </select> <input type='submit' value='찾기'>
  </form>
</body>
</html>