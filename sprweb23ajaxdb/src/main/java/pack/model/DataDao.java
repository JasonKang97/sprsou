package pack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataRepository dataRepository;
	
	@Autowired
	private DataRepository2 dataRepository2;
	
	// 부서자료 읽기
	public List<BuserDto> buserList(){
		List<BuserDto> blist = dataRepository.findAll()
								.stream().map(BuserDto::fromEntity).collect(Collectors.toList());
		return blist;
	}
	
	// 직원 자료 읽기
	public List<JikwonDto> jikwonList(int buserno){
		/*
		List<JikwonDto> jlist = new ArrayList<JikwonDto>();
		// 방법1: 향상된 for
		for(Jikwon jikwon:dataRepository2.buserDatas(buserno)) {
			jlist.add(JikwonDto.fromEntity(jikwon));
		}
		*/
		
		// 방법2: lambda 표현식 (:: 사용)
		List<JikwonDto> jlist = dataRepository2.buserDatas(buserno)
								.stream().map(JikwonDto::fromEntity).collect(Collectors.toList());
		
		return jlist;
	}
	
}
