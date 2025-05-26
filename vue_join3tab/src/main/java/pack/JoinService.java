package pack;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
	@Autowired
	private BuserRepository buserRepository;
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Autowired
	private GogekRepository gogekRepository;
	
	public List<BuserJikwonGogekDto> getJoinedData(){
		return buserRepository.findAllJoinedData();
	}
	
	public List<Buser> getAllBusers(){
		return buserRepository.findAll();
	}
	
	public List<JikwonDto> getAllJikwons(){
		return jikwonRepository.findAll().stream().map(jikwon -> new JikwonDto(
				jikwon.getJikwonno(),
				jikwon.getJikwonname(),
				jikwon.getJikwonjik(),
				jikwon.getJikwonpay(),
				jikwon.getJikwongen(),
				jikwon.getBuser().getBusername(),
				jikwon.getJikwonrating(),
				jikwon.getJikwonibsail().toString()))
				.collect(Collectors.toList());
	}
	
	public List<Gogek> getAllGogeks(){
		return gogekRepository.findAll();
	}
	
}
