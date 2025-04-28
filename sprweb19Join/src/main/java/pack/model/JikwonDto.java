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
@Builder
public class JikwonDto {
	private int jikwonno;
	private String jikwonname, jikwonjik, jikwonpay;
	private BuserDto buserDto;
	
	// DTO -> Entity
	public Jikwon toEntity() {
		/*
		Jikwon jikwon = new Jikwon();
		jikwon.setJikwonno(jikwonno);
		jikwon.setJikwonname(jikwonname);
		jikwon.setJikwonjik(jikwonjik);
		jikwon.setJikwonpay(jikwonpay);
		if(this.buserDto!=null) {
			jikwon.setBuser(this.buserDto.toEntity());
		}
		return jikwon;
		*/
		
		// 위의 코드를 Builder를 사용해 리팩토링하기
		
		return Jikwon.builder()
				.jikwonno(jikwonno)
				.jikwonname(jikwonname)
				.jikwonjik(jikwonjik)
				.jikwonpay(jikwonpay)
				.build();
	}
	
	// Entity -> DTO
	public static JikwonDto fromEntity(Jikwon jikwon) {
		/*
		JikwonDto dto = new JikwonDto();
		dto.setJikwonno(jikwon.getJikwonno());
		dto.setJikwonname(jikwon.getJikwonname());
		dto.setJikwonjik(jikwon.getJikwonjik());
		dto.setJikwonpay(jikwon.getJikwonpay());
		if(jikwon.getBuser() != null) {
			dto.setBuserDto(BuserDto.fromEntity(jikwon.getBuser()));
		}
		return dto;
		*/
		
		// 위의 코드를 Builder를 사용해 리팩토링하기
		return JikwonDto.builder()
				.jikwonno(jikwon.getJikwonno())
				.jikwonname(jikwon.getJikwonname())
				.jikwonjik(jikwon.getJikwonjik())
				.jikwonpay(jikwon.getJikwonpay())
				.build();
	}
	
}
