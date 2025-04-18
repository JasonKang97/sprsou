package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class MemDataProcess {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapperInterface dataMapperInterface;	// 자동으로 pooling(DBCP) - HikariPool
	
	// 전체 자료 읽기
	public List<MemDto> getDataAll(){
		List<MemDto> list = dataMapperInterface.selectAll();
		logger.info("data: " + list.size());
		return list;
	}
	
	// 자료 추가
	public boolean insert(MemBean bean){
		// 번호 중복 확인 또는 번호 자동 증가 생략
		logger.info("num: " + bean.getNum());
		int re =  dataMapperInterface.insertData(bean);
		if(re>0) return true;
		else return false;
	}
	
}
