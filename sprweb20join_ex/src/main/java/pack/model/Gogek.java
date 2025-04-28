package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Gogek {
	@Id
	private int gogekno;
	private String gogekname;
	private String gogektel;
	private String gogekjumin;
	private int gogekdamsano;
	private String gogekgen;
	private int gogekage;
	
	@ManyToOne
	@JoinColumn(name="gogekdamsano", insertable = false, updatable = false)
	private Jikwon jikwon;
}
