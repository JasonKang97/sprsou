<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*"%>
<%
String busername = request.getParameter("busername");

JSONArray employees = new JSONArray();

try {
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
	PreparedStatement ps = conn.prepareStatement("SELECT * FROM jikwon join buser on jikwon.busernum=buser.buserno where busername like ? order by jikwonno");
	ps.setString(1, busername + "%");
	ResultSet rs = ps.executeQuery();

	while (rs.next()) {
		JSONObject obj = new JSONObject();
		obj.put("jikwonno", rs.getInt("jikwonno"));
		obj.put("jikwonname", rs.getString("jikwonname"));
		obj.put("jikwonjik", rs.getString("jikwonjik"));
		obj.put("busername", rs.getString("busername"));
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