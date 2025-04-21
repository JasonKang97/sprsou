package pack.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private JikwonRepository repository;
	
	// 전체 자료 읽기
	public List<JikwonDto> getDataAll(){
		List<JikwonDto> list = repository.findAll();
		return list;
	}

	// 전체 자료 읽기
	public List<JikwonDto> getSearchData(String jikwonjik){
		List<JikwonDto> list = repository.findByJikwonjikContaining(jikwonjik);
		return list;
	}
}
