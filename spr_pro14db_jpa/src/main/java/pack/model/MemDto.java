package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity	// 원본 테이블과 매핑
@Table(name = "mem")	// 실제 테이블명
public class MemDto {
	@Id	// primary key라는 의미
	@Column(name = "num")
	private int num;
	
	@Column(name = "name", nullable = false)
	private String name;

	//@Column(name = "addr", nullable = false)
	private String addr;
	
	// 원본 테이블의 column명과 entity의 field명이 동일할 경우 별도로 지정하지 않아도 된다.
}
