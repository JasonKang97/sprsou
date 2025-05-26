package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.BuserDto;

@Repository
public class BuserProcess {
	@Autowired
	private SqlSession sqlSession;
	
	public List<BuserDto> getAll(){
		return sqlSession.selectList("buser.getAll");
	}
	
	public BuserDto getData(int buserno){
		return sqlSession.selectOne("buser.getData", buserno);
	}
	
	public void insert(BuserDto dto){
		sqlSession.insert("buser.insert", dto);
	}
	
	public void update(BuserDto dto){
		sqlSession.update("buser.update", dto);
	}
	
	public void delete(int buserno){
		sqlSession.delete("buser.delete", buserno);
	}
}
