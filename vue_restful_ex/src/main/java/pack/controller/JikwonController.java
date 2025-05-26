package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.JikwonDto;
import pack.repository.JikwonProcess;

@RequestMapping("/jikwons")
@RestController
public class JikwonController {
	@Autowired
	private JikwonProcess jikwonProcess;

	@GetMapping
	public ResponseEntity<List<JikwonDto>> getJikwonAll(){
		List<JikwonDto> jikwons = jikwonProcess.getJikwonAll();
		return ResponseEntity.ok(jikwons);
	}
}
