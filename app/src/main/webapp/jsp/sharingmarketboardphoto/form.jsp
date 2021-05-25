<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>나눔장터 댓글 사진</title>
</head>
<body>
<h1>게시글 사진</h1>
<form action='../sharingmarketboardcomment/add' method='post' enctype="multipart/form-data">
<table border='1'>
<tr><td><input type='hidden' name='no' value='${smboard.no}'> <br></td>
<td><textarea name='content' rows='10' cols='20'></textarea></td>
<td><input type='submit' value='등록'></td></tr>
  </table>
  </form>
</body>
</html>
