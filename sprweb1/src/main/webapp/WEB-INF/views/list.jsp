<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과는 
<%
String ss = (String)request.getAttribute("msg");
out.println(ss);
%>
<br>
${msg}
</body>
</html>