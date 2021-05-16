<%@page import="com.pms.petopia.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>내 계정 관리</title>
</head>
<body>
<%
Member m = (Member) request.getAttribute("member");
%>
<form action='update' method='post'>
<table border='1'>
<tbody>
<tr><th>이름</th>
     <td><input name='name' value=<%=m.getName() %> readonly></td></tr>
<tr><th>아이디</th>
     <td><input name='id' value=<%=m.getId() %> readonly></td></tr>
<tr><th>이메일</th>
     <td><input name='email' value=<%=m.getEmail() %> readonly></td></tr>
<tr><th>닉네임</th>
     <td><input name='nick' type='text' value=<%=m.getNick() %>></td></tr>
<tr><th>비밀번호</th>
     <td><input name='password' type='password'></td></tr>
<tr><th>비밀번호 확인</th>
     <td><input name='checkPassword' type='password'></td></tr>
<tr><th>휴대전화</th>
     <td><input name='tel' type='tel' value=<%=m.getTel() %>></td></tr><br>
</tbody>
</table>
<input type='submit' value='수정' >
</form>
<form action='delete' method='post'>
<input type='hidden' name='no' value=<%=m.getNo() %>>
<input type='submit' name='delete' value='회원탈퇴'>
</form>

<p><a href='../main'>메인 화면</a></p>
</body>
</html>