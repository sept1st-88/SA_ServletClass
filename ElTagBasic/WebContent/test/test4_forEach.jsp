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
	List<String> strList = new ArrayList<String>();
	
	for(int i = 0; i < 6; i++){
		strList.add("JSTL 예제");
	}
	
	request.setAttribute("strList", strList);
%>

<body>
	
	<c:forEach var="str" items="${strList}" varStatus="indexVal">
		<h1>${str} ${indexVal.index + 1}</h1>
	</c:forEach>
	
</body>

</html>

