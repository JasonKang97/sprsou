package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.BuserDto;
import pack.repository.BuserProcess;

@RequestMapping("/busers")
@RestController
public class BuserController {
	@Autowired
	private BuserProcess buserProcess;
	
	@GetMapping
	public ResponseEntity<List<BuserDto>> getAll(){
		List<BuserDto> busers = buserProcess.getAll();
		return ResponseEntity.ok(busers);
	}
	
	@GetMapping("/{buserno}")
	public ResponseEntity<BuserDto> getData(@PathVariable("buserno") int buserno){
		BuserDto buser = buserProcess.getData(buserno);
		
		if(buser != null) {
			return ResponseEntity.ok(buser);	// 200 반환
		}else {
			return ResponseEntity.notFound().build();	// 404를 반환
		}
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody BuserDto dto){
		buserProcess.insert(dto);
		return ResponseEntity.ok("insert success");
	}
	
	@PutMapping("/{buserno}")
	public ResponseEntity<String> update(@PathVariable("buserno") int buserno, @RequestBody BuserDto dto){
		// 수정 대상 읽기
		BuserDto existBuser = buserProcess.getData(buserno);
		
		if(existBuser == null) {
			return ResponseEntity.notFound().build();
		}
		
		// 수정 진행
		dto.setBuserno(buserno);
		buserProcess.update(dto);
		return ResponseEntity.ok("update success");
	}
	
	@DeleteMapping("/{buserno}")
	public ResponseEntity<String> delete(@PathVariable("buserno") int buserno){
		// 삭제 대상 읽기
		BuserDto existBuser = buserProcess.getData(buserno);
		
		if(existBuser == null) {
			return ResponseEntity.notFound().build();
		}
		
		// 수정 진행
		buserProcess.delete(buserno);
		return ResponseEntity.ok("delete success");
	}
}
