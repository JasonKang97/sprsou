package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.BuserDto;
import pack.dto.JikwonDto;

@Repository
public class JikwonProcess {
	@Autowired
	private SqlSession sqlSession;
	
	public List<JikwonDto> getJikwonAll(){
		return sqlSession.selectList("jikwon.getJikwonAll");
	}
	
}
