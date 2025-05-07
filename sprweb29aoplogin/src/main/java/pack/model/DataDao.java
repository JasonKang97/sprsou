package pack.model;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Autowired
	private BuserRepository buserRepository;
	
	// 직원 전체 자료 읽기
	public List<Jikwon> jikwonListAll(){
		List<Jikwon> list = jikwonRepository.findAll();
		return list;
	}
	
	// 직원 로그인
	public Jikwon jikwonLogin(String jikwonno) {
		//Jikwon jikwon = jikwonRepository.jikwonLogin(jikwonno);	// JPQL
		Optional<Jikwon> jdto = jikwonRepository.findById(Integer.parseInt(jikwonno));	// 내장 메소드
		Jikwon jikwon = jdto.get();
		return jikwon;
	}
	

	
}
