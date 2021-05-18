<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>새 스토리</title>
</head>
<body>
<h1>새 스토리</h1>
<form action='add' method='post'>
<table border='1'>
  <tbody>
		<tr><th>제목</th> <td><input type='text' name='title'></td></tr>
		<tr><th>URL</th> <td><input type='url' name='url'></td></tr>
		<tr><th>사이트</th> <td><input type='text' name='site'></td></tr>
  </tbody>
  <tfoot>
    <tr><td colspan='2'>
      <input type='submit' value='등록'></td>
    </tr>
  </tfoot>
</table>
</form>
<form action='list'>
<input type='submit' value='취소'>
</form>
</body>
</html>
