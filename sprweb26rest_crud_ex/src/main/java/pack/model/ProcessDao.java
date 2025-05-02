package pack.model;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SangdataBean;

@Repository
public class ProcessDao {
	@Autowired
	private SangpumRepository repository;
	
	// ViewController
	public int getMaxCode() {
		return repository.findMaxCode()+1;
	}
	
	public SangdataDto getDate(int code) {
		Sangdata sangdata = repository.findById(code).orElse(null);
		return SangdataDto.fromEntity(sangdata);
	}
	
	
	
	
	// MainController
	public List<SangdataDto> getDataAll(){
		List<Sangdata> list = repository.findAll();
		return list.stream().map(SangdataDto::fromEntity).collect(Collectors.toList());
	}
	
	public void insert(SangdataBean bean){
		repository.save(SangdataBean.toEntity(bean));
	}
	
	public void update(SangdataBean bean){
		repository.save(SangdataBean.toEntity(bean));			
	}
	
	public String delete(int code){
		if(repository.findById(code).isPresent()) {
			repository.deleteById(code);
			return "success";
		}else {
			return "fail";
		}
	}
}
