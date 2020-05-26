<%@page import="spms.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">

<style type="text/css">
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

	<h1 id='pageTitle'>회원목록</h1>
	
	<p>
		<a href='add' id='addLink'>
			신규 회원 등록
		</a>
	</p>
	
	<table id='table'>
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
			<%
			ArrayList<MemberDto> memberList = 
				(ArrayList<MemberDto>)request.getAttribute("memberList");
			
			for(MemberDto memberDto : memberList){
			%>
				<tr>
					<td><%=memberDto.getNo()%></td>
					<td><%=memberDto.getName()%></td>
					<td><%=memberDto.getEmail()%></td>
					<td><%=memberDto.getCreateDate()%></td>
					<td>
						<a href='update?no=<%=memberDto.getNo()%>' class='manageBtn'>
							수정
						</a>
						<span> / </span>
						<a href='./delete?no=<%=memberDto.getNo()%>' class='manageBtn'>
							삭제
						</a>
					</td>
				</tr>
			<%
			}
			%>
		</tbody>
	</table>
	
	<jsp:include page="/Tail.jsp"/>
</body>

</html>