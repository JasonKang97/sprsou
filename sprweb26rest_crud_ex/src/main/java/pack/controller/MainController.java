package pack.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pack.model.ProcessDao;
import pack.model.SangdataDto;

@RestController
@RequestMapping("/main")
public class MainController {
	@Autowired
	private ProcessDao dao;
	
	@GetMapping("/list")
	public List<SangdataDto> listProcess(){
		return dao.getDataAll();
	}
	
	@PostMapping("/insert")
	public Map<String, Object> insertProcess(@RequestBody SangdataBean bean){
		dao.insert(bean);
		return Map.of("isSuccess", true);
	}
	
	@PutMapping("/update")
	public Map<String, Object> updateProcess(@RequestBody SangdataBean bean) {
		if(dao.getDate(bean.getCode())!=null) {
			dao.update(bean);
			return Map.of("isSuccess", true);
		}else {
			return Map.of("isSuccess", false);
		}
		
	}
	
	@DeleteMapping("/delete")
	public String deleteProcess(@RequestParam("code") int code) {
		if(dao.delete(code).equals("success")) {
			return "success";
		}else{
			return "fail";
		}
	}
	
}
