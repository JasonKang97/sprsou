package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sangdata")
public class Sangpum {
	@Id
	private double code;
	
	private String sang;
	private String su;
	private String dan;
}
