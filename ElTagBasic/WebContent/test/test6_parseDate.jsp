<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>fmf:parseDate 날짜 형식으로 작성된 문자열을 분석하여 java.util.Date객체를
	생성한다</title>

</head>


<%
	Date cal = new Date();

	String month = (cal.getMonth() + 1) + "";

	String date = cal.getDate() + "";

	String dateStr = month + "-" + date;

	application.setAttribute("dateStr", dateStr);

	System.out.println(month);
	System.out.println(date);
	System.out.println(dateStr);
%>


<body>
	<fmt:parseDate var="date" value="${dateStr}" pattern="MM-dd" />

	<fmt:formatDate value="${date}" pattern="MM월dd일" />

	<%--     <br> ${date}  --%>

	<!--    05월19일 -->

</body>



</html>