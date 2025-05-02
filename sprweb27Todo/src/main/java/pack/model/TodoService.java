package pack.model;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import lombok.AllArgsConstructor;
import pack.controller.TodoRequest;

@Service	// @Repository 대신 사용하여도 무관하다.
@AllArgsConstructor
public class TodoService {

	private final TodoRepository repository;
	
	// 일정 관리 목록에 아이템 추가
	public TodoEntity add(TodoRequest request) {
		TodoEntity todoEntity = new TodoEntity();
		todoEntity.setTitle(request.getTitle());
		todoEntity.setOrder(request.getOrder());
		todoEntity.setComplited(request.getComplited());
		return repository.save(todoEntity);		// save는 제네릭으로 받은 타입을 반환
	}
	
	// 일정관리 목록 중 특정 아이템 조회
	public TodoEntity searchById(Integer id) {
		System.out.println("searchById: " + id);
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	// 일정관리 목록 전체 조회
	public List<TodoEntity> searchAll() {
		return repository.findAll();
	}
	
	// 일정관리 목록 중 특정 아이템 수정
	public TodoEntity updateById(Integer id, TodoRequest request) {
		TodoEntity todoEntity = searchById(id);	// 수정 대상 레코드 읽기
		
		if(request.getTitle()!=null) {
			todoEntity.setTitle(request.getTitle());	// 수정자료로 원본자료를 덮어쓰기
		}
		
		if(request.getOrder()!=null) {
			todoEntity.setOrder(request.getOrder());	// 수정자료로 원본자료를 덮어쓰기
		}
		
		if(request.getTitle()!=null) {
			todoEntity.setComplited(request.getComplited());	// 수정자료로 원본자료를 덮어쓰기
		}
		
		return repository.save(todoEntity);
	}
	
	// 일정관리 목록 중 특정 아이템 삭제
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	// 일정관리 목록 전체 아이템 삭제
	public void deleteAll() {
		repository.deleteAll();
	}

}
