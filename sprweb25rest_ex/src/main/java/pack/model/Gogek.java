package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gogek {
	@Id
	private int gogekno;
	private String gogekname;
	private int gogekdamsano;
	private String gogektel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="gogekdamsano", insertable = false, updatable = false)
	private Jikwon jikwon;

}
