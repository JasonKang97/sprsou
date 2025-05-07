package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Buser {
	@Id
	private int buserno;
	private String busername;
	private String busertel;
	
	// buser에서 jikwon을 부를 때 필요(양방향)
	@OneToMany(mappedBy = "buser")
	private List<Jikwon> jikwons;
}
