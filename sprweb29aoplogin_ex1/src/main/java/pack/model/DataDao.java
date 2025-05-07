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
	
	@Autowired
	private GogekRepository gogekRepository;
	
	public List<Jikwon> jikwonListAll(){
		List<Jikwon> list = jikwonRepository.findAll();
		return list;
	}
	
	public Jikwon gogekLogin(int gogekno, String gogekname) {
		return jikwonRepository.gogekLogin(gogekno, gogekname);
	}
	
	
	

	
}
