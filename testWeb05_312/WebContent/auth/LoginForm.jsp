<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>로그인 페이지</title>

<style type="text/css">
	* {
		padding: 0px;
		margin: 0px;
	}
	#wrap {
		width: 250px;
		margin: 100px auto 0px;
	}
	#pageTitle {
		margin-bottom: 40px;
		font-size:30px;
		font-family: "Times New Roman", Times, serif;
	}
	#loginForm label {
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
	#loginBtn {
		display: block;
		width: 100%;
		line-height: 35px;
		margin-top: 35px;
		border: 1px solid #000;
		box-sizing: border-box;
		background-color: #000;
		font-size: 13px;
		font-weight: bold;
		color: #fff;
		cursor: pointer;
		transition: all 0.3s;
	}
	
	#btnWrap:hover #loginBtn {
		animation: hoverAni 1s;
	}
	@keyframes hoverAni {
		0% {
			background-color: #000;
			color: #fff;
		}
		20% {
			background-color: #fff;
			color: #000;
		}
	}
</style>

</head>

<body>
	
	<div id='wrap'>
		<h2 id='pageTitle'>Login</h2>
		
		<form action="./login" method="post" id='loginForm'>
			<label>이메일</label>
			<input type="text" class='inputText' name="email">
			<label>암호</label>
			<input type="password" class='inputText' name="password">
			<div id='btnWrap'>
				<span id='btnAni'></span>
				<input type="submit" id='loginBtn' value="로그인">
			</div>
		</form>
	</div>
	
</body>

</html>