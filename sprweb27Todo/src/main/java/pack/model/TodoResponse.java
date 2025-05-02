package pack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponse {	// dto
	private Integer id;
	private String title;
	private Integer order;
	private Boolean complited;
	
	
	public TodoResponse(TodoEntity entity) {	// 생성자로 Entity를 Dto에게 전달
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.order = entity.getOrder();
		this.complited = entity.getComplited();
	}
}
