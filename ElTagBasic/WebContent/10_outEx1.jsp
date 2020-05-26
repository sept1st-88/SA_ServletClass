<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>c:out 태그</title>

</head>

<body>
	
	1) <c:out value="출력할 값"/><br>
	2) <c:out value="출력할 값">기본값</c:out><br>
	3) <c:out value="${null}">반가워요</c:out><br>
	4) <c:out value="안녕하세요">반가워요</c:out><br>
	5) <c:out value="${null}"/>
	
</body>

</html>