package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Jikwon {
	@Id
	private int jikwonno;
	
	private String jikwonname;
	private String jikwonjik;
	private String jikwongen;
	
	@ManyToOne(targetEntity = Buser.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "busernum")
	private Buser buser;
	
	// jikwon에서 gogek을 부를 때 필요(양방향)
	@OneToMany(mappedBy = "jikwon")
	private List<Gogek> gogeks;
}
