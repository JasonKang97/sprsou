package pack.controller;

import java.util.List;
import java.util.stream.Collectors;
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

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")		// 기본적으로 다른 도메인에서 서버에 요청은 차단됨. 모든 도메인 요청을 허용.
// oigins = "http://localhost:3000"으로 작성하면 3000번 서버에서만 허용 가능
@RequestMapping("/")
public class TodoController {
	private final TodoService service;
	
	@PostMapping
	public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request){
		System.out.println("create(insert)");
		
		if(ObjectUtils.isEmpty(request.getTitle())) {
			return ResponseEntity.badRequest().build();		// 에러가 있는 경우 에러 코드 반환
		}
		
		if(ObjectUtils.isEmpty(request.getOrder())) {
			request.setOrder(0);		// Order가 없는 경우 0으로 설정
		}
		
		if(ObjectUtils.isEmpty(request.getComplited())) {
			request.setComplited(false);		// Complited가 없는 경우 false으로 설정
		}
		
		TodoEntity entity = service.add(request);	// insert
		System.out.println("insert result: " + ResponseEntity.ok(new TodoResponse(entity)));
		
		return ResponseEntity.ok(new TodoResponse(entity));		// 변수=값 형식(JSON)으로 반환됨
	}
	
	@GetMapping
	public ResponseEntity<List<TodoResponse>> readAll(){
		System.out.println("readAll");
		List<TodoEntity> list = service.searchAll();
		
		// Entity를 dto로 변환
		List<TodoResponse> response = list.stream().map(TodoResponse::new).collect(Collectors.toList());
		// new는 new TodoResponse(todoEntity) => 생성자를 통해 생성
		System.out.println("selectAll result: " + ResponseEntity.ok(response));
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TodoResponse> readOne(@PathVariable("id")Integer id){
		System.out.println("readAll");
		TodoEntity list = service.searchById(id);
		
		// Entity를 dto로 변환
		return ResponseEntity.ok(new TodoResponse(list));	// 생성자를 이용해 Entity를 Dto로 변환 후 반환
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<TodoEntity> update(@PathVariable("id")Integer id, @RequestBody TodoRequest request){
		System.out.println("update");
		TodoEntity entity = service.updateById(id, request);
		System.out.println("update one: " + ResponseEntity.ok(entity));

		return ResponseEntity.ok(entity);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteOne(@PathVariable("id")Integer id){
		System.out.println("deleteOne");
		service.deleteById(id);
		System.out.println("deleteOne: " + ResponseEntity.ok());
		
		return ResponseEntity.ok().build();	// 200 ok만 반환. 처리 성공만 알림
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteAll(){
		System.out.println("deleteAll");
		service.deleteAll();
		System.out.println("deleteAll: " + ResponseEntity.ok());
		
		return ResponseEntity.ok().build();	// 200 ok만 반환. 처리 성공만 알림
	}
}
