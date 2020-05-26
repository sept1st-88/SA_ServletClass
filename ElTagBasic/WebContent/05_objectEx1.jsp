<%@page import="tg.com.UserVo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>빈(Bean) 객체에서 값 꺼내기</title>

</head>

<%
	UserVo userVo = new UserVo(100, "홍길동", "hong@test.com");
	UserVo psaVo = new UserVo(7, "박상아", "psa@test.com");

	
	request.setAttribute("userVo", psaVo);
	session.setAttribute("userVo", userVo);
	
	request.getParameter("sdf");
%>

<body>
	
	${sessionScope.userVo}<br>
	${requestScope.userVo}<br>
	${userVo}<br><br>
	
	${userVo.userNo}
	${userVo.userName}
	${userVo.userEmail}<br><br>
	
	${param.sdf}
	
</body>

</html>