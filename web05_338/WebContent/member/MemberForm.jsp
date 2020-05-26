<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원등록</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">

</head>

<body>
	<jsp:include page="/Header.jsp" />

	<div id='formWrap'>										
		<h1 id='pageTitle'>Add Member</h1>
		<form action='add' method='post' id='commonForm'>				
			<label>이름</label>
			<input type='text' name='name' class='inputText'>	
			<label>이메일</label>
			<input type='text' name='email' class='inputText'>
			<label>암호</label>
			<input type='password' name='password' class='inputText'>
			<div id='btnsWrap'>
				<input type='submit' value='추가' class='btns'>
				<input type='button' onclick="location.href='./list'" value='뒤로' class='btns'>
				<input type='reset' value='취소' class='btns'>
			</div>
		</form>
	</div>

	<jsp:include page="/Tail.jsp" />
							
</body>

</html>