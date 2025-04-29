package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Jikwon {
	@Id
	private int jikwonno;
	
	private String jikwonname;
	private String jikwonjik;
	
	@Column(name = "busernum")
	private String buser;
}
