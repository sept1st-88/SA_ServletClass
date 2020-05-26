<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>
	
	<div>
		이름: <input type="text" value=""> 
	</div>
	<div>
		별명: <input type="text" value=""> 
	</div>
	
	<div id='tableWrap'>
		<table style="border: 1px solid black; border-collapse: collapse;">
			<tr style="border: 1px solid black;">
				<td style="border: 1px solid black;">이름</td>
				<td style="border: 1px solid black;">박성욱</td>
			</tr>
			<tr style="border: 1px solid black;">
				<td style="border: 1px solid black;">별명</td>
				<td style="border: 1px solid black;">교수</td>
			</tr>
		</table>
	</div>
	
	<button onclick="tableFnc();">날 누르면 테이블이 만들어져</button>
	
</body>

</html>