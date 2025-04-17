package pack.controller;

import java.time.LocalDate;
import lombok.Data;

@Data
public class DataDto {
	private String id, name;
	private int price;
	private LocalDate regDate;
}
