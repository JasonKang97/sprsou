package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.JikwonDto;

@Repository
public class JikwonDao {
	@Autowired
	SqlSession session;
	
	// 전체자료 읽기
	public List<JikwonDto> getListYear(){
		return session.selectList("jikwon.getListYear");
	}
	
	// 부분자료 읽기
	public JikwonDto getData(int jikwonno){
		return session.selectOne("jikwon.getData", jikwonno);
	}
	
	
	// 자료 수정
	public void update(JikwonDto dto) {
		session.update("jikwon.update", dto);
	}
	
}
