package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@NoArgsConstructor
@AllArgsConstructor
public class Buser {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	// 자동 증가 컬럼
	private int buserno;
	private String busername, buserloc, busertel;
	
	@OneToMany(mappedBy = "buser", fetch = FetchType.LAZY)	// Jikwon 엔티티의 Buser 타입 객체명. 
	// Jikwon 엔티티의 Buser 필드를 기준으로 메핑관계가 됨을 나타냄.
	// mappedBy = "buser"는 메인이 아님. 즉, 연관관계의 메인은 Jikwon 엔티티가 된다.
	private List<Jikwon> jikwonList;	// Jikwon 엔티티들의 리스트
}
