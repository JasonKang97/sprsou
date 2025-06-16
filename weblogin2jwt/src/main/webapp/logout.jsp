<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 쿠키에서 JWT를 제거하여 로그아웃
Cookie jwtCookie = new Cookie("jwt", "");
jwtCookie.setPath("/");
jwtCookie.setMaxAge(0);
response.addCookie(jwtCookie);
response.sendRedirect("login.html");
%>