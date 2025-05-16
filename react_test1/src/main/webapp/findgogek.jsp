<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*"%>
<%
String phone = request.getParameter("phone");

JSONArray customers = new JSONArray();

try {
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
	PreparedStatement ps = conn.prepareStatement("SELECT * FROM gogek where gogektel like ?");
	ps.setString(1, phone + "%");
	ResultSet rs = ps.executeQuery();

	while (rs.next()) {
		JSONObject obj = new JSONObject();
		obj.put("gogekno", rs.getInt("gogekno"));
		obj.put("gogekname", rs.getString("gogekname"));
		obj.put("gogektel", rs.getString("gogektel"));
		customers.add(obj);
	}
	rs.close();
	ps.close();
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
}

out.print(customers.toString());
%>