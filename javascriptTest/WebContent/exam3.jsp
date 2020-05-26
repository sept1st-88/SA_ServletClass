<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
   table{
      border: 1px solid black;
      border-collapse: collapse;
   }
   tr, td{
      border: 1px solid black;
   }
</style>
<script type="text/javascript">
   
   window.onload = function() {

   }

   function createTableFnc(trNum, tdNum) {
      var resultDiv = document.getElementById('resultDiv');
      
      var tableObj = document.createElement('table');
      tableObj.setAttribute('class', 'crTableClass');   
      
      for (var i = 0; i < trNum; i++) {
         var trObj = document.createElement('tr');
         trObj.setAttribute('class', 'crTrClass');
         tableObj.appendChild(trObj);
         
         for (var n = 0; n < tdNum; n++) {
            var tdObj = document.createElement('td');
            tdObj.setAttribute('class', 'crTdClass');
            trObj.appendChild(tdObj);
         }
      }
      resultDiv.appendChild(tableObj);
   }
   
   function tableInputFnc() {
      var resultDiv = document.getElementById('resultDiv');

      var nameObj = document.getElementById('nameTxt');
      var nicknameObj = document.getElementById('nicknameTxt');
      
      if(resultDiv.hasChildNodes() == false){
         createTableFnc(2, 2);
      } 
            
      var tdObjArr = document.getElementsByClassName('crTdClass');         
      tdObjArr[0].innerHTML = '이름';
      tdObjArr[1].innerHTML = nameObj.value;   
      tdObjArr[2].innerHTML = '별명';
      tdObjArr[3].innerHTML = nicknameObj.value;
      
   }
   
</script>
</head>

<body>
   
   <div>
      이름: <input id='nameTxt' type="text" value="">
   </div>
   <div>
      별명: <input id='nicknameTxt' type="text" value="">
   </div>
   
   <div id='resultDiv'></div>
   
   <button onclick="tableInputFnc();">날 누르면 테이블이 만들어져</button>

</body>
</html>