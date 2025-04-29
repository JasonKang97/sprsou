package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuserDto {
	private int buserno;
	private String busername;
	private String busertel;
	
	public static BuserDto fromEntity(Buser buser) {
		
		return BuserDto.builder()
				.buserno(buser.getBuserno())
				.busername(buser.getBusername())
				.busertel(buser.getBusertel())
				.build();
	}
}
