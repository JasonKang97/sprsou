package pack.model;

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
    
    public GogekDto findGogekDtoByNoAndName(int gogekno, String gogekname){
        Gogek gogek = gogekRepository.findByGogeknoAndGogekname(gogekno, gogekname);
        
        if (gogek != null && gogek.getJikwon() != null) {
            return GogekDto.toDto(gogek);
        } else {
            return null;
        }
    }
}