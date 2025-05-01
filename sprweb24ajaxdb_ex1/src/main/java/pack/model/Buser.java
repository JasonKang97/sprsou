package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Buser {
	@Id
	private int buserno;
	
	private String busername;
	private String busertel;
	
}
