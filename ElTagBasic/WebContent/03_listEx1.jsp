<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>List 객체에서 값 꺼내기</title>

</head>

<%
	List<String> nameList = new ArrayList<String>();

	nameList.add("홍길동");
	nameList.add("일지매");
	nameList.add("카트린느");
	
	request.setAttribute("nameList", nameList);
%>

<body>
	
	${nameList[1]}
	${nameList[2]}
	
</body>

</html>