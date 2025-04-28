package pack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controll.BuserBean;

@Repository
public class DataProcess {
	@Autowired
	private BuserCrudRepository repository;
	
	public List<BuserDto> getDataAll(){
		List<Buser> list = repository.findAll();
		
		/*
		List<BuserDto> dtoList = new ArrayList<BuserDto>();
		for(Buser buser:list) {
			BuserDto dto = BuserDto.fromEntity(buser);
			dtoList.add(dto);
		}
		return dtoList;	// 최종적으로 변환된 BuserDto를 저장한 리스트 컬렉션 반환
		 */
		// 위의 코드를 stream을 사용하여 간결하게 작성
		
		// 스트림의 모든 요소를 리스트로 수집한 후 반환
		return list.stream().map(BuserDto::fromEntity).collect(Collectors.toList());
	}
	
	@Transactional
	public String insert(BuserBean bean) {
		// 부서번호 중복 확인
		Buser existingData = repository.findById(bean.getBuserno()).orElse(null);
		// orElse(null): 자료가 없을 경우 null을 반환
		if(existingData != null) {
			return "이미 등록된 번호입니다.";
		}else {	// 저장
			Buser buser = bean.toEntity();	// 폼빈 자료를 엔티티로 넘겨줌
			repository.save(buser);	// hibername에 의해 insert문이 수행된다.
			return "success";
		}
	}
	
}
