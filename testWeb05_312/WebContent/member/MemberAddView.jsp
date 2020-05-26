<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원 등록</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">

<style type="text/css">
	* {
		padding: 0px;
		margin: 0px;
	}
	#wrap {
		width: 250px;
		margin: 100px auto;
	}
	#pageTitle {
		margin-bottom: 40px;
		font-size:30px;
		font-family: "Times New Roman", Times, serif;
	}
	#addForm label {
		display: block;
		font-size: 13px;
		padding:15px 0px 3px;
	}
	.inputText {
		width: 100%;
		height: 30px;
		padding: 0px 8px;
		border: none;
		border-bottom: 1px solid #ddd;
		box-sizing: border-box;
		outline: none;
	}
	#btnsWrap {
		margin-top: 30px;
		text-align: center;
		font-size: 0;
	}
	.btns {
		display: inline-block;
		width: 80px;
		line-height: 30px;
		background-color: #000;
		color: #fff;
		font-size: 13px;
		font-weight: bold;
		border: 0;
		cursor: pointer;
	}
	.btns:nth-child(2) {
		margin: 0 5px;
	}
</style>

</head>

<body>
	
	<jsp:include page="/Header.jsp"/>
	
	<div id='wrap'>
		<h1 id='pageTitle'>Add Member</h1>
		
		<form action='add' method='post' id='addForm'>
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
	
	<jsp:include page="/Tail.jsp"/>
	
</body>

</html>