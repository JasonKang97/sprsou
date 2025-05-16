<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
{"items":[
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String result = "";

try{
	Class.forName("org.mariadb.jdbc.Driver");
	String url = "jdbc:mariadb://localhost:3306/test";
	conn  = DriverManager.getConnection(url, "root", "123");
	
	Thread.sleep(3000);
	
	pstmt = conn.prepareStatement("select * from sangdata");
	rs = pstmt.executeQuery();
	while(rs.next()){
		result += "{";
		result += "\"id\":" + "\"" + rs.getString("code") + "\",";
		result += "\"name\":" + "\"" + rs.getString("sang") + "\",";
		result += "\"price\":" + "\"" + (rs.getInt("su") * rs.getInt("dan")) + "\"";
		result += "},";
	}
	
	if(result.length()>0){
		out.print(result.substring(0,result.length()-1));
	}
	
	
}catch(Exception e){
	System.out.println("처리 오류: " + e.getMessage());
}finally{
	try{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}catch(Exception e2){
		
	}
}
%>
]}