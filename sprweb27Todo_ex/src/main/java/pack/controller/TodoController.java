package pack.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import pack.model.TodoEntity;
import pack.model.TodoResponse;
import pack.model.TodoService;

@CrossOrigin(origins = "*") // 기본적으로 다른 도메인에서 서버에 대한 요청을 차단함, 모든 도메인 요청 허용
@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {
	private final TodoService service;
	
	@GetMapping
	public ResponseEntity<List<TodoResponse>> readAll(){
		return ResponseEntity.ok(service.searchAll().stream().map(TodoResponse::new).toList());
	}
	@GetMapping(value="{id}") 
	public ResponseEntity<TodoResponse> readById(@PathVariable("id") int id){
		return ResponseEntity.ok(new TodoResponse(service.searchById(id)));
	}
	@PostMapping
	public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request){
		if(ObjectUtils.isEmpty(request.getTitle())) return ResponseEntity.badRequest().build();
		if(ObjectUtils.isEmpty(request.getOrder())) request.setOrder(0);
		if(ObjectUtils.isEmpty(request.getCompleted())) request.setCompleted(false);
	
		return ResponseEntity.ok(new TodoResponse(service.add(request))); // JSON 형식 반환
	}
	@PatchMapping("{id}")
	public ResponseEntity<TodoEntity> update(@PathVariable("id")int id,
	@RequestBody TodoRequest request) {
		TodoEntity entity = service.updateById(id, request);
		return ResponseEntity.ok(entity);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id")int id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		service.deleteAll();
		return ResponseEntity.ok().build();
	}
}