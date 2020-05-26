<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Array 객체에서 값 꺼내기</title>

</head>

<%
	pageContext.setAttribute("scoreArr", new int[]{
		90, 80, 70, 100
	});

	String[] nameArr = new String[2];
	
	nameArr[0] = "상아";
	nameArr[1] = "홍";

	pageContext.setAttribute("nameArr", nameArr);
%>

<body>
	
	${scoreArr[2]}
	${nameArr[1]}
	
</body>

</html>