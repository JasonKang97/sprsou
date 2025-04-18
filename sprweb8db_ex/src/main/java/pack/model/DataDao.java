package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private MyDataSource dataSource;
	
	public ArrayList<JikwonDto> selectJik(String jikwonjik){
		ArrayList<JikwonDto> list= new ArrayList<JikwonDto>();
		
		try {
			String sql = "select * from jikwon where jikwonjik='" + jikwonjik + "'";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getString("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonibsail(rs.getString("jikwonibsail"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("selectJik err: " + e);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;
	}
	
}
