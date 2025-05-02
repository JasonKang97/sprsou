package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pack.model.DataProcess;
import pack.model.Mem;

// HTML view controller
@Controller
@RequestMapping("/members")
public class MemViewController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list() {
		return "list";	// 목록보기 화면 호출
	}
	
	@GetMapping("/new")
	public String insert() {
		return "insert";	// 추가 화면 호출
	}
	
	@GetMapping("/update/{num}")
	public String update(@PathVariable("num")String num, Model model) {	// 수정 화면 호출
		Mem mem = dataProcess.getData(num);
		model.addAttribute("data", mem);
		return "update";
	}
}
