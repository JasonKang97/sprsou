package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {	// FormBean 역할
	private String title;
	private Integer order;
	private Boolean complited;
}
