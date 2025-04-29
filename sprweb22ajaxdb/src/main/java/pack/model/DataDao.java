package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataRepository dataRepository;
	
	public List<SangpumDto> getSangpumAll(){
//		List<SangpumDto> slist = dataRepository.findAll().stream()
//								.map(sangpum -> SangpumDto.builder()
//										.code(sangpum.getCode())
//										.sang(sangpum.getSang())
//										.su(sangpum.getSu())
//										.dan(sangpum.getDan())
//										.build())
//								.collect(Collectors.toList());
		
		List<SangpumDto> slist = dataRepository.findAll().stream()
									.map(SangpumDto :: fromEntity)
									.collect(Collectors.toList());
		return slist;				
	}
}
