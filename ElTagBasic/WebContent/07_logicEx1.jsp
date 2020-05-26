<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>로직 연산자</title>

</head>

<body>
	
	${true && false}<br>
	${true and false}<br>
	${false || true}<br>
	${false or true}<br>
	${not true}<br>
	${!true}
	
</body>

</html>