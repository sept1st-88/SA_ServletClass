<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>c:set 태그</title>

</head>

<!-- set으로 생성한 변수는 JSP 페이지의 로컬 변수가 아니라 보관소에 저장된다 -->

<body>
	
	<h3>값 설정 방식</h3>
	<c:set var="userName1" value="홍길동"/>
	<c:set var="userName2">바니프</c:set>
	
	1 ${userName1}<br>
	2 ${userName2}<br>
	
	<h3>기본 보관소</h3>
	3 ${pageScope.userName1}<br>
	4 ${requestScope.userName1}<br>
	
	<h3>보관소 지정 - scope 속성</h3>
	<c:set var="userName3" scope="request" value="일지매"/>
	5 ${pageScope.userName3}<br>
	6 ${requestScope.userName3}<br>
	
	<h3>기존의 값 덮어씀</h3>
	<% pageContext.setAttribute("userName4", "바이너리"); %>
	기존 값 = ${userName4}<br><br>
	
	<c:set var="userName4" value="binary"/>
	덮어쓴 값 = ${userName4}
	
</body>

</html>