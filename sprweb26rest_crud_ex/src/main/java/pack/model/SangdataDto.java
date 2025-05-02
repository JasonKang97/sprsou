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
public class SangdataDto {
	private int code;
	private String sang;
	private int su;
	private int dan;
	
	public static SangdataDto fromEntity(Sangdata entity) {
		return SangdataDto.builder()
				.code(entity.getCode())
				.sang(entity.getSang())
				.su(entity.getSu())
				.dan(entity.getDan())
				.build();
	}
}
