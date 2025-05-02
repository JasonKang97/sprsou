package pack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
	private Integer id;
	
	private String title;
	private Integer order;
	private Boolean completed;
	
	public TodoResponse(TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.order = entity.getOrder();
		this.completed = entity.getCompleted();
	}
}