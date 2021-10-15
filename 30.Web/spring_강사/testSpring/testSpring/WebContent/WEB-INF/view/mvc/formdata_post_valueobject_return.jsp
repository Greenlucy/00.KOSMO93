<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>formdata_post_valueobject_return</title>
</head>
<body>
<h3>formdata_post_valueobject_return</h3>
<hr>
<hr>
EL 표현식으로 데이터 추출하기 : <br>
${formDataVO.datanum } <br>
${formDataVO.dataid } <br>
${formDataVO.datapw } <br>
${formDataVO.dataname } <br>
<hr>
EL 표현식 및 객체함수로 데이터 추출하기 : <br>
${formDataVO.getDatanum() } <br>
${formDataVO.getDataid() } <br>
${formDataVO.getDatapw() } <br>
${formDataVO.getDatapw() } <br>
${formDataVO.getDataname() } <br>
</body>
</html>