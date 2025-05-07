package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Gogek {
	@Id
	private int gogekno;
	
	private String gogekname;	
	
	@ManyToOne(targetEntity = Jikwon.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "gogekdamsano")
	private Jikwon jikwon;
}
