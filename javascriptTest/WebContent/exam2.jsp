<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.onload = function() {
		var spanNum = 8;
		var innerDivNum = 4;
		
		testFnc(spanNum, innerDivNum);
	}
	
	function testFnc(spanNum, innerDivNum) {
		var divObj = document.getElementById('tableWrap');
		divObj.style.border = '1px solid black';
		
		//inner div 객체 생성
		var innerDivObjList = [];
		
		innerDivObjList[0] = document.createElement('div');
		
		//span객체 생성
		var spanObjList = [];
		
		for (var i = 0; i < spanNum; i++) {
			spanObjList[i] = document.createElement('span');
			spanObjList[i].style.border = '1px solid black';
			
			innerDivObjList[0].appendChild(spanObjList[i]);
		}
		
		//inner div 객체 복제 및 출력
// 		var innerDivNum = 4;
		
		for (var i = 0; i < innerDivNum; i++) {
			innerDivObjList[i] = innerDivObjList[0].cloneNode(true);
			divObj.appendChild(innerDivObjList[i]);
		}
		
		//span객체에 텍스트 생성
		for (var i = 0; i < innerDivObjList.length; i++) {
			for (var n = 0; n < spanObjList.length; n++) {
				innerDivObjList[i].children[n].innerHTML = i+1;
			}
		}
		
	}
</script>

</head>

<body>
	
	<div id='tableWrap'>
<!-- 		style="border: 1px solid black; width: 40px;" -->
<!-- 		<div> -->
<!-- 			<span style="border: 1px solid black;">1</span> -->
<!-- 			<span>1</span> -->
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<span>2</span> -->
<!-- 			<span>2</span> -->
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<span>3</span> -->
<!-- 			<span>3</span> -->
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<span>4</span> -->
<!-- 			<span>4</span> -->
<!-- 		</div> -->
	</div>
	
</body>

</html>