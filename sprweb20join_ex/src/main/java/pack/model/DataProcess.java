package pack.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataProcess {
	@Autowired
	private BuserRepository buserRepository;
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Autowired
	private GogekRepository gogekRepository;
	
	public List<Jikwon> getJikwonListAll(){
		List<Jikwon> list = jikwonRepository.findAll();
		return list;
	}
	
	public List<GogekDto> getGogekListAll(String jikwonname){
		List<Gogek> list = gogekRepository.gogekList(jikwonname);
		return list.stream().map(GogekDto::fromEntity).collect(Collectors.toList());
	}

}
