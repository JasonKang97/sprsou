package pack.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pack.dto.JikwonDto;
import pack.repository.JikwonDao;


@RestController
public class MainController {
	@Autowired
	private JikwonDao jikwonDao;
	
	@GetMapping("/jikwon")
	public List<JikwonDto> list() {
		return jikwonDao.getListYear();
	}
	
	@GetMapping("/jikwon/{jikwonno}")
	public JikwonDto list1(@PathVariable("jikwonno")int jikwonno) {
		return jikwonDao.getData(jikwonno);
	}
	
	@PutMapping("/jikwon/{jikwonno}")
	public Map<String, Object> update(@PathVariable("jikwonno")int jikwonno, @RequestBody JikwonDto dto){
		dto.setJikwonno(jikwonno);
		jikwonDao.update(dto);
		return Map.of("isSuccess", true);
	}
	
}





