package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.JikwonService;

@Controller
public class JikwonController {
	private JikwonService service;
	
	@Autowired
	public JikwonController(JikwonService service) {
		this.service = service;
	}
	
	@GetMapping("jikwonlist1")
	public String listJikwon(Model model) {
		model.addAttribute("jikwons", service.getJikwonDatas());
		return "jikwonlist";
	}
	
	@GetMapping("jikwonlist2")
	public String listJikwon2(Model model) {
		model.addAttribute("jikwons", service.getJikwonHighPay());
		return "jikwonlist";
	}
	
	@GetMapping("jikwonlist3")
	public String listJikwon3(Model model, @RequestParam("busername")String buserName) {
		model.addAttribute("jikwons", service.getAllBuserName(buserName));
		return "jikwonlist";
	}
	
	@GetMapping("jikwonlist4")
	public String listJikwon4(Model model) {
		model.addAttribute("jikwons", service.getTopPainJikwon());
		return "jikwonlist";
	}
}
