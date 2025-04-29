package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SangpumDto {
	private double code;
	private String sang;
	private String su;
	private String dan;
	
	public static SangpumDto fromEntity(Sangpum sangpum) {	// Entity -> Dto

		return SangpumDto.builder()
				.code(sangpum.getCode())
				.sang(sangpum.getSang())
				.su(sangpum.getSu())
				.dan(sangpum.getDan())
				.build();
	}
}
