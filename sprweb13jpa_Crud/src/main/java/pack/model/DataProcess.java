package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.contorller.MemBean;

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
	
	// 추가
	public String insert(MemBean bean){
		// 번호 자동 증가 프로그래밍인 경우
		//int max = repository.findByMaxNum();
		//max++;
		try {
			// findById(num값): select * from meme where num=num값
			Mem mem = repository.findById(bean.getNum()).get();	// 내장 메소드 사용.
			System.out.println("mem: " + mem);
			return "이미 등록된 번호입니다.";
		} catch (Exception e) {
			try {
				// 사용자가 입력한 새 회원번호가 DB에 없는 경우
				Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
				repository.save(mem);	// 내장 메소드 사용. insert문으로 처리됨
				return "success";
			} catch (Exception e2) {
				return "입력자료 오류: " + e2.getMessage();
			}
		}
	}
	
	// 수정, 삭제 자료 읽기
	public Mem getData(String num) {
		Mem mem = repository.findbyNum(num);
		return mem;
	}
	
	// 수정
	public String update(MemBean bean){
		try {
			Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
			repository.save(mem);	// 동일한 num인 경우 update문으로 처리됨
			return "success";
		} catch (Exception e) {
			return "수정 자료 오류: " + e.getMessage();
		}
	}
	
	// 삭제
	public String delete(int num){
		try {
			repository.deleteById(num);
			return "success";
		} catch (Exception e) {
			return "삭제 자료 오류: " + e.getMessage();
		}
	}
}
