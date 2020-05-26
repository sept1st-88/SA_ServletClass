<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>fmf:parseDate</title>

<!-- 날짜 형식으로 작성된 문자열을 분석하여 java.util.Date객체를 생선한다 -->
</head>

<body>
	
	<!-- 불러옴, pattern:불러오는 방식 -->
	<fmt:parseDate var="date" value="2020-05-19" pattern="yyyy-MM-dd"/>
	
	<!-- 출력, pattern:출력방식 -->
	<fmt:formatDate value="${date}" pattern="yyyy/MM/dd"/><br>
	
	${date}
	
</body>

</html>