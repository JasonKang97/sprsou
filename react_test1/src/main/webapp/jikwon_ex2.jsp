<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*"%>
<%
// cors 문제 해결
response.setHeader("Access-Control-Allow-Origin", "*");
// response.setHeader("Access-Control-Allow-Methods", "GET,POST");
JSONArray employees = new JSONArray();

String busernum = request.getParameter("busernum");
String order = request.getParameter("order");

try {
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
	String sql = "SELECT * FROM jikwon";
	if (busernum != null && !busernum.trim().equals("")) {
	    sql += " WHERE busernum=?";
	}
	if (order.equals("asc")) {
	    sql += " ORDER BY jikwonpay ASC";
	} else {
	    sql += " ORDER BY jikwonpay DESC";
	}
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, busernum);
	ps.setString(2, order);
	ResultSet rs = ps.executeQuery();

	while (rs.next()) {
		JSONObject obj = new JSONObject();
		obj.put("jikwonno", rs.getInt("jikwonno"));
		obj.put("jikwonname", rs.getString("jikwonname"));
		obj.put("jikwonjik", rs.getString("jikwonjik"));
		obj.put("jikwonpay", rs.getString("jikwonpay"));
		employees.add(obj);
	}
	rs.close();
	ps.close();
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
}

out.print(employees.toString());
%>