package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.ProcessDao;

@Controller
@RequestMapping("/view")
public class ViewController {
	@Autowired
	private ProcessDao dao;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/insert")
	public String insertPage(Model model) {
		model.addAttribute("max", dao.getMaxCode());
		return "insert";
	}
	
	@GetMapping("/updateselect")
	public String updateselectPage() {
		return "updateselect";
	}
	
	@GetMapping("/update")
	public String updatePage(Model model, @RequestParam("code") int code) {
		model.addAttribute("data", dao.getDate(code));
		return "update";
	}
	
	@GetMapping("/delete")
	public String deletePage() {
		
		return "delete";
	}
}
