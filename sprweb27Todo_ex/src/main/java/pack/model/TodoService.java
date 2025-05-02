package pack.model;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import pack.controller.TodoRequest;

@Service
@AllArgsConstructor
public class TodoService {
	private TodoRepository todoRepository;
	
	public TodoEntity add(TodoRequest request) {
		TodoEntity todoEntity = new TodoEntity();
		todoEntity.setTitle(request.getTitle());
		todoEntity.setOrder(request.getOrder());
		todoEntity.setCompleted(request.getCompleted());
		return this.todoRepository.save(todoEntity);
	}
	public List<TodoEntity> searchAll() {
		return this.todoRepository.findAll();
	}
	public TodoEntity searchById(Integer id) {
		System.out.println(id);
		return this.todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	public TodoEntity updateById(Integer id, TodoRequest request) {
		TodoEntity todoEntity = searchById(id);
		if(request.getTitle() != null) todoEntity.setTitle(request.getTitle());
		if(request.getOrder() != null) todoEntity.setOrder(request.getOrder());
		if(request.getCompleted() != null) todoEntity.setCompleted(request.getCompleted());
		
		return this.todoRepository.save(todoEntity);
	}
	public void deleteById(Integer id) {
		todoRepository.deleteById(id);
	}
	public void deleteAll() {
		todoRepository.deleteAll();
	}
}