<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>조건1</title>

</head>

<body>
	
<!-- 	자신의 이름 -->
<!-- 	자신의 나이를 변수로 만들어서 출력하시오 -->

	<c:set var="myName" value="박상아"/>
	<c:set var="myAge" value="33"/>
	
	${myName}
	${myAge}
	
</body>

</html>