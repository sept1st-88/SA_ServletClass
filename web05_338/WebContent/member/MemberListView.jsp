<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원목록</title>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<style type="text/css">
#wrap {
	width: 500px
}

#addLink {
	border: 1px solid #000;
	padding: 3px 10px; 
	font-weight: bold;
	font-size: 12px;
	transition: all 0.3s;
}
#addLink:hover {
	background-color: #000;
	color: #fff;
}

#table {
/* 	table-layout: fixed; */
/* 	width: 100%; */
	margin-top: 20px;
	border-collapse: collapse;
	font-size: 12px;
}
#table th, #table td {
	border: 1px solid #000;
	padding: 5px 10px;
}
#table th {
	background-color: #000;
	border-right-color: #fff;
	border-left-color: #fff;
	color: #fff;
}
#table th:first-child {
	border-left-color: #000;
}
#table th:last-child {
	border-right-color: #000;
}
.manageBtn {
	display: inline-block;
	position: relative;
}
.manageBtn:hover {
	font-weight: bold;
}
</style>

</head>

<body>

	<jsp:include page="/Header.jsp"/>
	
	<div id='wrap'>

		<h1 id='pageTitle'>회원목록</h1>
		
		<p>
			<a href='add' id='addLink'>
				신규 회원 등록
			</a>
		</p>
		
		<table id='table'>
			<colgroup>
				<col width="80px">
				<col width="80px">
				<col width="150px">
				<col width="100px">
				<col width="90px">
			</colgroup>
			<thead>
				<tr>
					<th>회원번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>가입날짜</th>
					<th>관리</th>
				</tr>
			</thead>
			<tbody>
				
<%-- 				<jsp:useBean id="memberList" --%>
<%-- 					scope="request" --%>
<%-- 					class="java.util.ArrayList" --%>
<%-- 					type="java.util.ArrayList<spms.dto.MemberDto>" --%>
<%-- 				/> --%>
				
<%-- 				<jsp:useBean  --%>
<%-- 					id="testActionTag" --%>
<%-- 					scope="request" --%>
<%-- 					class="spms.dto.MemberDto" --%>
<%-- 				/> --%>
				
<%-- 				<jsp:setProperty property="password" name="testActionTag"  --%>
<%-- 					value="amazing" /> --%>
<%-- 				<jsp:getProperty property="password" name="testActionTag"  --%>
<%-- 					value="amazing" /> --%>
				
				<c:forEach var="memberDto" items="${memberList}">
					<tr>
						<td>${memberDto.no}</td>
						<td>${memberDto.name}</td>
						<td class='textWrap'>${memberDto.email}</td>
						<td>${memberDto.createDate}</td>
						<td>
							<a href='update?no=${memberDto.no}' class='manageBtn'>
								수정
							</a>
							<span> / </span>
							<a href='./delete?no=${memberDto.no}' class='manageBtn'>
								삭제
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	
	<jsp:include page="/Tail.jsp"/>
</body>

</html>