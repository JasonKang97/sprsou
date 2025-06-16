<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession httpSession = request.getSession(false);

if(httpSession != null && httpSession.getAttribute("userid") != null){
	String userid = (String)httpSession.getAttribute("userid");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 성공 페이지</h2>
<p>환영합니다. <%=userid %>님</p>
인증에 성공했으므로 제공된 자료를 사용하십시오
<hr>
<a href="logout.jsp">로그아웃</a>
</body>
</html>

<%
}else{
	response.sendRedirect("login.html");
}
%>