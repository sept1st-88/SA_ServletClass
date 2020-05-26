<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.onload = function() {
		var trNum = 8;
		
		testFnc(trNum);
	}
	
	function testFnc(trNum) {
		// 객체 생성부
		var tableDivObj = document.getElementById('tableDiv');
		var tableObj = document.createElement('table');
		var trObjArr = [];
		var tdObjArr = [];
		var tdTextObjArr = {};

		for (var i = 0; i < trNum; i++) {
			trObjArr[i] = document.createElement('tr');
			tdObjArr[i] = document.createElement('td');
			tdTextObjArr[i] = document.createTextNode(i + 1);
		}

		//속성 설정부
		tableObj.setAttribute('style',
				'border: 1px solid black; border-collapse: collapse;');

		//객체 연결부
		tableDivObj.appendChild(tableObj);
		for (var i = 0; i < trNum; i++) {
			tdObjArr[i].appendChild(tdTextObjArr[i]);

			tableObj.appendChild(trObjArr[i]);
			trObjArr[i].appendChild(tdObjArr[i]);
		}

	}
</script>
</head>

<body>

	<div id='tableDiv'>
		<!--       <table style="border: 1px solid black; border-collapse: collapse;"> -->
		<!--          <tr><td>1</td></tr> -->
		<!--          <tr><td>2</td></tr> -->
		<!--          <tr><td>3</td></tr> -->
		<!--          <tr><td>4</td></tr> -->
		<!--       </table> -->
	</div>

</body>
</html>