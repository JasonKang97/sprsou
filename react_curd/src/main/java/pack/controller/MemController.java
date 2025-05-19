package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemDto;
import pack.repository.MemDao;

/*
@Controller
public class MemController {
	@Autowired
	private MemDao memDao;
	
	@GetMapping("/members")
	public String list(Model model) {
		List<MemDto> list = memDao.getList();
		model.addAttribute("list", list);
		return "list";
	}
}
*/

@RestController
public class MemController {
	@Autowired
	private MemDao memDao;
	
	@GetMapping("/members")
	public List<MemDto> list() {
		return memDao.getList();
	}
	
	@PostMapping("/members")
	public Map<String, Object> insert(@RequestBody MemDto dto) {
		memDao.insert(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		return map;
	}
	
	@GetMapping("/members/{num}")
	public MemDto list1(@PathVariable("num")int num) {
		return memDao.getData(num);
	}
	
	@PutMapping("/members/{num}")
	public Map<String, Object> update(@PathVariable("num")int num, @RequestBody MemDto dto){
		dto.setNum(num);
		memDao.update(dto);
		return Map.of("isSuccess", true);
	}
	
	@DeleteMapping("/members/{num}")
	public Map<String, Object> delete(@PathVariable("num")int num){
		memDao.delete(num);
		return Map.of("isSuccess", true);
	}
}





