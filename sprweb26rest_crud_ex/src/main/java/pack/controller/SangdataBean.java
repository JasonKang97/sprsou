package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Sangdata;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SangdataBean {
	private int code;
	private String sang;
	private int su;
	private int dan;
	
	public static Sangdata toEntity(SangdataBean bean) {
		return Sangdata.builder()
				.code(bean.code)
				.sang(bean.sang)
				.su(bean.su)
				.dan(bean.dan)
				.build();
				
	}
}
