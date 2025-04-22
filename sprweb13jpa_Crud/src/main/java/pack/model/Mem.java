package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "mem")
public class Mem {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	// 자동증가. 테이블에서 autoincrement를 작성하면 여기서 사용 가능.
	@Column(name = "num")
	private int num;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "addr")
	private String addr;
}
