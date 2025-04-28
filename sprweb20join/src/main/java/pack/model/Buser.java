package pack.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Buser {
	@Id
	private int buserno;
	private String busername;
	private String busertel;
	
	@OneToMany(mappedBy = "buser")	// 양쪽 테이블에서 참조 가능. 이 annotation이 없으면 단방향(직원에서 부서 참조만 가능)
	private List<Jikwon> jikwons;
}
