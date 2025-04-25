package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder	// 일반적으로 @AllArgsConstructor와 @NoArgsConstructor를 같이 사용해준다.
public class BuserDto {
	// 엔티티로부터 전체 또는 필요한 데이터(정보)만 추출한 후 클라이언트에 전송하는 역할. 
	int buserno;
	private String busername;
	private String buserloc;
	private String busertel;
	
	/* builder 패턴을 사용하지 않을 경우
	public static BuserDto fromEntity(Buser entity) {
		BuserDto dto = new BuserDto();
		dto.setBuserno(entity.getBuserno());
		dto.setBusername(entity.getBusername());
		dto.setBuserloc(entity.getBuserloc());
		dto.setBusertel(entity.getBusertel());
		return dto;
	}
	*/
	
	// builder 패턴을 사용할 경우
	public static BuserDto fromEntity(Buser entity) {
		return BuserDto.builder()
				.buserno(entity.getBuserno())
				.busername(entity.getBusername())
				.buserloc(entity.getBuserloc())
				.busertel(entity.getBusertel())
				.build();
	}
	
	
}
