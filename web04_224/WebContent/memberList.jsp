<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>회원목록</title>
</head>
<body>
	<h1>회원목록</h1>
	<p>
		<a href='./add'>신규 회원</a>
	</p>
	<table>
		<tr>
			<td>1</td>
			<td><a href='./update?mNo=1'>홍길동</a></td>
			<td>s1@test.com</td>
			<td>2020-05-07</td>
			<td><a href='./delete?mNo=1'>삭제</a></td>
		</tr>
	</table>
</body>
</html>
