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

import pack.dto.ProductDto;
import pack.repository.ProductProcess;

@RequestMapping("/products")
@RestController
public class ProductController {
	@Autowired
	private ProductProcess productProcess;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAll(){
		List<ProductDto> products = productProcess.getAll();
		return ResponseEntity.ok(products);	// 200 반환
		//return ResponseEntity.notFound().build();	// 404를 반환
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<ProductDto> getData(@PathVariable("code") String code){
		ProductDto product = productProcess.getData(code);
		
		if(product != null) {
			return ResponseEntity.ok(product);	// 200 반환
		}else {
			return ResponseEntity.notFound().build();	// 404를 반환
		}
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody ProductDto dto){
		productProcess.insert(dto);
		return ResponseEntity.ok("insert success");
	}
	
	@PutMapping("/{code}")
	public ResponseEntity<String> update(@PathVariable("code") String code, @RequestBody ProductDto dto){
		// 수정 대상 읽기
		ProductDto existProduct = productProcess.getData(code);
		
		if(existProduct == null) {
			return ResponseEntity.notFound().build();
		}
		
		// 수정 진행
		dto.setCode(code);
		productProcess.update(dto);
		return ResponseEntity.ok("update success");
	}
	
	@DeleteMapping("/{code}")
	public ResponseEntity<String> delete(@PathVariable("code") String code){
		// 삭제 대상 읽기
		ProductDto existProduct = productProcess.getData(code);
		
		if(existProduct == null) {
			return ResponseEntity.notFound().build();
		}
		
		// 수정 진행
		productProcess.delete(code);
		return ResponseEntity.ok("delete success");
	}
}
