<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	window.onload = function() {
		var divObj = document.getElementById('tableWrap');

		//객체 생성
		var tableObj = document.createElement('table');
		var trObjList = new Array();
		var tdObjList = new Array();
		var textList = new Array();
		
		var trNum = 4;
		
		for (var i = 0; i < trNum; i++) {
			trObjList[i] = document.createElement('tr');
			tdObjList[i] = document.createElement('td');
			textList[i] = document.createTextNode(i+1);
		}
		
		//객체 등록
		for (var i = 0; i < trObjList.length; i++) {
			tableObj.appendChild(trObjList[i]);
			trObjList[i].appendChild(tdObjList[i]);
			tdObjList[i].appendChild(textList[i]);
		}
		
		//스타일 생성
		tableObj.setAttribute('style', 'border: 1px solid black; border-collapse: collapse;');
		
		//table 등록
		divObj.appendChild(tableObj);
	}
</script>

</head>

<body>
	
	<div id='tableWrap'>
	</div>
	
</body>

</html>