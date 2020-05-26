<%@page import="java.util.Date"%>
<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원 정보 수정</title>

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
	#updateForm label {
		display: block;
		font-size: 13px;
		padding:15px 0px 3px;
	}
	.inputText, .fixedValue {
		width: 100%;
		height: 30px;
		padding: 0px 8px;
		border-bottom: 1px solid #ddd;
		box-sizing: border-box;
		font-size: 13px;
	}
	.inputText {
		border: none;
		border-bottom: 1px solid #ddd;
		outline: none;
	}
	.fixedValue {
		line-height: 30px;
		font-weight: bold;
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
		<h1 id='pageTitle'>Update Member</h1>
		
		<form action='update' method='post' id='updateForm'>
			<label>번호</label>
			<input type='text' name='no' value='${memberDto.no}' class='inputText' readonly='readonly'>
			<label>이름</label>
			<input type='text' name='name' value='${memberDto.name}' class='inputText'>
			<label>이메일</label>
			<input type='text' name='email' value='${memberDto.email}' class='inputText'>
			<label>가입일</label>
			<p class='fixedValue'>${requestScope.memberDto.createDate}</p>
			<div id='btnsWrap'>
				<input type='submit' value='저장' class='btns'>
				<input type='button' onclick="pageMoveDeleteFnc(${memberDto.no});" 
					value='삭제' class='btns'>
				<input type='reset' value='취소' class='btns' onclick="pageMoveListFnc();">
			</div>
		</form>
	</div>
	
	<jsp:include page="/Tail.jsp"/>
	
</body>

</html>