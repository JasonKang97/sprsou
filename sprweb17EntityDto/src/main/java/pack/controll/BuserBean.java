package pack.controll;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Buser;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder	// 일반적으로 @AllArgsConstructor와 @NoArgsConstructor를 같이 사용해준다.
public class BuserBean {
	int buserno;
	private String busername;
	private String buserloc;
	private String busertel;
	
	
	/*
	entity를 사용자에게 노출하면 원하지 않는 상황에서 자원의 속성이 변경될 가능성이 있다.
	그리고 엔티티를 UI계층에 노출하는 것은 테이블 설계를 화면에 공개하는 것이나 다름없기 때문에
	보안상으로도 바람직하지 못한 구조가 된다.
	따라서 Dto와 Entity의 차이로 인해 Dto와 Entity를 분리하는 것이 바람직하다.
	따라서 FormBean과 Entity의 차이로 인해 FormBean와 Entity를 분리하는 것이 바람직하다.
	*/
	
	// BuserBean(FormBean)을 Buser 엔티티로 변환하는 메소드
	public Buser toEntity() {
		return Buser.builder()
				.buserno(this.buserno)
				.busername(this.busername)
				.buserloc(this.buserloc)
				.busertel(busertel)
				.build();	// 최종적으로 builder 객체에 설정된 값을 바탕으로 Buser 객체를 생성 후 반환
		// 단계별로 Buser(Entity) 객체의 각 필드를 설정할 수 있다.
		// Builder 패턴 장점: 가독성, 유연성, 불변성
		// Builder 패턴 단점: 
	
	
	}
}
