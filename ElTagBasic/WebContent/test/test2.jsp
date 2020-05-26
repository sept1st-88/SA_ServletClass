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
<!-- 	자신의 나이를 변수 -->
<!-- 	짝의 이름 -->
<!-- 	짝의 나이를 변수 -->
	
<!-- 	자신과 짝의 나이를 비교해서 -->
<!-- 	많은 사람의 이름을 출력하시오 -->

	<c:set var="myName" value="이뿐내여친"/>
	<c:set var="myAge" value="33"/>
	<c:set var="hisName" value="김홍"/>
	<c:set var="hisAge" value="27"/>
	
	${hisName}
	<c:if test="${hisAge < myAge}">
		동생
	</c:if>
	<c:if test="${hisAge == myAge}">
		친구
	</c:if>
	<c:if test="${hisAge > myAge}">
		오빠
	</c:if>
	
</body>

</html>

