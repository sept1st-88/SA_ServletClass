<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>관계 연산자</title>

</head>

<body>
	
	${10 == 11}<br>
	${10 eq 11}<br> <!-- eq = equal -->
	${10 != 11}<br>
	<%-- ${10 ne 11}<br> --%> <!-- ne = negative -->
	${10 < 11}<br>
	${10 lt 11}<br> <!-- lt = less than -->
	${10 > 11}<br>
	${10 gt 11}<br> <!-- gt = greater than -->
	${10 <= 11}<br>
	${10 le 11}<br> <!-- le = less than or equal to -->
	${10 >= 11}<br>
	${10 ge 11}<br> <!-- ge = greater than or equal to -->
	
</body>

</html>