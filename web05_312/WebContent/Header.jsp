<%@page import="spms.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDto memberDto = (MemberDto)session.getAttribute("memberDto");
%>


<div style="background-color: #a3a3c2; color: #fff; height: 20px; padding: 10px 20px;">
	SPMS(Simple Project Management System)
	
	<span style="float: right; font-size: 13px;">
		<%=memberDto.getName()%> | 
		<a href="<%=request.getContextPath()%>/auth/logout" style="color: white;">
			로그아웃
		</a>
	</span>
	
</div>