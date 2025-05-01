package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private BuserRepository buserRepository;

	@Autowired
	private JikwonRepository jikwonRepository;

	@Autowired
	private GogekRepository gogekRepository;


	public JikwonDto findJikwonDtoByNoAndName(int jikwonno, String jikwonname) {
		Jikwon jikwon = jikwonRepository.findByJikwonnoAndJikwonname(jikwonno, jikwonname);
		if (jikwon != null && jikwon.getJikwonname() != null) {
			return JikwonDto.toDto(jikwon);
		} else {
			return null;
		}
	}
	
	public List<GogekDto> findGogekByGogekdamsano(int gogekdamsano) {
		List<Gogek> gogeks = gogekRepository.findByGogekdamsano(gogekdamsano);
		if (gogeks != null && !gogeks.isEmpty()) {
			return gogeks.stream().map(GogekDto::toDto).collect(Collectors.toList()); 
		}else {
			return null;
		}
	} 
}

