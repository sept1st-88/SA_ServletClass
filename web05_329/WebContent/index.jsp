<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>초기 페이지</title>

<script type="text/javascript">

	function listPageMoveFnc() {
		location.href = '<%=request.getContextPath()%>/auth/login';
	}
	
</script>

</head>

<body>

	<p onclick="listPageMoveFnc();">329 페이지</p>
	
</body>

</html>