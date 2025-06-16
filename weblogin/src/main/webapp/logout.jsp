<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession httpSession = request.getSession(false);

//httpSession.invalidate();
httpSession.removeAttribute("userid");

response.sendRedirect("login.html");
%>