package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buser")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @Build를 사용하면 빌더 패턴이 가능. 복잡한 매개변수가 많을 때, 유효한 디자인 패턴.
// step by stpe으로 값을 입력한 후에 최종적으로 build()메소드로 하나의 인스턴스를 생성하여 반환.
public class Buser {
	@Id
	int buserno;
	private String busername;
	private String buserloc;
	private String busertel;
	
}
