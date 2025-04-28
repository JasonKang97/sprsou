package pack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonService {
	@Autowired
	private JikwonRepository jikwonRepository;
	
	public List<JikwonDto> getJikwonDatas(){
		// 전체 자료를 읽어 반환1: List 사용
		/*
		List<Jikwon> list = jikwonRepository.findAllWithBuser();	// JPA 영역에서 처리
		List<JikwonDto> dtoList = new ArrayList<JikwonDto>();
		for(Jikwon jikwon:list) {
			dtoList.add(JikwonDto.fromEntity(jikwon));
		}
		
		return dtoList;	// JPA 영역 밖(비즈니스 로직 영역)으로 반환
		*/
		
		// 전체 자료를 읽어 반환2: stream + Lambda 사용
		/*
		return jikwonRepository.findAllWithBuser()
				.stream()	// Stream API 사용. 컬렉션의 요소를 처리하는 스트림 생성 메소드.
				.map(jikwon -> JikwonDto.fromEntity(jikwon))
				.collect(Collectors.toList());	// 스트림 처리 결과를 다시 리스트 등의 컬렉션으로 반환하는 최종 연산
				// Collectors.toList(): 스트림의 모든 요소를 리스트로 모아 반환.	
		*/
		
		// 전체 자료를 읽어 반환3: stream + Lambda 간단 표현식(::) 사용
		return jikwonRepository.findAllWithBuser()
				.stream()
				.map(JikwonDto::fromEntity)
				.collect(Collectors.toList());
	}
	
	// 조건부 join
	public List<JikwonDto> getJikwonHighPay(){
		return jikwonRepository.findAllWithHighPay()
				.stream()
				.map(JikwonDto::fromEntity)
				.collect(Collectors.toList());
	}
	
	// 조건부 join
	public List<JikwonDto> getAllBuserName(String buserName){
		return jikwonRepository.findAllBuserName(buserName)
				.stream()
				.map(JikwonDto::fromEntity)
				.collect(Collectors.toList());
	}
	
	public List<JikwonDto> getTopPainJikwon(){
		return jikwonRepository.findTopPaidJikwon()
				.stream()
				.map(JikwonDto::fromEntity)
				.collect(Collectors.toList());
	}
}
