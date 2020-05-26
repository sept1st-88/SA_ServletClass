<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">

<script type="text/javascript">
	function pageMoveListFnc() {
		location.href = './list';
	}
	
	function pageMoveDeleteFnc(no) {
		var url = './delete?no=' + no;
		location.href = url;
	}
</script>
</head>

<body>

	<jsp:include page="/Header.jsp" />

	<div id='formWrap'>
		<h1 id='pageTitle'>Update Member</h1>

		<form action='./update' method='post' id='updateForm'>
			<label>번호</label>
			<input type='text' name='no' class='inputText'
				value='${memberDto.no}' readonly='readonly'>
			<label>이름</label>
			<input type='text' name='name' class='inputText' 
				value='${memberDto.name}'>
			<label>이메일</label>
			<input type='text' name='email' class='inputText' 
				value='${memberDto.email}'><br>
			<label>가입일</label>
			<p class='fixedValue'>'${requestScope.memberDto.createDate}'</p>
			<div id='btnsWrap'>
				<input type='submit' value='저장' class='btns'>
				<input type='button' value='삭제' class='btns'
					onclick='pageMoveDeleteFnc(${memberDto.no});'>
				<input type='button' value='취소' class='btns' 
					onclick='pageMoveListFnc();'>
			</div>
		</form>
	</div>

	<jsp:include page="/Tail.jsp" />

</body>
</html>