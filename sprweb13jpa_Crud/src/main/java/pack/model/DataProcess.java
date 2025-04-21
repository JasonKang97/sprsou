package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataProcess {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemCrudRepository repository;	// 자동으로 pooling 처리됨. HikariPool
	
	// 전체 자료 읽기
	public List<Mem> getDataAll(){
		List<Mem> list = repository.findAll();
		logger.info("list size: " + list.size());
		return list;
	}
}
