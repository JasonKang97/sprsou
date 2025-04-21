package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Column(name = "num")
	private int num;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "addr")
	private String addr;
}
