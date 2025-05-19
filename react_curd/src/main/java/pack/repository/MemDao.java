package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.MemDto;

@Repository
public class MemDao {
	@Autowired
	SqlSession session;
	
	// 전체자료 읽기
	public List<MemDto> getList(){
		return session.selectList("member.getList");
	}
	
	// 부분자료 읽기
	public MemDto getData(int num){
		return session.selectOne("member.getData", num);
	}
	
	// 자료 추가
	public void insert(MemDto dto) {
		session.insert("member.insert", dto);
	}
	
	// 자료 수정
	public void update(MemDto dto) {
		session.update("member.update", dto);
	}
	
	// 자료 삭제
	public void delete(int num) {
		session.delete("member.delete", num);
	}
}
