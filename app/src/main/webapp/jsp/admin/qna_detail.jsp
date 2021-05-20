<%@page import="com.pms.petopia.domain.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Q&A 답변</title>
</head>
<body>

<form action='answer' method='post'>
<table border = '1'>
<tbody>
<tr><th>질문</th><td><textarea rows='10' cols='60' readonly>${qna.content}
<c:if test="${not empty qna.answer}">



■ 관리자 답변 ■

${qna.answer}</c:if></textarea></td></tr><br>
<tr><th>답변</th><td><textarea = name='answer' rows='10' cols='60'></textarea></td>
</tr>
</tbody>
</table>
<input type='hidden' name='no' value='${qna.no}'>
<input type='submit' value='수정'>
</form>
<p><a href='qnalist'>목록</a>
</body>
</html>