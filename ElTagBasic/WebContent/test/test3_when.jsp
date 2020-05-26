<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>계절</title>

</head>

<body>
	
	<c:set var="month" value="13"/>
	
	<c:choose>
		<c:when test="${month == 12 || (month >= 1 && month <= 2)}">
			<c:set var="season" value="겨울"/>
		</c:when>
		<c:when test="${month >= 3 && month <= 5}">
			<c:set var="season" value="봄"/>
		</c:when>
		<c:when test="${month >= 6 && month <= 8}">
			<c:set var="season" value="여름"/>
		</c:when>
		<c:when test="${month >= 9 && month <= 11}">
			<c:set var="season" value="가을"/>
		</c:when>
		
		<c:otherwise>
			해당 월은 존재하지 않습니다.
		</c:otherwise>
	</c:choose>
	
	${season}
	
</body>

</html>

