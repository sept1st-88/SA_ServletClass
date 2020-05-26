<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>h태그</title>

</head>

<%
	List<String> nameList = new ArrayList<String>();
	
	nameList.add("고재민");
	nameList.add("원아름");
	nameList.add("박상아");
	nameList.add("차정경");
	
	request.setAttribute("nameList", nameList);
%>

<body>
	
	<c:forEach var="name" items="${nameList}">
		<div style="border: 1px solid black;">${name}</div>
	</c:forEach>
	
</body>

</html>

