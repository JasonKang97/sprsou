package pack.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pack.model.DataProcess;
import pack.model.Mem;

@RestController
@RequestMapping("/api")	// 요청 endpoint 경로에 /api를 prefix로 지정
public class MemController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/members")
	public List<Mem> listProcess(){
		return dataProcess.getDataAll();
	}
	
	@PutMapping("/members")	// 자료 수정
	public Map<String, Object> updateProcess(@RequestBody MemBean bean){
		dataProcess.update(bean);
		return Map.of("isSuccess", true);	// Map 타입 {"isSuccess":true} 형태로 직렬화
	}
	
	@PostMapping("/members")	// 자료 추가
	public Map<String, Object> insertProcess(@RequestBody MemBean bean){
		dataProcess.insert(bean);
		return Map.of("isSuccess", true);	// Map 타입 {"isSuccess":true} 형태로 직렬화
	}
	
	@DeleteMapping("/members/{num}")	// 자료 삭제
	public Map<String, Object> deleteProcess(@PathVariable("num") int num){
		dataProcess.delete(num);
		return Map.of("isSuccess", true);	// Map 타입 {"isSuccess":true} 형태로 직렬화
	}
}
